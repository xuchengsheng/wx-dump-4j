package com.xcs.wx.repository.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.Contact;
import com.xcs.wx.domain.dto.ContactDTO;
import com.xcs.wx.domain.vo.AllContactVO;
import com.xcs.wx.domain.vo.ContactVO;
import com.xcs.wx.domain.vo.ExportContactVO;
import com.xcs.wx.mapper.ContactMapper;
import com.xcs.wx.repository.ContactRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 联系人 Repository 实现类
 *
 * @author xcs
 * @date 2023年12月22日 14时21分
 **/
@Repository
@DS(value = DataSourceType.MICRO_MSG_DB)
public class ContactRepositoryImpl extends ServiceImpl<ContactMapper, Contact> implements ContactRepository {

    @Override
    public Page<ContactVO> queryContact(ContactDTO contactDTO) {
        return getBaseMapper().queryContact(new Page<>(contactDTO.getCurrent(), contactDTO.getPageSize()), contactDTO);
    }

    @Override
    public List<AllContactVO> queryAllContact() {
        return getBaseMapper().queryAllContact().stream().filter(contactVO -> !contactVO.getNickName().isEmpty()).collect(Collectors.toList());
    }

    @Override
    public String getContactNickname(String userName) {
        // 构建查询条件
        LambdaQueryWrapper<Contact> wrapper = Wrappers.<Contact>lambdaQuery()
                .select(Contact::getUserName, Contact::getNickName, Contact::getRemark)
                .eq(Contact::getUserName, userName);
        // 查询数据库
        Contact contact = super.getOne(wrapper);

        // 空校验
        if (contact == null) {
            return "未知用户";
        }

        // 如果备注不为空则取备注，否则取联系人的昵称
        return StrUtil.isNotBlank(contact.getRemark()) ? contact.getRemark() : contact.getNickName();
    }

    @Override
    public String getNickName(String userName) {
        LambdaQueryWrapper<Contact> wrapper = Wrappers.<Contact>lambdaQuery()
                .select(Contact::getNickName)
                .eq(Contact::getUserName, userName);
        return Optional.ofNullable(super.getOne(wrapper))
                .map(Contact::getNickName)
                .orElse(null);
    }

    @Override
    public Set<String> getContactWithMp() {
        return getBaseMapper().getContactWithMp();
    }

    @Override
    public Map<String, String> getContactNickname(List<String> userNames) {
        // 构建查询条件
        LambdaQueryWrapper<Contact> wrapper = Wrappers.<Contact>lambdaQuery()
                .select(Contact::getUserName, Contact::getNickName, Contact::getRemark)
                .in(Contact::getUserName, userNames);
        // 查询数据库
        Map<String, String> contactMap = Optional.ofNullable(super.list(wrapper))
                .map(contacts -> contacts.stream().collect(Collectors.toMap(Contact::getUserName, contact -> StrUtil.isNotBlank(contact.getRemark()) ? contact.getRemark() : contact.getNickName())))
                .orElse(Collections.emptyMap());

        return userNames.stream().collect(Collectors.toMap(item -> item, item -> {
            String nickName = contactMap.get(item);
            // 空校验
            if (StrUtil.isBlank(nickName)) {
                return "未知用户";
            }
            // 如果备注不为空则取备注，否则取联系人的昵称
            return nickName;
        }));
    }

    @Override
    public int countContact() {
        return getBaseMapper().countContact();
    }

    @Override
    public List<ExportContactVO> exportContact() {
        return getBaseMapper().exportContact();
    }
}
