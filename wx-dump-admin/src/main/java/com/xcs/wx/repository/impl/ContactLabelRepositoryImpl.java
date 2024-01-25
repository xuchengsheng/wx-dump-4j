package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.ContactLabel;
import com.xcs.wx.mapper.ContactLabelMapper;
import com.xcs.wx.repository.ContactLabelRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 联系人标签 Repository 实现类
 *
 * @author xcs
 * @date 2023年12月22日 17时25分
 **/
@Repository
@DS(value = DataSourceType.MICRO_MSG_DB)
public class ContactLabelRepositoryImpl extends ServiceImpl<ContactLabelMapper, ContactLabel> implements ContactLabelRepository {

    @Override
    public Map<String, String> queryContactLabelAsMap() {
        // 返回头像并转换成map
        return Optional.ofNullable(queryContactLabelAsList())
                .map(headImgUrls -> headImgUrls.stream().collect(Collectors.toMap(ContactLabel::getLabelId, ContactLabel::getLabelName)))
                .orElse(Collections.emptyMap());
    }

    @Override
    public List<ContactLabel> queryContactLabelAsList() {
        LambdaQueryWrapper<ContactLabel> wrapper = Wrappers.<ContactLabel>lambdaQuery()
                .select(ContactLabel::getLabelId,ContactLabel::getLabelName);
        // 返回头像并转换成map
        return super.list(wrapper);
    }
}
