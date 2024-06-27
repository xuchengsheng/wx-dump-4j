package com.xcs.wx.repository;

import java.util.List;
import java.util.Map;

/**
 * 联系人头像 Repository
 *
 * @author xcs
 * @date 2023年12月21日18:38:19
 */
public interface ContactHeadImgUrlRepository {

    /**
     * 获取联系人头像
     *
     * @param usrNames 用户名
     * @return 头像列表
     */
    Map<String, String> queryHeadImgUrl(List<String> usrNames);

    /**
     * 通过用户名查询联系人头像
     *
     * @param userName 用户名
     * @return 联系人头像
     */
    String queryHeadImgUrlByUserName(String userName);
}
