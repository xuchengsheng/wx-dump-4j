package com.xcs.wx.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 * 图片服务
 *
 * @author xcs
 * @date 2024年1月18日22:06:46
 */
public interface ImageService {

    /**
     * 通过Md5来下载图片
     *
     * @param md5 md5
     * @return ResponseEntity
     */
    ResponseEntity<Resource> downloadImgMd5(String md5);

    /**
     * 下载图片
     *
     * @param path 图片地址
     * @return ResponseEntity
     */
    ResponseEntity<Resource> downloadImg(String path);

    /**
     * 下载图片
     *
     * @param localPath 图片地址
     * @return ResponseEntity
     */
    ResponseEntity<Resource> downloadImgFormLocal(String localPath);
}
