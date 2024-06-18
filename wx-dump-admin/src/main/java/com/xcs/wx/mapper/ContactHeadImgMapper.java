package com.xcs.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcs.wx.domain.ContactHeadImg;

/**
 * 联系人头像 Mapper
 *
 * @author xcs
 * @date 2024年6月18日15:33:26
 **/
public interface ContactHeadImgMapper extends BaseMapper<ContactHeadImg> {

    /**
     * 根据用户名查询联系人头像
     *
     * @param usrName 用户名
     * @return ContactHeadImg
     */
    ContactHeadImg getContactHeadImg(String usrName);
}
