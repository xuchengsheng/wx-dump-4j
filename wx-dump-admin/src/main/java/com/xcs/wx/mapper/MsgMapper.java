package com.xcs.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcs.wx.domain.Msg;
import com.xcs.wx.domain.vo.CountRecentMsgsVO;
import com.xcs.wx.domain.vo.MsgTypeDistributionVO;
import com.xcs.wx.domain.vo.TopContactsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息 Mapper
 *
 * @author xcs
 * @date 2023年12月22日 13时51分
 **/
public interface MsgMapper extends BaseMapper<Msg> {

    /**
     * 获得最大的序列号
     *
     * @return 最大序列号
     */
    Long getNextSequence();

    /**
     * 根据数量与序列号获取消息
     *
     * @param nextSequence 序列号
     * @return Msg
     */
    List<Msg> queryMsgBySequence(@Param("nextSequence") Long nextSequence);

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
