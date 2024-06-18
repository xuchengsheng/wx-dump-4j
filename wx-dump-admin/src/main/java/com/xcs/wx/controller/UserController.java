package com.xcs.wx.controller;

import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    /**
     * 用户头像
     *
     * @return SessionVO
     */
    @GetMapping("/avatar")
    public ResponseVO<String> avatar() {
        return ResponseVO.ok(userService.avatar());
    }
}
