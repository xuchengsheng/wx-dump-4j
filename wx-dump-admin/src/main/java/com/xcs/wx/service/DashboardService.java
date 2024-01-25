package com.xcs.wx.service;

import com.xcs.wx.domain.vo.*;

import java.util.List;

/**
 * 仪表台服务
 *
 * @author xcs
 * @date 2024年1月23日17:24:36
 */
public interface DashboardService {

    /**
     * 统计面板
     *
     * @return StatsPanelVO
     */
    StatsPanelVO statsPanel();

    /**
     * 消息类型分布
     *
     * @return MsgTypeDistributionVO
     */
    List<MsgTypeDistributionVO> msgTypeDistribution();

    /**
     * 消息趋势
     *
     * @return MsgTrendVO
     */
    List<CountRecentMsgsVO> countRecentMsgs();

    /**
     * 消息排行
     *
     * @return MsgTrendVO
     */
    List<TopContactsVO> topContacts();

    /**
     * 查询最近使用的关键字
     *
     * @return 返回关键字
     */
    List<RecentUsedKeyWordVO> queryRecentUsedKeyWord();
}
