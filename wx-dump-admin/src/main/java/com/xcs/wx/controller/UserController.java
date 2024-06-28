package com.xcs.wx.controller;

import com.xcs.wx.domain.vo.UserInfoVO;
import com.xcs.wx.domain.vo.UserVO;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.domain.vo.WeChatConfigVO;
import com.xcs.wx.service.UserService;
import com.xcs.wx.service.WeChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * UserController
 *
 * @author xcs
 * @date 2024年6月15日16:05:49
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final WeChatService weChatService;

    /**
     * 查询微信信息
     *
     * @return ResponseVO
     */
    @GetMapping("/readWeChatConfig")
    public ResponseVO<List<WeChatConfigVO>> readWeChatConfig() {
        return ResponseVO.ok(weChatService.readWeChatConfig());
    }

    /**
     * 用户头像
     *
     * @return ResponseVO
     */
    @GetMapping("/userInfo")
    public ResponseVO<UserInfoVO> userInfo() {
        return ResponseVO.ok(userService.userInfo());
    }

    /**
     * 用户头像
     *
     * @return ResponseVO
     */
    @GetMapping("/avatar")
    public ResponseVO<String> avatar() {
        return ResponseVO.ok(userService.avatar());
    }

    /**
     * 用户昵称
     *
     * @return ResponseVO
     */
    @GetMapping("/nickname")
    public ResponseVO<String> nickname() {
        return ResponseVO.ok(userService.nickname());
    }

    /**
     * 所有用户
     *
     * @return ResponseVO
     */
    @GetMapping("/users")
    public ResponseVO<List<UserVO>> users() {
        return ResponseVO.ok(userService.users());
    }

    /**
     * 切换用户
     *
     * @param wxId wxId
     * @return ResponseVO
     */
    @PutMapping("/switchUser")
    public ResponseVO<String> switchUser(String wxId) {
        userService.switchUser(wxId);
        return ResponseVO.ok("切换成功");
    }
}
