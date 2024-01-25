package com.xcs.wx.msg.impl;

import cn.hutool.core.lang.Opt;
import com.xcs.wx.domain.bo.VoipMsgBO;
import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import com.xcs.wx.util.XmlUtil;
import org.springframework.stereotype.Service;

/**
 * 语音电话消息
 *
 * @author xcs
 * @date 2024年01月24日 14时00分
 **/
@Service
public class VoipMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 50 && subType == 0;
    }

    @Override
    public void process(MsgVO msgVO) {
        Opt.ofNullable(msgVO.getStrContent())
                .map(xmlContent -> XmlUtil.parseXml(xmlContent, VoipMsgBO.class))
                .ifPresent(voipMsgBO -> msgVO.setStrContent(voipMsgBO.getVoIPBubbleMsg().getMsg()));
    }
}
