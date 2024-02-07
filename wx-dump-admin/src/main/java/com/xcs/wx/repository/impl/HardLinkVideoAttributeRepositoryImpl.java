package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.HardLinkVideoAttribute;
import com.xcs.wx.mapper.HardLinkVideoAttributeMapper;
import com.xcs.wx.repository.HardLinkVideoAttributeRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xcs
 * @date 2024年02月07日 15时27分
 **/
@Repository
@DS(value = DataSourceType.HARD_LINK_VIDEO_DB)
public class HardLinkVideoAttributeRepositoryImpl extends ServiceImpl<HardLinkVideoAttributeMapper, HardLinkVideoAttribute> implements HardLinkVideoAttributeRepository {

    @Override
    public String queryHardLinkVideo(byte[] md5) {
        return super.getBaseMapper().queryHardLinkVideo(md5);
    }
}
