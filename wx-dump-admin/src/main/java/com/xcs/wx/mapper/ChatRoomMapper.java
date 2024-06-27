package com.xcs.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcs.wx.domain.ChatRoom;
import com.xcs.wx.domain.dto.ChatRoomDTO;
import com.xcs.wx.domain.vo.ChatRoomVO;
import com.xcs.wx.domain.vo.ExportChatRoomVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 群聊 Mapper
 *
 * @author xcs
 * @date 2024年01月08日 15时55分
 **/
public interface ChatRoomMapper extends BaseMapper<ChatRoom> {

    /**
     * 查询群聊
     *
     * @param page        分页信息
     * @param chatRoomDTO 查询条件
     * @return ChatRoomVO
     */
    Page<ChatRoomVO> queryChatRoom(Page<ChatRoomVO> page, @Param("chatRoomDTO") ChatRoomDTO chatRoomDTO);

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
}
