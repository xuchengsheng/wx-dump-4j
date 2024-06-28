package com.xcs.wx.controller;

import cn.hutool.system.SystemUtil;
import com.xcs.wx.domain.dto.DecryptDTO;
import com.xcs.wx.domain.vo.DatabaseVO;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

/**
 * 数据库 Controller
 *
 * @author xcs
 * @date 2024年01月20日 14时35分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/database")
public class DatabaseController {

    private final DatabaseService databaseService;

    /**
     * 数据库解密
     *
     * @return ResponseVO
     */
    @GetMapping("/decrypt")
    public SseEmitter decrypt(DecryptDTO decryptDTO) {
        SseEmitter emitter = new SseEmitter(0L);
        // 启动一个子线程，异步回调给前端
        new Thread(() -> {
            // 读取JDK版本号
            if (SystemUtil.getJavaInfo().getVersionInt() < 1100) {
                try {
                    emitter.send(ResponseVO.error(-1, "微信解密必须要求JDK11以上版本,请更换JDK版本。"), MediaType.APPLICATION_JSON);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    emitter.complete();
                }
                return;
            }
            databaseService.decrypt(emitter, decryptDTO);
        }).start();
        // 返回数据
        return emitter;
    }

    /**
     * 数据库解密
     *
     * @return ResponseVO
     */
    @GetMapping("/getDatabase")
    public ResponseVO<List<DatabaseVO>> decrypt(String wxId) {
        return ResponseVO.ok(databaseService.getDatabase(wxId));
    }
}
