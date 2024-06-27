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

/**
 * 联系人表情服务实现
 *
 * @author xcs
 * @date 2023年12月31日18:18:58
 */
@Service
@RequiredArgsConstructor
public class ContactLabelServiceImpl implements ContactLabelService {

    private final ContactLabelRepository contactLabelRepository;
    private final ContactLabelMapping contactLabelMapping;

    @Override
    public List<ContactLabelVO> queryContactLabel() {
        return Optional.ofNullable(contactLabelRepository.queryContactLabelAsList())
                .map(contactLabelMapping::convert)
                .orElse(Collections.emptyList());
    }
}
