package com.xcs.wx.msg.impl;

import cn.hutool.core.lang.Opt;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.xcs.wx.domain.bo.CompressContentBO;
import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import com.xcs.wx.util.LZ4Util;
import com.xcs.wx.util.XmlUtil;
import org.springframework.stereotype.Service;

/**
 * 引用消息
 *
 * @author xcs
 * @date 2024年01月24日 13时53分
 **/
@Service
public class ReferMsgStrategy implements MsgStrategy {

    @Override
    public boolean support(Integer type, Integer subType) {
        return type == 49 && subType == 57;
    }

    @Override
    public void process(MsgVO msgVO) {
        Opt.ofNullable(msgVO.getCompressContent())
                .map(compressContent -> LZ4Util.decompress(msgVO.getCompressContent()))
                .map(xmlContent -> XmlUtil.parseXml(xmlContent, CompressContentBO.class))
                .ifPresent(compressContentBO -> msgVO.setStrContent(compressContentBO.getAppMsg().getTitle()))
                .ifPresent(compressContentBO -> handleReferMsg(msgVO, compressContentBO));
    }

    /**
     * 处理引用消息
     *
     * @param msgVO             消息VO
     * @param compressContentBO 压缩内容 BO
     */
    private void handleReferMsg(MsgVO msgVO, CompressContentBO compressContentBO) {
        Opt.ofNullable(compressContentBO)
                .map(CompressContentBO::getAppMsg)
                .map(CompressContentBO.AppMsg::getReferMsg)
                .ifPresent(referMsg -> {
                    try {
                        String content = null;
                        if (referMsg.getType() == 49) {
                            CompressContentBO refCompressContentBO = XmlUtil.parseXml(referMsg.getContent(), CompressContentBO.class);
                            // 空校验
                            if (ObjUtil.isNotEmpty(refCompressContentBO) && ObjUtil.isNotEmpty(refCompressContentBO.getAppMsg())) {
                                content = refCompressContentBO.getAppMsg().getTitle();
                            }
                        } else if (referMsg.getType() == 47) {
                            content = "[动画表情]";
                        } else if (referMsg.getType() == 3) {
                            content = "[图片]";
                        } else if (referMsg.getType() == 34) {
                            content = "[语音]";
                        } else if (referMsg.getType() == 43) {
                            content = "[视频]";
                        } else {
                            content = referMsg.getContent();
                        }
                        if (StrUtil.isEmpty(content)) {
                            content = "None";
                        }
                        msgVO.setReferMsgContent(referMsg.getDisplayName() + "：" + content.replace("�", ""));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
