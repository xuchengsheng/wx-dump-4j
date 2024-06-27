package com.xcs.wx.repository.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.ContactHeadImg;
import com.xcs.wx.mapper.ContactHeadImgMapper;
import com.xcs.wx.repository.ContactHeadImgRepository;
import org.springframework.stereotype.Repository;

/**
 * 联系人头像 Repository 实现类
 *
 * @author xcs
 * @date 2024年6月18日15:31:54
 */
@Repository
@DS(value = DataSourceType.MISC_DB)
public class ContactHeadImgRepositoryImpl extends ServiceImpl<ContactHeadImgMapper, ContactHeadImg> implements ContactHeadImgRepository {

    @Override
    public byte[] getContactHeadImg(String usrName) {
        ContactHeadImg contactHeadImg = super.getBaseMapper().getContactHeadImg(usrName);
        if (contactHeadImg != null) {
            return contactHeadImg.getSmallHeadBuf();
        }
        return new byte[]{};
    }
}
