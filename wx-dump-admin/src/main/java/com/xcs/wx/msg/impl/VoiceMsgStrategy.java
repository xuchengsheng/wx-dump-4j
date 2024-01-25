package com.xcs.wx.msg.impl;

import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import org.springframework.stereotype.Service;

/**
 * 语音消息
 *
 * @author xcs
 * @date 2024年01月24日 13时51分
 **/
@Service
public class VoiceMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 43 && subType == 0;
    }

    @Override
    public void process(MsgVO msgVO) {
        msgVO.setStrContent("[语音]");
    }
}
