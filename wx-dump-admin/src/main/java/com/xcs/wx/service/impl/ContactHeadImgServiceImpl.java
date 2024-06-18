package com.xcs.wx.service.impl;

import com.xcs.wx.repository.ContactHeadImgRepository;
import com.xcs.wx.service.ContactHeadImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 联系人头像实现类
 *
 * @author xcs
 * @date 2023年12月31日18:18:58
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ContactHeadImgServiceImpl implements ContactHeadImgService {

    private final ContactHeadImgRepository contactHeadImgService;

    @Override
    public byte[] avatar(String userName) {
        return contactHeadImgService.getContactHeadImg(userName);
    }
}
