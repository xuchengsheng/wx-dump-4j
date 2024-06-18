package com.xcs.wx.service.impl;

import com.xcs.wx.domain.vo.WeChatVO;
import com.xcs.wx.repository.ContactHeadImgUrlRepository;
import com.xcs.wx.service.UserService;
import com.xcs.wx.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * UserService 实现类
 *
 * @author xcs
 * @date 2024年6月15日16:06:37
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ContactHeadImgUrlRepository contactHeadImgUrlRepository;

    @Override
    public String avatar() {
        WeChatVO user = UserUtil.getUser();

        if (user == null) {
            return "";
        }

        return contactHeadImgUrlRepository.queryHeadImgUrlByUserName(user.getWxId());
    }
}
