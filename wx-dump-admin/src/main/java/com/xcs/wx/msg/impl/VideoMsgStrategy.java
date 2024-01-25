package com.xcs.wx.msg.impl;

import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import org.springframework.stereotype.Service;

/**
 * 视频消息
 *
 * @author xcs
 * @date 2024年01月24日 13时52分
 **/
@Service
public class VideoMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 34 && subType == 0;
    }

    @Override
    public void process(MsgVO msgVO) {
        msgVO.setStrContent("[视频]");
    }
}
