package com.xcs.wx.controller;

import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.domain.vo.SessionVO;
import com.xcs.wx.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会话 Controller
 *
 * @author xcs
 * @date 2023年12月21日 17时38分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/session")
public class SessionController {

    private final SessionService sessionService;

    /**
     * 查询会话列表
     *
     * @return SessionVO
     */
    @GetMapping("/list")
    public ResponseVO<List<SessionVO>> list() {
        return ResponseVO.ok(sessionService.querySession());
    }
}
