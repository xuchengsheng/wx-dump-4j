package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.xcs.wx.domain.dto.ContactDTO;
import com.xcs.wx.domain.vo.*;
import com.xcs.wx.mapping.ContactLabelMapping;
import com.xcs.wx.repository.ContactLabelRepository;
import com.xcs.wx.repository.ContactRepository;
import com.xcs.wx.service.ContactService;
import com.xcs.wx.util.DirUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 联系人服务实现类
 *
 * @author xcs
 * @date 2023年12月22日 14时42分
 **/
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactLabelRepository contactLabelRepository;
    private final ContactLabelMapping contactLabelMapping;

    @Override
    public PageVO<ContactVO> queryContact(ContactDTO contactDTO) {
        // 分页查询联系人
        return Optional.ofNullable(contactRepository.queryContact(contactDTO))
                .map(page -> {
                    Map<String, String> contactLabelMap = contactLabelRepository.queryContactLabelAsMap();
                    for (ContactVO contactVO : page.getRecords()) {
                        // 分割当前联系人标签
                        List<String> labels = Arrays.stream(contactVO.getLabelIdList().split(","))
                                .map(contactLabelMap::get)
                                .filter(StrUtil::isNotBlank)
                                .collect(Collectors.toList());
                        // 设置标签
                        contactVO.setLabels(labels);
                    }
                    // 返回分页数据
                    return new PageVO<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords());
                })
                // 默认值
                .orElse(new PageVO<>(contactDTO.getCurrent(), contactDTO.getPageSize(), 0L, null));
    }

    @Override
    public List<AllContactVO> queryAllContact() {
        return contactRepository.queryAllContact();
    }

    @Override
    public List<ContactLabelVO> queryContactLabel() {
        // 查询标签
        return Optional.ofNullable(contactLabelRepository.queryContactLabelAsList())
                // 转换参数
                .map(contactLabelMapping::convert)
                // 设置默认值
                .orElse(Collections.emptyList());
    }

    @Override
    public String exportContact() {
        // 文件路径
        String filePath = DirUtil.getExportDir("微信好友.xlsx");
        // 创建文件
        FileUtil.mkdir(new File(filePath).getParent());
        // 导出
        EasyExcel.write(filePath, ExportContactVO.class)
                .sheet("sheet1")
                .doWrite(contactRepository::exportContact);
        // 返回写入后的文件
        return filePath;
    }
}
