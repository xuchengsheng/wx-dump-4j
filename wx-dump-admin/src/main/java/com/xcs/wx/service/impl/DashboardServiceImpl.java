package com.xcs.wx.service.impl;

import cn.hutool.core.lang.Opt;
import com.xcs.wx.domain.vo.*;
import com.xcs.wx.repository.*;
import com.xcs.wx.service.DashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 仪表台服务实现类
 *
 * @author xcs
 * @date 2024年01月23日 17时24分
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final MsgRepository msgRepository;
    private final ContactRepository contactRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ContactHeadImgUrlRepository contactHeadImgUrlRepository;
    private final FTSRecentUsedRepository recentUsedRepository;

    @Override
    public StatsPanelVO statsPanel() {
        // 联系人数量
        long start1 = System.currentTimeMillis();
        int contact = contactRepository.countContact();
        long end1 = System.currentTimeMillis();
        System.out.println("countContact: " + (end1 - start1) + "ms");

        // 群聊数量
        long start2 = System.currentTimeMillis();
        int chatRoom = chatRoomRepository.countChatRoom();
        long end2 = System.currentTimeMillis();
        System.out.println("countChatRoom: " + (end2 - start2) + "ms");

        // 今日发送消息数量
        long start3 = System.currentTimeMillis();
        int sent = msgRepository.countSent();
        long end3 = System.currentTimeMillis();
        System.out.println("countSent: " + (end3 - start3) + "ms");

        // 今日接收消息数量
        long start4 = System.currentTimeMillis();
        int received = msgRepository.countReceived();
        long end4 = System.currentTimeMillis();
        System.out.println("countReceived: " + (end4 - start4) + "ms");

        // 返回数据
        return new StatsPanelVO(contact, chatRoom, sent, received);
    }

    @Override
    public List<MsgTypeDistributionVO> msgTypeDistribution() {
        // 微信消息类型及其分布统计
        return Opt.ofNullable(msgRepository.msgTypeDistribution())
                // 重新分组一次
                .map(msgTypes -> msgTypes.stream().collect(Collectors.groupingBy(MsgTypeDistributionVO::getType, Collectors.summingInt(MsgTypeDistributionVO::getValue))))
                // 聚合并返回List
                .map(summedMap -> summedMap.entrySet().stream().map(entry -> new MsgTypeDistributionVO(entry.getKey(), entry.getValue())).collect(Collectors.toList()))
                // 默认值
                .orElse(Collections.emptyList());
    }

    @Override
    public List<CountRecentMsgsVO> countRecentMsgs() {
        return msgRepository.countRecentMsgs();
    }

    @Override
    public List<TopContactsVO> topContacts() {
        // 最近一个月内微信互动最频繁的前10位联系人
        return Opt.ofNullable(msgRepository.topContacts())
                // 处理昵称&头像
                .map(topContacts -> {
                    // 获取所有的用户名
                    List<String> userNames = topContacts.stream().map(TopContactsVO::getUserName).collect(Collectors.toList());
                    // 联系人昵称
                    Map<String, String> nicknameMap = contactRepository.getContactNickname(userNames);
                    // 联系人头像
                    Map<String, String> headImgUrlMap = contactHeadImgUrlRepository.queryHeadImgUrl(userNames);
                    // 遍历处理
                    for (TopContactsVO topContact : topContacts) {
                        // 设置昵称
                        topContact.setNickName(nicknameMap.get(topContact.getUserName()));
                        // 设置头像
                        topContact.setHeadImgUrl(headImgUrlMap.get(topContact.getUserName()));
                    }
                    return topContacts;
                })
                // 默认值
                .orElse(Collections.emptyList());
    }

    @Override
    public List<RecentUsedKeyWordVO> queryRecentUsedKeyWord() {
        return recentUsedRepository.queryRecentUsedKeyWord()
                .stream()
                .map(RecentUsedKeyWordVO::new)
                .collect(Collectors.toList());
    }
}
