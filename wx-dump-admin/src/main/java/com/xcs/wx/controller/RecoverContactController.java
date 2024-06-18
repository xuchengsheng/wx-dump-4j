package com.xcs.wx.controller;

import com.xcs.wx.domain.dto.RecoverContactDTO;
import com.xcs.wx.domain.vo.RecoverContactVO;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.service.RecoverContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 找回联系人  Controller
 *
 * @author xcs
 * @date 2024年01月04日 13时48分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recover/contact")
public class RecoverContactController {

    private final RecoverContactService recoverContactService;

    /**
     * 查询朋友圈
     *
     * @param recoverContactDTO 请求参数
     * @return FeedsVO
     */
    @GetMapping("/list")
    public ResponseVO<List<RecoverContactVO>> list(RecoverContactDTO recoverContactDTO) {
        // 返回数据
        return ResponseVO.ok(recoverContactService.queryRecoverContact(recoverContactDTO));
    }

    /**
     * 导出联系人
     *
     * @return ResponseVO
     */
    @GetMapping("/export")
    public ResponseVO<String> export() {
        return ResponseVO.ok(recoverContactService.exportRecoverContact());
    }
}
