package com.xcs.wx.service;

import com.xcs.wx.domain.vo.ContactLabelVO;

import java.util.List;

/**
 * 联系人表情服务
 *
 * @author xcs
 * @date 2023年12月31日18:18:58
 */
public interface ContactLabelService {

    /**
     * 查询联系人标签
     *
     * @return ContactLabel
     */
    List<ContactLabelVO> queryContactLabel();
}
