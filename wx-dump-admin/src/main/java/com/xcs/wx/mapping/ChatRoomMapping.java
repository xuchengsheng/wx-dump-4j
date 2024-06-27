package com.xcs.wx.mapping;

import cn.hutool.core.util.StrUtil;
import com.xcs.wx.domain.ChatRoom;
import com.xcs.wx.domain.ChatRoomInfo;
import com.xcs.wx.domain.vo.ChatRoomDetailVO;
import com.xcs.wx.domain.vo.ChatRoomInfoVO;
import com.xcs.wx.domain.vo.ChatRoomMemberVO;
import com.xcs.wx.domain.vo.ChatRoomVO;
import com.xcs.wx.protobuf.ChatRoomProto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 群聊 Mapping
 *
 * @author xcs
 * @date 2024年01月08日 17时00分
 **/
@Mapper(componentModel = "spring")
public interface ChatRoomMapping {

    /**
     * 参数转换
     *
     * @param chatRooms 入参
     * @return ChatRoomVO
     */
    List<ChatRoomVO> convert(List<ChatRoom> chatRooms);

    /**
     * 转换参数
     *
     * @param chatRoom 入参
     * @return ChatRoomDetailVO
     */
    ChatRoomDetailVO convert(ChatRoom chatRoom);

    /**
     * 转换参数
     *
     * @param chatRoomInfo 入参
     * @return ChatRoomInfoVO
     */
    ChatRoomInfoVO convert(ChatRoomInfo chatRoomInfo);

    /**
     * 参数转换
     *
     * @param member 入参
     * @return ChatRoomMemberVO
     */
    ChatRoomMemberVO convert(ChatRoomProto.Member member);

    /**
     * 参数转换
     *
     * @param members            入参
     * @param headImgUrlMap      头像信息
     * @param contactNicknameMap 群昵称
     * @return ChatRoomMemberVO
     */
    default List<ChatRoomMemberVO> convert(List<ChatRoomProto.Member> members, Map<String, String> headImgUrlMap, Map<String, String> contactNicknameMap) {
        return members.stream()
                .map(this::convert)
                .peek(member -> member.setHeadImgUrl(headImgUrlMap.get(member.getWxId())))
                .peek(member -> {
                    // 如果存在群备注则不处理
                    if (StrUtil.isNotBlank(member.getRemark())) {
                        return;
                    }
                    // 设置群昵称
                    member.setRemark(contactNicknameMap.get(member.getWxId()));
                })
                .collect(Collectors.toList());
    }
}
