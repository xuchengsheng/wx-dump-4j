package com.xcs.wx.repository;

/**
 * @author xcs
 * @date 2024年01月03日 16时56分
 **/
public interface HardLinkVideoAttributeRepository {

    /**
     * 查询视频地址
     *
     * @param md5 md5值
     * @return 视频地址
     */
    String queryHardLinkVideo(byte[] md5);
}
