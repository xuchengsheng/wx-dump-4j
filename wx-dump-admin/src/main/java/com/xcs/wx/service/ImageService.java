package com.xcs.wx.service;

public interface ImageService {

    /**
     * 下载图片
     *
     * @param path 图片地址
     * @return 下载后的图片地址
     */
    String downloadImg(String path);

    /**
     * 下载图片
     *
     * @param localPath 图片地址
     * @return 下载后的图片地址
     */
    String downloadImgFormLocal(String localPath);
}
