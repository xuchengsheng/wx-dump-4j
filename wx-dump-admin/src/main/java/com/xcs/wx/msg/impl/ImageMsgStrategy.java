package com.xcs.wx.msg.impl;

import cn.hutool.core.lang.Opt;
import com.xcs.wx.domain.bo.MsgBO;
import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import com.xcs.wx.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 图片消息
 *
 * @author xcs
 * @date 2024年01月24日 11时46分
 **/
@Slf4j
@Service
public class ImageMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 3 && subType == 0;
    }

    @Override
    public void process(MsgVO msgVO) {
        Opt.ofNullable(msgVO.getStrContent())
                .map(xmlContent -> XmlUtil.parseXml(xmlContent, MsgBO.class))
                .ifPresent(msgBO -> {
                    msgVO.setStrContent("[图片]");
                    msgVO.setImgMd5(msgBO.getImg().getMd5());
                });
    }
}
