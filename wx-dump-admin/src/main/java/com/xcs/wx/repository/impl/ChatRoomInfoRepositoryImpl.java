package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.ChatRoomInfo;
import com.xcs.wx.mapper.ChatRoomInfoMapper;
import com.xcs.wx.repository.ChatRoomInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * 群聊详情 Repository 实现类
 *
 * @author xcs
 * @date 2023年12月21日18:38:19
 */
@Repository
@DS(value = DataSourceType.MICRO_MSG_DB)
public class ChatRoomInfoRepositoryImpl extends ServiceImpl<ChatRoomInfoMapper, ChatRoomInfo> implements ChatRoomInfoRepository {

    @Override
    public ChatRoomInfo queryChatRoomInfo(String chatRoomName) {
        return super.getById(chatRoomName);
    }
}
