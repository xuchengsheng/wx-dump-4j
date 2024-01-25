package com.xcs.wx.repository;

import com.xcs.wx.domain.ChatRoomInfo;

/**
 * 群聊信息 Repository
 *
 * @author xcs
 * @date 2023年12月21日18:38:19
 */
public interface ChatRoomInfoRepository {

    /**
     * 查询群聊信息
     *
     * @param chatRoomName 群聊名称
     * @return ChatRoomInfo
     */
    ChatRoomInfo queryChatRoomInfo(String chatRoomName);
}
