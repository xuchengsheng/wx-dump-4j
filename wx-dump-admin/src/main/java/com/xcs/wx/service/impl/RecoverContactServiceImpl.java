package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import com.xcs.wx.domain.FTSContactContent;
import com.xcs.wx.domain.dto.RecoverContactDTO;
import com.xcs.wx.domain.vo.RecoverContactVO;
import com.xcs.wx.mapping.RecoverContactMapping;
import com.xcs.wx.repository.ContactRepository;
import com.xcs.wx.repository.FTSContactContentRepository;
import com.xcs.wx.service.RecoverContactService;
import com.xcs.wx.util.DirUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 找回联系人服务 实现类
 *
 * @author xcs
 * @date 2024年6月14日15:32:10
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RecoverContactServiceImpl implements RecoverContactService {

    private final FTSContactContentRepository ftsContactContentRepository;
    private final ContactRepository contactRepository;
    private final RecoverContactMapping recoverContactMapping;

    @Override
    public List<RecoverContactVO> queryRecoverContact(RecoverContactDTO recoverContactDTO) {
        List<FTSContactContent> ftsContactContents = ftsContactContentRepository.queryContactContent(recoverContactDTO);
        Set<String> set = contactRepository.getContactWithMp();
        return ftsContactContents.stream()
                .filter(ftsContent -> !set.contains(ftsContent.getAlias()))
                .map(recoverContactMapping::convert)
                .collect(Collectors.toList());
    }

    @Override
    public String exportRecoverContact() {
        // 文件路径
        String filePath = DirUtil.getExportDir("已删除好友.xlsx");
        // 创建文件
        FileUtil.mkdir(new File(filePath).getParent());
        // 导出
        EasyExcel.write(filePath, RecoverContactVO.class)
                .sheet("sheet1")
                .doWrite(() -> queryRecoverContact(new RecoverContactDTO()));
        // 返回写入后的文件
        return filePath;
    }
}
