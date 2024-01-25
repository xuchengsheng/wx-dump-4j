package com.xcs.wx.msg.impl;

import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import org.springframework.stereotype.Service;

/**
 * 地图消息
 *
 * @author xcs
 * @date 2024年01月24日 11时45分
 **/
@Service
public class MapMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 48 && subType == 0;
    }

    @Override
    public void process(MsgVO msgVO) {
        msgVO.setStrContent("[地图消息]");
    }
}
