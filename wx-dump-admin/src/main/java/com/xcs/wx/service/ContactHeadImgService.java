package com.xcs.wx.service;

/**
 * 联系人头像
 *
 * @author xcs
 * @date 2023年12月31日18:18:58
 */
public interface ContactHeadImgService {

    /**
     * 头像
     *
     * @param userName 用户名
     * @return 头像字节
     */
    byte[] avatar(String userName);
}
