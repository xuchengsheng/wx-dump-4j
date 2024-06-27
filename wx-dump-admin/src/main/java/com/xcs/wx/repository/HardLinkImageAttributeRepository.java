package com.xcs.wx.repository;

/**
 * 图片链接 Repository
 *
 * @author xcs
 * @date 2024年01月03日 16时56分
 **/
public interface HardLinkImageAttributeRepository {

    /**
     * 查询图片地址
     *
     * @param md5 md5
     * @return 图片
     */
    String queryHardLinkImage(byte[] md5);
}
