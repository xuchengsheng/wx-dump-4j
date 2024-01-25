package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.Session;
import com.xcs.wx.domain.vo.SessionVO;
import com.xcs.wx.mapper.SessionMapper;
import com.xcs.wx.repository.SessionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会话Repository 实现类
 *
 * @author xcs
 * @date 2023年12月21日 17时19分
 **/
@Repository
@DS(value = DataSourceType.MICRO_MSG_DB)
public class SessionRepositoryImpl extends ServiceImpl<SessionMapper, Session> implements SessionRepository {

    @Override
    public List<SessionVO> querySession() {
        return getBaseMapper().querySession();
    }
}
