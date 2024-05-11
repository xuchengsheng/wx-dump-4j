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
        Opt.ofNullable(msgVO.getBytesExtra())
                .map(xmlContent -> new String(msgVO.getBytesExtra()))
                .ifPresent(extra -> {
                    String image = extra.substring(extra.indexOf("}") + 1, extra.indexOf(".dat") + 4);
                    String thumb = extra.substring(extra.lastIndexOf(image.substring(0, image.indexOf("\\"))), extra.lastIndexOf(".dat") + 4);
                    msgVO.setImage(image);
                    msgVO.setThumb(thumb);
                    msgVO.setStrContent("[图片]");
                });
    }
}
