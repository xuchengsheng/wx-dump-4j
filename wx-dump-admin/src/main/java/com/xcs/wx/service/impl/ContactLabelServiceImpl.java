package com.xcs.wx.service.impl;

import com.xcs.wx.domain.vo.ContactLabelVO;
import com.xcs.wx.mapping.ContactLabelMapping;
import com.xcs.wx.repository.ContactLabelRepository;
import com.xcs.wx.service.ContactLabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactLabelServiceImpl implements ContactLabelService {

    private final ContactLabelRepository contactLabelRepository;
    private final ContactLabelMapping contactLabelMapping;

    @Override
    public List<ContactLabelVO> queryContactLabel() {
        // 查询标签
        return Optional.ofNullable(contactLabelRepository.queryContactLabelAsList())
                // 转换参数
                .map(labels -> contactLabelMapping.convert(labels))
                // 设置默认值
                .orElse(Collections.emptyList());
    }
}
