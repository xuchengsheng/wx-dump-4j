package com.xcs.wx.mapping;

import com.xcs.wx.domain.bo.UserBO;
import com.xcs.wx.domain.vo.UserInfoVO;
import org.mapstruct.Mapper;

/**
 * 用户 Mapping
 *
 * @author xcs
 * @date 2023年12月21日 18时46分
 **/
@Mapper(componentModel = "spring")
public interface UserMapping {

    /**
     * 参数转换
     *
     * @param userBO 请求参数
     * @return UserInfoVO
     */
    UserInfoVO convert(UserBO userBO);
}
