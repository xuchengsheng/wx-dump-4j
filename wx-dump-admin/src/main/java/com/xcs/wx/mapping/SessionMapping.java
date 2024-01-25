package com.xcs.wx.mapping;

import com.xcs.wx.domain.Session;
import com.xcs.wx.domain.vo.SessionVO;
import org.mapstruct.Mapper;

/**
 * 会话 Mapping
 *
 * @author xcs
 * @date 2023年12月21日 18时46分
 **/
@Mapper(componentModel = "spring")
public interface SessionMapping {

    /**
     * 转换参数
     *
     * @param session 会话
     * @return SessionVO
     */
    SessionVO convert(Session session);
}
