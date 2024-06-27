package com.xcs.wx.repository.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
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
 * 朋友圈 Repository 实现类
 *
 * @author xcs
 * @date 2024年01月03日 16时56分
 **/
@Repository
@DS(value = DataSourceType.SNS_DB)
public class FeedsRepositoryImpl extends ServiceImpl<FeedsMapper, Feeds> implements FeedsRepository {

    @Override
    public Page<Feeds> queryFeeds(FeedsDTO feedsDTO) {
        boolean conditionUserName = StrUtil.isNotBlank(feedsDTO.getUserName());
        boolean conditionCreateTime = ObjUtil.isNotEmpty(feedsDTO.getStartTime()) && ObjUtil.isNotEmpty(feedsDTO.getEndTime());
        LambdaQueryWrapper<Feeds> wrapper = Wrappers.<Feeds>lambdaQuery()
                .eq(conditionUserName, Feeds::getUserName, feedsDTO.getUserName())
                .between(conditionCreateTime, Feeds::getCreateTime, feedsDTO.getStartTime(), feedsDTO.getEndTime())
                .orderByDesc(Feeds::getCreateTime);
        return super.page(new Page<>(feedsDTO.getCurrent(), feedsDTO.getPageSize()), wrapper);
    }
}
