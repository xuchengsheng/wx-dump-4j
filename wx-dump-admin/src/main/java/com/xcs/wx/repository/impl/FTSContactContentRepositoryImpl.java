package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.FTSContactContent;
import com.xcs.wx.domain.dto.RecoverContactDTO;
import com.xcs.wx.mapper.FTSContactContentMapper;
import com.xcs.wx.repository.FTSContactContentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 联系人内容 Repository 实现类
 *
 * @author xcs
 * @date 2024年6月14日15:18:11
 **/
@Repository
@DS(value = DataSourceType.FTS_CONTACT_DB)
public class FTSContactContentRepositoryImpl extends ServiceImpl<FTSContactContentMapper, FTSContactContent> implements FTSContactContentRepository {

    @Override
    public List<FTSContactContent> queryContactContent(RecoverContactDTO recoverContactDTO) {
        // 构建查询条件
        LambdaQueryWrapper<FTSContactContent> wrapper = Wrappers.<FTSContactContent>lambdaQuery()
                .ne(FTSContactContent::getAlias, "")
                .like(recoverContactDTO.getNickname() != null, FTSContactContent::getNickname, recoverContactDTO.getNickname())
                .like(recoverContactDTO.getRemark() != null, FTSContactContent::getRemark, recoverContactDTO.getRemark())
                .orderByAsc(FTSContactContent::getAlias);
        return super.list(wrapper);
    }
}
