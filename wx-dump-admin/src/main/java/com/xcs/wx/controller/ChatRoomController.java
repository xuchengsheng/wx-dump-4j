package com.xcs.wx.controller;

import com.xcs.wx.domain.dto.ChatRoomDTO;
import com.xcs.wx.domain.vo.ChatRoomDetailVO;
import com.xcs.wx.domain.vo.ChatRoomVO;
import com.xcs.wx.domain.vo.PageVO;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 群聊 Controller
 *
 * @author xcs
 * @date 2024年01月08日 16时03分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chatroom")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    /**
     * 查询群聊列表
     *
     * @param chatRoomDTO 查询参数
     * @return ChatRoomVO
     */
    @GetMapping("/list")
    public ResponseVO<List<ChatRoomVO>> list(ChatRoomDTO chatRoomDTO) {
        // 查询群聊列表
        PageVO<ChatRoomVO> pageVO = chatRoomService.queryChatRoom(chatRoomDTO);
        // 返回数据
        return ResponseVO.ok(pageVO.getRecords(), pageVO.getCurrent(), pageVO.getTotal());
    }

    /**
     * 查询群聊详情
     *
     * @param chatRoomName 群聊名称
     * @return ChatRoomDetailVO
     */
    @GetMapping("/detail")
    public ResponseVO<ChatRoomDetailVO> detail(@RequestParam String chatRoomName) {
        return ResponseVO.ok(chatRoomService.queryChatRoomDetail(chatRoomName));
    }

    /**
     * 导出群聊
     *
     * @return ResponseVO
     */
    @GetMapping("/export")
    public ResponseVO<String> export() {
        return ResponseVO.ok(chatRoomService.exportChatRoom());
    }
}
