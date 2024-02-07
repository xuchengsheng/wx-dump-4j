package com.xcs.wx.controller;

import com.xcs.wx.domain.dto.ContactDTO;
import com.xcs.wx.domain.vo.*;
import com.xcs.wx.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 联系人 Controller
 *
 * @author xcs
 * @date 2023年12月22日 14时16分
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    /**
     * 查询联系人
     *
     * @param contactDTO 请求参数
     * @return ResponseVO
     */
    @GetMapping("/list")
    public ResponseVO<List<ContactVO>> list(ContactDTO contactDTO) {
        // 查询联系人
        PageVO<ContactVO> pageVO = contactService.queryContact(contactDTO);
        // 返回数据
        return ResponseVO.ok(pageVO.getRecords(), pageVO.getCurrent(), pageVO.getTotal());
    }

    /**
     * 查询所有联系人
     *
     * @return ResponseVO
     */
    @GetMapping("/all")
    public ResponseVO<List<AllContactVO>> all() {
        return ResponseVO.ok(contactService.queryAllContact());
    }

    /**
     * 联系人标签
     *
     * @return ContactLabelVO
     */
    @GetMapping("/label")
    public ResponseVO<List<ContactLabelVO>> label() {
        return ResponseVO.ok(contactService.queryContactLabel());
    }

    /**
     * 导出联系人
     *
     * @return ResponseVO
     */
    @GetMapping("/export")
    public ResponseVO<String> export() {
        return ResponseVO.ok(contactService.exportContact());
    }
}
