package com.xcs.wx.service;

import com.xcs.wx.domain.bo.UserBO;
import com.xcs.wx.domain.vo.UserInfoVO;
import com.xcs.wx.domain.vo.UserVO;

import java.util.List;

/**
 * 用户服务
 *
 * @author xcs
 * @date 2023年12月21日 17时16分
 **/
public interface UserService {

    /**
     * 用户信息
     *
     * @return 用户信息
     */
    UserInfoVO userInfo();

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
    List<UserVO> users();

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
     * 保存用户
     *
     * @param userBO 用户信息
     */
    void saveUser(UserBO userBO);

    /**
     * 获取微信存储路径
     *
     * @param wxId wxId
     */
    String getBasePath(String wxId);
}
