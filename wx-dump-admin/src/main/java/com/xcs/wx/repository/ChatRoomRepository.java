package com.xcs.wx.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcs.wx.domain.ChatRoom;
import com.xcs.wx.domain.dto.ChatRoomDTO;
import com.xcs.wx.domain.vo.ChatRoomVO;
import com.xcs.wx.domain.vo.ExportChatRoomVO;

import java.util.List;

/**
 * 群聊 Repository
 *
 * @author xcs
 * @date 2023年12月21日18:38:19
 */
public interface ChatRoomRepository {

    /**
     * 查询群聊
     *
     * @param chatRoomDTO 查询条件
     * @return ChatRoom
     */
    Page<ChatRoomVO> queryChatRoom(ChatRoomDTO chatRoomDTO);

    /**
     * 查询群聊详情
     *
     * @param chatRoomName 群聊名称
     * @return ChatRoom
     */
    ChatRoom queryChatRoomDetail(String chatRoomName);

    /**
     * 统计群聊数量
     *
     * @return 群聊总数
     */
    int countChatRoom();

    /**
     * 导出群聊
     *
     * @return ExportChatRoomVO
     */
    List<ExportChatRoomVO> exportChatRoom();

    /**
     * 查询最近5天内消息最频繁的前5个群聊
     *
     * @return 群聊名称和消息数量
     */
    @Query(value = "SELECT gc.name, COUNT(m.id) AS message_count " +
                   "FROM group_chat gc " +
                   "JOIN message m ON gc.id = m.chat_id " +
                   "WHERE m.timestamp >= CURRENT_DATE - INTERVAL 5 DAY " +
                   "GROUP BY gc.id, gc.name " +
                   "ORDER BY message_count DESC " +
                   "LIMIT 5", nativeQuery = true)
    List<Object[]> findTopGroupChatsLast5Days();
}
