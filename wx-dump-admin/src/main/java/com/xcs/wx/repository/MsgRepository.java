package com.xcs.wx.repository;

import com.xcs.wx.domain.Msg;
import com.xcs.wx.domain.vo.CountRecentMsgsVO;
import com.xcs.wx.domain.vo.MsgTypeDistributionVO;
import com.xcs.wx.domain.vo.TopContactsVO;

import java.util.List;

/**
 * 消息 Repository
 *
 * @author xcs
 * @date 2023年12月25日15:31:37
 */
public interface MsgRepository {

    /**
     * 获得最大的序列号
     *
     * @param poolName 连接池名称
     * @return 最大序列号
     */
    Long getNextSequence(String poolName);

    /**
     * 查询
     *
     * @param poolName     连接池名称
     * @param nextSequence 下一个序列号
     * @return Page
     */
    List<Msg> queryMsgBySequence(String poolName, Long nextSequence);

    /**
     * 批量插入数据
     *
     * @param poolName 数据源连接池名称
     * @param msg      需要保存的数据
     * @return 是否新增成功
     */
    boolean saveBatch(String poolName, List<Msg> msg);

    /**
     * 根据talker查询聊天记录
     *
     * @param talker     对话着
     * @param createTime 创建时间
     * @return Msg
     */
    List<Msg> queryMsgByTalker(String talker, Long createTime);

    /**
     * 导出数据
     *
     * @param talker 对话着
     * @return Msg
     */
    List<Msg> exportMsg(String talker);

    /**
     * 微信消息类型及其分布统计
     *
     * @return MsgTypeDistributionVO
     */
    List<MsgTypeDistributionVO> msgTypeDistribution();

    /**
     * 统计过去 15 天每天的发送和接收消息数量
     *
     * @return MsgTrendVO
     */
    List<CountRecentMsgsVO> countRecentMsgs();

    /**
     * 最近一个月内微信互动最频繁的前10位联系人
     *
     * @return MsgRankVO
     */
    List<TopContactsVO> topContacts();

    /**
     * 统计发送消息数量
     *
     * @return 消息数量
     */
    int countSent();

    /**
     * 统计接受消息数量
     *
     * @return 消息数量
     */
    int countReceived();
}
