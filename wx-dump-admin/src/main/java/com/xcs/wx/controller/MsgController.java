package com.xcs.wx.controller;

import com.xcs.wx.domain.vo.MsgVO;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.service.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 消息 Controller
 *
 * @author xcs
 * @date 2023年12月25日 17时06分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/msg")
public class MsgController {

    private final MsgService msgService;

    /**
     * 查询消息
     *
     * @param talker  对话着
     * @param lastCreateTime 创建时间
     * @return ResponseVO
     */
    @GetMapping("/list")
    public ResponseVO<List<MsgVO>> list(@RequestParam String talker, @RequestParam Long lastCreateTime) {
        return ResponseVO.ok(msgService.queryMsg(talker, lastCreateTime));
    }

    /**
     * 导出聊天记录
     *
     * @return ResponseVO
     */
    @GetMapping("/export")
    public ResponseVO<String> export(@RequestParam String talker) {
        return ResponseVO.ok(msgService.exportMsg(talker));
    }
}
