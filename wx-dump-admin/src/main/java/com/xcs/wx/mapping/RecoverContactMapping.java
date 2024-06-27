package com.xcs.wx.mapping;

import com.xcs.wx.domain.FTSContactContent;
import com.xcs.wx.domain.vo.RecoverContactVO;
import org.mapstruct.Mapper;

/**
 * 找回联系人 Mapping
 *
 * @author xcs
 * @date 2024年6月14日15:57:18
 **/
@Mapper(componentModel = "spring")
public interface RecoverContactMapping {

    /**
     * 参数转换
     *
     * @param content 参数
     * @return RecoverContactVO
     */
    RecoverContactVO convert(FTSContactContent content);
}
