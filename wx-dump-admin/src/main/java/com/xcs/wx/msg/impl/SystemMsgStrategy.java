package com.xcs.wx.msg.impl;

import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 系统消息
 *
 * @author xcs
 * @date 2024年01月24日 13时54分
 **/
@Service
public class SystemMsgStrategy implements MsgStrategy {

    private static final String REGEX = "<img src=\"SystemMessages_HongbaoIcon.png\"/>(.+)</_wc_custom_link_>";

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 10000 && subType == 0;
    }

    @Override
    public void process(MsgVO msgVO) {
        // 替换内容
        msgVO.setStrContent(msgVO.getStrContent().replaceAll("<revokemsg>|</revokemsg>", ""));
        // 使用正则表达式匹配需要的内容
        Pattern pattern = Pattern.compile(REGEX);
        // 对StrContent进行匹配
        Matcher matcher = pattern.matcher(msgVO.getStrContent());
        // 匹配成功
        if (matcher.find()) {
            // 提取匹配的文本
            String extractedText = matcher.group(1).trim();
            // 进一步处理以去除内部的HTML标签
            extractedText = extractedText.replaceAll("<[^>]+>", "").trim();
            // 设置消息内容
            msgVO.setStrContent(extractedText);
        }
    }
}
