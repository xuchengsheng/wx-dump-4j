package com.xcs.wx.controller;

import com.xcs.wx.service.ContactHeadImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 联系人头像 Controller
 *
 * @author xcs
 * @date 2024年6月18日15:45:17
 **/
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contact/headImg")
public class ContactHeadImgController {

    private final ContactHeadImgService contactHeadImgService;

    /**
     * 用户头像
     *
     * @param userName 用户名
     * @param response HttpServletResponse
     */
    @GetMapping("/avatar")
    public void avatar(String userName, HttpServletResponse response) {
        byte[] avatarBytes = contactHeadImgService.avatar(userName);
        if (avatarBytes != null) {
            response.setContentType("image/gif");
            response.setContentLength(avatarBytes.length);
            try (OutputStream os = response.getOutputStream()) {
                os.write(avatarBytes);
                os.flush();
            } catch (IOException e) {
                log.error("avatar fail", e);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
