package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.ChatRoom;
import com.xcs.wx.domain.dto.ChatRoomDTO;
import com.xcs.wx.domain.vo.ChatRoomVO;
import com.xcs.wx.domain.vo.ExportChatRoomVO;
import com.xcs.wx.mapper.ChatRoomMapper;
import com.xcs.wx.repository.ChatRoomRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 群聊 Repository 实现类
 *
 * @author xcs
 * @date 2023年12月21日18:38:19
 */
@Repository
@DS(value = DataSourceType.MICRO_MSG_DB)
public class ChatRoomRepositoryImpl extends ServiceImpl<ChatRoomMapper, ChatRoom> implements ChatRoomRepository {

    @Override
    public Page<ChatRoomVO> queryChatRoom(ChatRoomDTO chatRoomDTO) {
        return getBaseMapper().queryChatRoom(new Page<>(chatRoomDTO.getCurrent(), chatRoomDTO.getPageSize()), chatRoomDTO);
    }

    @Override
    public ChatRoom queryChatRoomDetail(String chatRoomName) {
        return super.getById(chatRoomName);
    }

    @Override
    public int countChatRoom() {
        return getBaseMapper().countChatRoom();
    }

    @Override
    public List<ExportChatRoomVO> exportChatRoom() {
        return getBaseMapper().exportChatRoom();
    }
}
