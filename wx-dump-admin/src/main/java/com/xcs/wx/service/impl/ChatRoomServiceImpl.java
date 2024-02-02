package com.xcs.wx.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.util.ObjUtil;
import com.alibaba.excel.EasyExcel;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xcs.wx.domain.ChatRoomInfo;
import com.xcs.wx.domain.dto.ChatRoomDTO;
import com.xcs.wx.domain.vo.*;
import com.xcs.wx.mapping.ChatRoomMapping;
import com.xcs.wx.protobuf.ChatRoomProto;
import com.xcs.wx.repository.ChatRoomInfoRepository;
import com.xcs.wx.repository.ChatRoomRepository;
import com.xcs.wx.repository.ContactHeadImgUrlRepository;
import com.xcs.wx.repository.ContactRepository;
import com.xcs.wx.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 群聊服务实现类
 *
 * @author xcs
 * @date 2023年12月31日18:18:58
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMapping chatRoomMapping;
    private final ContactRepository contactRepository;
    private final ChatRoomInfoRepository chatRoomInfoRepository;
    private final ContactHeadImgUrlRepository contactHeadImgUrlRepository;

    @Override
    public PageVO<ChatRoomVO> queryChatRoom(ChatRoomDTO chatRoomDTO) {
        // 查询群聊
        return Opt.ofNullable(chatRoomRepository.queryChatRoom(chatRoomDTO))
                .map(page -> {
                    // 设置群聊人数
                    for (ChatRoomVO chatRoom : page.getRecords()) {
                        chatRoom.setMemberCount(handleMembersCount(chatRoom.getRoomData()));
                    }
                    return page;
                })
                // 返回分页数据
                .map(page -> new PageVO<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords()))
                // 默认值
                .orElse(new PageVO<>(chatRoomDTO.getCurrent(), chatRoomDTO.getPageSize(), 0L, null));
    }

    @Override
    public ChatRoomDetailVO queryChatRoomDetail(String chatRoomName) {
        // 查询群聊详情
        return Opt.ofNullable(chatRoomRepository.queryChatRoomDetail(chatRoomName))
                // 转换参数
                .map(chatRoomMapping::convert)
                // 填充其他参数
                .ifPresent(this::populateChatRoomDetails)
                // 填充群公告
                .ifPresent(this::populateChatRoomInfo)
                // 填充群成员
                .ifPresent(this::populateChatRoomMember)
                // 设置默认值
                .orElse(null);
    }

    @Override
    public String exportChatRoom() {
        // 分隔符
        String separator = System.getProperty("file.separator");
        // 文件路径
        String filePath = System.getProperty("user.dir") + separator + "export";
        // 创建文件
        FileUtil.mkdir(filePath);
        // 文件路径+文件名
        String pathName = filePath + separator + DateUtil.format(DateUtil.date(), "yyyyMMddHHmmss") + "群聊" + ".xlsx";
        // 导出
        EasyExcel.write(pathName, ExportChatRoomVO.class)
                .sheet("sheet1")
                .doWrite(() -> {
                    List<ExportChatRoomVO> exportChatRoomVOS = chatRoomRepository.exportChatRoom();
                    // 设置群聊人数
                    for (ExportChatRoomVO exportChatRoomVO : exportChatRoomVOS) {
                        exportChatRoomVO.setMemberCount(handleMembersCount(exportChatRoomVO.getRoomData()));
                    }
                    return exportChatRoomVOS;
                });
        // 返回写入后的文件
        return pathName;
    }

    /**
     * 填充群聊信息
     *
     * @param chatRoomDetailVo 群聊详情VO
     */
    private void populateChatRoomDetails(ChatRoomDetailVO chatRoomDetailVo) {
        // 群标题
        chatRoomDetailVo.setChatRoomTitle(contactRepository.getContactNickname(chatRoomDetailVo.getChatRoomName()));
        // 创建人
        chatRoomDetailVo.setCreateBy(contactRepository.getContactNickname(chatRoomDetailVo.getReserved2()));
        // 群头像
        chatRoomDetailVo.setHeadImgUrl(contactHeadImgUrlRepository.queryHeadImgUrlByUserName(chatRoomDetailVo.getChatRoomName()));
    }

    /**
     * 填充群公告
     *
     * @param chatRoomDetailVo 群聊详情VO
     */
    private void populateChatRoomInfo(ChatRoomDetailVO chatRoomDetailVo) {
        // 查询群公告
        ChatRoomInfo chatRoomInfo = chatRoomInfoRepository.queryChatRoomInfo(chatRoomDetailVo.getChatRoomName());
        // 转换参数
        ChatRoomInfoVO chatRoomInfoVO = chatRoomMapping.convert(chatRoomInfo);
        // 发布时间
        Long announcementPublishTime = chatRoomInfoVO.getAnnouncementPublishTime();
        // 处理发布时间
        if (ObjUtil.isNotEmpty(announcementPublishTime) && announcementPublishTime > 0) {
            chatRoomInfoVO.setStrAnnouncementPublishTime(DateUtil.formatDateTime(new Date(announcementPublishTime * 1000L)));
        }
        // 发布人
        chatRoomInfoVO.setAnnouncementPublisher(contactRepository.getContactNickname(chatRoomInfoVO.getAnnouncementEditor()));
        // 设置群聊公告
        chatRoomDetailVo.setChatRoomInfo(chatRoomInfoVO);
    }

    /**
     * 填充群成员
     *
     * @param chatRoomDetailVo 群聊详情VO
     */
    private void populateChatRoomMember(ChatRoomDetailVO chatRoomDetailVo) {
        try {
            // 使用protobuf解析RoomData字段
            ChatRoomProto.ChatRoom chatRoom = ChatRoomProto.ChatRoom.parseFrom(chatRoomDetailVo.getRoomData());
            // 获得群成员
            List<ChatRoomProto.Member> membersList = chatRoom.getMembersList();
            // 群成员的微信Id
            List<String> memberWxIds = membersList.stream().map(ChatRoomProto.Member::getWxId).collect(Collectors.toList());
            // 群成员头像
            Map<String, String> headImgUrlMap = contactHeadImgUrlRepository.queryHeadImgUrl(memberWxIds);
            // 群成员昵称
            Map<String, String> contactNicknameMap = contactRepository.getContactNickname(memberWxIds);
            // 群成员
            chatRoomDetailVo.setMembers(chatRoomMapping.convert(membersList, headImgUrlMap, contactNicknameMap));
        } catch (InvalidProtocolBufferException e) {
            log.error("解析RoomData失败,群聊名称:{},群聊标题:{},错误信息:{}", chatRoomDetailVo.getChatRoomName(), chatRoomDetailVo.getChatRoomTitle(), e);
        }
    }

    /**
     * 获取群聊人数
     *
     * @param roomData 群聊数据
     * @return 群聊人数
     */
    private Integer handleMembersCount(byte[] roomData) {
        // 使用protobuf解析RoomData字段
        ChatRoomProto.ChatRoom chatRoomProto = null;
        try {
            chatRoomProto = ChatRoomProto.ChatRoom.parseFrom(roomData);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        // 空校验
        if (chatRoomProto == null) {
            return 0;
        }
        return chatRoomProto.getMembersList().size();
    }
}
