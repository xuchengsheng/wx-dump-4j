package com.xcs.wx.msg.impl;

import cn.hutool.core.lang.Opt;
import com.xcs.wx.domain.bo.CompressContentBO;
import com.xcs.wx.domain.vo.CardLinkVO;
import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import com.xcs.wx.util.LZ4Util;
import com.xcs.wx.util.XmlUtil;
import org.springframework.stereotype.Service;

/**
 * 卡片式链接消息
 *
 * @author xcs
 * @date 2024年01月24日 13时56分
 **/
@Service
public class CardLinkMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 49 && subType == 5;
    }

    @Override
    public void process(MsgVO msgVO) {
        Opt.ofNullable(msgVO.getCompressContent())
                .map(compressContent -> LZ4Util.decompress(msgVO.getCompressContent()))
                .map(xmlContent -> XmlUtil.parseXml(xmlContent, CompressContentBO.class))
                .ifPresent(compressContentBO -> {
                    CardLinkVO cardLinkVO = new CardLinkVO();
                    cardLinkVO.setTitle(compressContentBO.getAppMsg().getTitle());
                    cardLinkVO.setDes(compressContentBO.getAppMsg().getDes());
                    cardLinkVO.setSourceDisplayName(compressContentBO.getAppMsg().getSourceDisplayName());
                    cardLinkVO.setUrl(compressContentBO.getAppMsg().getUrl());
                    msgVO.setCardLink(cardLinkVO);
                    msgVO.setStrContent("[卡片链接]");
                });
    }
}
