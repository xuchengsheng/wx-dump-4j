package com.xcs.wx.service;

import com.xcs.wx.domain.dto.ContactDTO;
import com.xcs.wx.domain.vo.AllContactVO;
import com.xcs.wx.domain.vo.ContactLabelVO;
import com.xcs.wx.domain.vo.ContactVO;
import com.xcs.wx.domain.vo.PageVO;

import java.util.List;

/**
 * 联系人服务
 *
 * @author xcs
 * @date 2023年12月22日14:49:52
 */
public interface ContactService {

    /**
     * 查询联系人
     *
     * @param contactDTO 查询条件
     * @return ContactVO
     */
    PageVO<ContactVO> queryContact(ContactDTO contactDTO);

    /**
     * 查询所有联系人
     *
     * @return AllContactVO
     */
    List<AllContactVO> queryAllContact();

    /**
     * 查询联系人标签
     *
     * @return ContactLabel
     */
    List<ContactLabelVO> queryContactLabel();

    /**
     * 导出联系人
     *
     * @return 联系人excel地址
     */
    String exportContact();
}
