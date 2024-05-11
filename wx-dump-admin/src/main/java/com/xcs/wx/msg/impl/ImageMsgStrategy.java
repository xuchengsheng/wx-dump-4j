package com.xcs.wx.msg.impl;

import cn.hutool.core.lang.Opt;
import cn.hutool.core.util.ReUtil;
import com.xcs.wx.domain.bo.MsgBO;
import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.msg.MsgStrategy;
import com.xcs.wx.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
                    String thumb = ReUtil.getGroup0("FileStorage\\\\MsgAttach\\\\[^\\\\]+\\\\Thumb\\\\[^\\\\]+\\\\[^\\\\]+\\.dat", extra);
                    String image = ReUtil.getGroup0("FileStorage\\\\MsgAttach\\\\[^\\\\]+\\\\Image\\\\[^\\\\]+\\\\[^\\\\]+\\.dat", extra);
                    msgVO.setImage(image);
                    msgVO.setThumb(thumb);
                    msgVO.setStrContent("[图片]");
                });
    }
}
