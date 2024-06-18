package com.xcs.wx.repository;

/**
 * 联系人头像 Repository
 *
 * @author xcs
 * @date 2024年6月18日15:31:54
 */
public interface ContactHeadImgRepository {

    /**
     * 获取联系人头像
     *
     * @param usrName 用户名
     * @return 图片
     */
    byte[] getContactHeadImg(String usrName);
}
