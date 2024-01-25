package com.xcs.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcs.wx.domain.Session;
import com.xcs.wx.domain.vo.SessionVO;

import java.util.List;

/**
 * 会话 Mapper
 *
 * @author xcs
 * @date 2023年12月21日 17时08分
 **/
public interface SessionMapper extends BaseMapper<Session> {

    /**
     * 查询会话
     *
     * @return
     */
    List<SessionVO> querySession();
}