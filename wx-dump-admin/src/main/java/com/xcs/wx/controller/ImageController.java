package com.xcs.wx.controller;

import com.xcs.wx.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 图片 Controller
 *
 * @author xcs
 * @date 2024年1月24日16:41:52
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    /**
     * 根据Md5下载图片
     *
     * @param md5 Md5值
     * @return 图片
     */
    @GetMapping("/downloadImgMd5")
    public ResponseEntity<Resource> downloadImgMd5(@RequestParam String md5) throws IOException {
        String imgUrl = imageService.downloadImgMd5(md5);
        InputStreamResource imageStream = new InputStreamResource(new FileInputStream(imgUrl));
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageStream);
    }

    /**
     * 根据路径下载图片
     *
     * @param path Md5值
     * @return 图片
     */
    @GetMapping("/downloadImg")
    public ResponseEntity<Resource> downloadImg(@RequestParam String path) throws IOException {
        String imgUrl = imageService.downloadImg(path);
        InputStreamResource imageStream = new InputStreamResource(new FileInputStream(imgUrl));
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageStream);
    }
}
