package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.HardLinkVideoAttribute;
import com.xcs.wx.mapper.HardLinkVideoAttributeMapper;
import com.xcs.wx.repository.HardLinkVideoAttributeRepository;
import org.springframework.stereotype.Repository;

/**
 * 视频链接 Repository 实现类
 *
 * @author xcs
 * @date 2024年01月03日 16时56分
 **/
@Repository
@DS(value = DataSourceType.HARD_LINK_VIDEO_DB)
public class HardLinkVideoAttributeRepositoryImpl extends ServiceImpl<HardLinkVideoAttributeMapper, HardLinkVideoAttribute> implements HardLinkVideoAttributeRepository {

    @Override
    public String queryHardLinkVideo(byte[] md5) {
        return super.getBaseMapper().queryHardLinkVideo(md5);
    }
}
