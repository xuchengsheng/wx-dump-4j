package com.xcs.wx.repository;

import com.xcs.wx.domain.vo.SessionVO;

import java.util.List;

/**
 * 会话 Repository
 *
 * @author xcs
 * @date 2023年12月21日17:33:19
 */
public interface SessionRepository {

    /**
     * 查询全部会话
     *
     * @return Session
     */
    List<SessionVO> querySession();
}
