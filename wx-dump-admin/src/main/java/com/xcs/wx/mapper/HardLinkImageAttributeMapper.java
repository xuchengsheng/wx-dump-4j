package com.xcs.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcs.wx.domain.HardLinkImageAttribute;
import org.apache.ibatis.annotations.Param;

/**
 * 图片链接 Mapper
 *
 * @author xcs
 * @date 2024年1月16日21:50:13
 */
public interface HardLinkImageAttributeMapper extends BaseMapper<HardLinkImageAttribute> {

    /**
     * 查询图片
     *
     * @param md5 md5
     * @return 图片
     */
    String queryHardLinkImage(@Param("md5") byte[] md5);
}
