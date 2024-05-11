package com.xcs.wx.service;

public interface ImageService {

    /**
     * 通过Md5来下载图片
     *
     * @param md5
     * @return
     */
    String downloadImgMd5(String md5);

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
