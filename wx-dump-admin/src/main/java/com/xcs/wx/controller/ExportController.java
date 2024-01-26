package com.xcs.wx.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 导出 Controller
 *
 * @author xcs
 * @date 2024年01月05日 15时56分
 **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/export")
public class ExportController {

    /**
     * 下载文件
     */
    @GetMapping("download")
    public ResponseEntity<Resource> download(@RequestParam String path) throws IOException {
        Path filePath = Paths.get(path);
        Resource resource = new FileSystemResource(filePath.toFile());

        // 处理文件不存在的情况
        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        String encodedFilename = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8.name()).replace("+", "%20");
        String contentDisposition = "attachment; filename*=UTF-8''" + encodedFilename;

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .header("Content-Disposition", contentDisposition)
                .body(resource);
    }
}
