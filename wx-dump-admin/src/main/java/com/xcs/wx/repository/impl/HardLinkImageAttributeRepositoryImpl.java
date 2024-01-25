package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.HardLinkImageAttribute;
import com.xcs.wx.mapper.HardLinkImageAttributeMapper;
import com.xcs.wx.repository.HardLinkImageAttributeRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xcs
 * @date 2024年01月04日 17时59分
 **/
@Repository
@DS(value = DataSourceType.HARD_LINK_IMAGE_DB)
public class HardLinkImageAttributeRepositoryImpl extends ServiceImpl<HardLinkImageAttributeMapper, HardLinkImageAttribute> implements HardLinkImageAttributeRepository {

    @Override
    public String queryHardLinkImage(byte[] md5) {
        return getBaseMapper().queryHardLinkImage(md5);
    }
}
