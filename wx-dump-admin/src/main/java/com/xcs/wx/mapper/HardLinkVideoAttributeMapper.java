package com.xcs.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcs.wx.domain.HardLinkVideoAttribute;
import org.apache.ibatis.annotations.Param;

/**
 * 视频链接  Mapper
 *
 * @author xcs
 * @date 2024年1月16日21:50:13
 */
public interface HardLinkVideoAttributeMapper extends BaseMapper<HardLinkVideoAttribute> {

    /**
     * 查询视频
     *
     * @param md5 md5
     * @return 视频
     */
    String queryHardLinkVideo(@Param("md5") byte[] md5);
}
