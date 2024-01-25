package com.xcs.wx.service;

import com.xcs.wx.domain.dto.ChatRoomDTO;
import com.xcs.wx.domain.vo.ChatRoomDetailVO;
import com.xcs.wx.domain.vo.ChatRoomVO;
import com.xcs.wx.domain.vo.PageVO;

/**
 * 群聊服务
 *
 * @author xcs
 * @date 2023年12月31日18:18:58
 */
public interface ChatRoomService {

    /**
     * 查询群聊
     *
     * @param chatRoomDTO 查询条件
     * @return ChatRoomVO
     */
    PageVO<ChatRoomVO> queryChatRoom(ChatRoomDTO chatRoomDTO);

    /**
     * 查询群聊详情
     *
     * @param chatRoomName 群聊名称
     * @return ChatRoomDetailVO
     */
    ChatRoomDetailVO queryChatRoomDetail(String chatRoomName);

    /**
     * 导出群聊
     *
     * @return 群聊excel地址
     */
    String exportChatRoom();
}
