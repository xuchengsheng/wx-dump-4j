package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
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
 * 联系人头像 Repository 实现类
 *
 * @author xcs
 * @date 2023年12月21日18:38:19
 */
@Repository
@DS(value = DataSourceType.MICRO_MSG_DB)
public class ContactHeadImgUrlRepositoryImpl extends ServiceImpl<ContactHeadImgUrlMapper, ContactHeadImgUrl> implements ContactHeadImgUrlRepository {

    @Override
    public Map<String, String> queryHeadImgUrl(List<String> usrNames) {
        Wrapper<ContactHeadImgUrl> wrapper = Wrappers.<ContactHeadImgUrl>lambdaQuery()
                .select(ContactHeadImgUrl::getUsrName, ContactHeadImgUrl::getSmallHeadImgUrl)
                .in(ContactHeadImgUrl::getUsrName, usrNames);
        return Optional.ofNullable(super.list(wrapper))
                .map(headImgUrls -> headImgUrls.stream().collect(Collectors.toMap(ContactHeadImgUrl::getUsrName, ContactHeadImgUrl::getSmallHeadImgUrl)))
                .orElse(Collections.emptyMap());
    }

    @Override
    public String queryHeadImgUrlByUserName(String userName) {
        Wrapper<ContactHeadImgUrl> wrapper = Wrappers.<ContactHeadImgUrl>lambdaQuery()
                .select(ContactHeadImgUrl::getUsrName, ContactHeadImgUrl::getSmallHeadImgUrl)
                .eq(ContactHeadImgUrl::getUsrName, userName);
        return Optional.ofNullable(super.getOne(wrapper))
                .map(ContactHeadImgUrl::getSmallHeadImgUrl)
                .orElse(null);
    }
}
