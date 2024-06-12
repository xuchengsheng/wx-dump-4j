package com.xcs.wx.service;

import com.xcs.wx.domain.vo.MsgVO;

import java.util.List;

/**
 * 消息服务
 *
 * @author xcs
 * @date 2023年12月25日15:05:09
 */
public interface MsgService {

    /**
     * 查询消息
     *
     * @param talker     聊天人的Id
     * @param nextSequence 下一个序列号
     * @return MsgVO
     */
    List<MsgVO> queryMsg(String talker, Long nextSequence);

    /**
     * 导出聊天记录
     *
     * @param talker 聊天人的Id
     * @return 文件地址
     */
    String exportMsg(String talker);
}
