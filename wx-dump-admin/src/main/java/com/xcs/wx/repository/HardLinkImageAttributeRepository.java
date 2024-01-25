package com.xcs.wx.repository;

/**
 * @author xcs
 * @date 2024年01月03日 16时56分
 **/
public interface HardLinkImageAttributeRepository {

    /**
     * 查询图片地址
     *
     * @param md5
     * @return
     */
    String queryHardLinkImage(byte[] md5);
}
