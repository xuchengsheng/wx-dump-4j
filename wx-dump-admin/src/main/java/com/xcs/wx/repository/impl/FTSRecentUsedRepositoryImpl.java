package com.xcs.wx.repository.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.FTSRecentUsed;
import com.xcs.wx.mapper.FTSRecentUsedMapper;
import com.xcs.wx.repository.FTSRecentUsedRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最新使用关键字 Repository实现类
 *
 * @author xcs
 * @date 2024年1月23日11:20:56
 */
@Repository
@DS(value = DataSourceType.FTS_CONTACT_DB)
public class FTSRecentUsedRepositoryImpl extends ServiceImpl<FTSRecentUsedMapper, FTSRecentUsed> implements FTSRecentUsedRepository {

    @Override
    public List<String> queryRecentUsedKeyWord() {
        // 构建查询条件
        LambdaQueryWrapper<FTSRecentUsed> wrapper = Wrappers.<FTSRecentUsed>lambdaQuery()
                .select(FTSRecentUsed::getQueryText);
        // 查询
        List<FTSRecentUsed> keyWords = super.list(wrapper);
        // 返回默认值空
        if (CollUtil.isEmpty(keyWords)) {
            return Collections.emptyList();
        }
        return keyWords.stream().map(FTSRecentUsed::getQueryText).collect(Collectors.toList());
    }
}
