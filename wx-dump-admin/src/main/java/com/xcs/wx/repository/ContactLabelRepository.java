package com.xcs.wx.repository;

import com.xcs.wx.domain.ContactLabel;

import java.util.List;
import java.util.Map;

/**
 * 联系人标签 Repository
 *
 * @author xcs
 * @date 2023年12月22日17:27:24
 */
public interface ContactLabelRepository {

    /**
     * 查询联系人标签
     *
     * @return Map
     */
    Map<String, String> queryContactLabelAsMap();

    /**
     * 查询联系人标签
     *
     * @return ContactLabel
     */
    List<ContactLabel> queryContactLabelAsList();
}
