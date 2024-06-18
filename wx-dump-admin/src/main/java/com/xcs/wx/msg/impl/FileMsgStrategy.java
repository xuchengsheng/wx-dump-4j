package com.xcs.wx.msg.impl;

import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import org.springframework.stereotype.Service;

/**
 * 文件消息
 *
 * @author xcs
 * @date 2024年6月14日10:48:20
 **/
@Service
public class FileMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 49 && subType == 6;
    }

    @Override
    public void process(MsgVO msgVO) {
        msgVO.setStrContent("[文件]");
    }
}
