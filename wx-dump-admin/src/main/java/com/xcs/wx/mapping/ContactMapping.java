package com.xcs.wx.mapping;

import com.xcs.wx.domain.Contact;
import com.xcs.wx.domain.vo.ContactVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 联系人 Mapping
 *
 * @author xcs
 * @date 2023年12月22日 15时00分
 **/
@Mapper(componentModel = "spring")
public interface ContactMapping {

    /**
     * 转换参数
     *
     * @param entities
     * @return
     */
    List<ContactVO> convert(List<Contact> entities);
}
