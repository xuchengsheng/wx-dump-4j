package com.xcs.wx.service;

import com.xcs.wx.domain.dto.DecryptDTO;
import com.xcs.wx.domain.vo.DatabaseVO;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

/**
 * 注册数据源
 *
 * @author xcs
 * @date 2023年12月25日19:28:37
 */
public interface DatabaseService {

    /**
     * 数据库解密
     *
     * @param emitter    sse发送事件对象
     * @param decryptDTO 解密信息
     */
    void decrypt(SseEmitter emitter, DecryptDTO decryptDTO);

    /**
     * 获取数据库列表
     *
     * @param wxId wxId
     * @return DatabaseVO
     */
    List<DatabaseVO> getDatabase(String wxId);
}
