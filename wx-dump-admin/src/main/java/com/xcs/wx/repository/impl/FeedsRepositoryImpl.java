package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.Feeds;
import com.xcs.wx.domain.dto.FeedsDTO;
import com.xcs.wx.mapper.FeedsMapper;
import com.xcs.wx.repository.FeedsRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xcs
 * @date 2024年01月03日 16时57分
 **/
@Repository
@DS(value = DataSourceType.SNS_DB)
public class FeedsRepositoryImpl extends ServiceImpl<FeedsMapper, Feeds> implements FeedsRepository {

    @Override
    public Page<Feeds> queryFeeds(FeedsDTO feedsDTO) {
        // 构建查询条件
        LambdaQueryWrapper<Feeds> wrapper = Wrappers.<Feeds>lambdaQuery()
                .orderByDesc(Feeds::getCreateTime);

        return super.page(new Page<>(feedsDTO.getCurrent(), feedsDTO.getPageSize()), wrapper);
    }
}
