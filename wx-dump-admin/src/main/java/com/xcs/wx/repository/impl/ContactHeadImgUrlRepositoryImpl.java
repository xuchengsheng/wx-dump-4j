package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.ContactHeadImgUrl;
import com.xcs.wx.mapper.ContactHeadImgUrlMapper;
import com.xcs.wx.repository.ContactHeadImgUrlRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xcs
 * @date 2023年12月21日 18时35分
 **/
@Repository
@DS(value = DataSourceType.MICRO_MSG_DB)
public class ContactHeadImgUrlRepositoryImpl extends ServiceImpl<ContactHeadImgUrlMapper, ContactHeadImgUrl>
        implements ContactHeadImgUrlRepository {

    @Override
    public Map<String, String> queryHeadImgUrl(List<String> usrNames) {
        // 构建查询条件
        Wrapper<ContactHeadImgUrl> wrapper = Wrappers.<ContactHeadImgUrl>lambdaQuery()
                .select(ContactHeadImgUrl::getUsrName, ContactHeadImgUrl::getSmallHeadImgUrl)
                .in(ContactHeadImgUrl::getUsrName, usrNames);
        // 返回头像并转换成map
        return Optional.ofNullable(super.list(wrapper))
                .map(headImgUrls -> headImgUrls.stream().collect(Collectors.toMap(ContactHeadImgUrl::getUsrName, ContactHeadImgUrl::getSmallHeadImgUrl)))
                .orElse(Collections.emptyMap());
    }

    @Override
    public String queryHeadImgUrlByUserName(String userName) {
        Wrapper<ContactHeadImgUrl> wrapper = Wrappers.<ContactHeadImgUrl>lambdaQuery()
                .select(ContactHeadImgUrl::getUsrName, ContactHeadImgUrl::getSmallHeadImgUrl)
                .eq(ContactHeadImgUrl::getUsrName, userName);
        String smallHeadImgUrl = Optional.ofNullable(super.getOne(wrapper))
                .map(ContactHeadImgUrl::getSmallHeadImgUrl)
                .orElse(null);
        return smallHeadImgUrl;
    }
}
