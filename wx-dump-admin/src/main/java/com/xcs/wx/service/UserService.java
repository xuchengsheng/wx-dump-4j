package com.xcs.wx.service;

import com.xcs.wx.domain.bo.UserVO;

import java.util.List;

/**
 * 用户服务
 *
 * @author xcs
 * @date 2023年12月21日 17时16分
 **/
public interface UserService {

    /**
     * 用户头像
     *
     * @return 头像
     */
    String avatar();

    /**
     * 用户昵称
     *
     * @return 头像
     */
    String nickname();

    /**
     * 所有用户
     *
     * @return wxIds
     */
    List<UserVO> allUser();

    /**
     * 切换用户
     *
     * @param wxId wxId
     */
    void switchUser(String wxId);

    /**
     * 当前用户
     *
     * @return wxId
     */
    String currentUser();

    /**
     * 保存路径
     *
     * @param wxId     wxId
     * @param basePath 路径
     */
    void saveBasePath(String wxId, String basePath);

    /**
     * 获取微信存储路径
     *
     * @param wxId wxId
     */
    String getBasePath(String wxId);
}
