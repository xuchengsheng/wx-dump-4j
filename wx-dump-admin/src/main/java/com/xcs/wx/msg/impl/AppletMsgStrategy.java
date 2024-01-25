package com.xcs.wx.msg.impl;

import cn.hutool.core.lang.Opt;
import com.xcs.wx.domain.bo.CompressContentBO;
import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.domain.vo.WeAppInfoVO;
import com.xcs.wx.msg.MsgStrategy;
import com.xcs.wx.util.LZ4Util;
import com.xcs.wx.util.XmlUtil;
import org.springframework.stereotype.Service;

/**
 * 小程序消息
 *
 * @author xcs
 * @date 2024年01月24日 13时55分
 **/
@Service
public class AppletMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 49 && (subType == 33 || subType == 36);
    }

    @Override
    public void process(MsgVO msgVO) {
        Opt.ofNullable(msgVO.getCompressContent())
                .map(compressContent -> LZ4Util.decompress(msgVO.getCompressContent()))
                .map(xmlContent -> XmlUtil.parseXml(xmlContent, CompressContentBO.class))
                .ifPresent(msgBO -> Opt.ofNullable(msgBO.getAppMsg())
                        .ifPresent(appMsg -> {
                            WeAppInfoVO weAppInfoVO = new WeAppInfoVO();
                            weAppInfoVO.setTitle(msgBO.getAppMsg().getTitle());
                            weAppInfoVO.setSourceDisplayName(msgBO.getAppMsg().getSourceDisplayName());
                            msgVO.setWeAppInfo(weAppInfoVO);
                            CompressContentBO.AppMsg.WeAppInfo weAppInfo = appMsg.getWeAppInfo();
                            if (weAppInfo != null) {
                                weAppInfoVO.setWeAppIconUrl(weAppInfo.getWeAppIconUrl());
                                weAppInfoVO.setWeAppPageThumbRawUrl(weAppInfo.getWeAppPageThumbRawUrl());
                            }
                        }));
    }
}
