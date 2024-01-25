package com.xcs.wx.service;

import com.xcs.wx.domain.vo.SessionVO;

import java.util.List;

/**
 * 会话服务
 *
 * @author xcs
 * @date 2023年12月21日 17时16分
 **/
public interface SessionService {

    /**
     * 查询会话
     *
     * @return SessionVO
     */
    List<SessionVO> querySession();
}
