package com.xcs.wx.service;

import com.xcs.wx.domain.vo.WeChatVO;

/**
 * 微信服务
 *
 * @author xcs
 * @date 2023年12月25日09:37:30
 */
public interface WeChatService {

    /**
     * 获取微信信息
     *
     * @return WeChatDTO
     */
    WeChatVO queryWeChat();
}
