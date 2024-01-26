package com.xcs.wx.controller;

import com.xcs.wx.domain.vo.*;
import com.xcs.wx.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 仪表盘 Controller
 *
 * @author xcs
 * @date 2024年01月15日 11时26分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashBoardService;

    /**
     * 统计面板
     *
     * @return ResponseVO
     */
    @GetMapping("/statsPanel")
    public ResponseVO<StatsPanelVO> statsPanel() {
        return ResponseVO.ok(dashBoardService.statsPanel());
    }

    /**
     * 微信消息类型及其分布统计
     *
     * @return ResponseVO
     */
    @GetMapping("/msgTypeDistribution")
    public ResponseVO<List<MsgTypeDistributionVO>> msgTypeDistribution() {
        return ResponseVO.ok(dashBoardService.msgTypeDistribution());
    }

    /**
     * 统计过去 15 天每天的发送和接收消息数量
     *
     * @return ResponseVO
     */
    @GetMapping("/countRecentMsgs")
    public ResponseVO<List<CountRecentMsgsVO>> countRecentMsgs() {
        return ResponseVO.ok(dashBoardService.countRecentMsgs());
    }

    /**
     * 最近一个月内微信互动最频繁的前10位联系人
     *
     * @return ResponseVO
     */
    @GetMapping("/topContacts")
    public ResponseVO<List<TopContactsVO>> topContacts() {
        return ResponseVO.ok(dashBoardService.topContacts());
    }

    /**
     * 查询最近使用的关键字
     *
     * @return ResponseVO
     */
    @GetMapping("/queryRecentUsedKeyWord")
    public ResponseVO<List<RecentUsedKeyWordVO>> queryRecentUsedKeyWord() {
        return ResponseVO.ok(dashBoardService.queryRecentUsedKeyWord());
    }
}
