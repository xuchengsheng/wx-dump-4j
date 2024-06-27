package com.xcs.wx.mapping;

import com.xcs.wx.domain.ContactLabel;
import com.xcs.wx.domain.vo.ContactLabelVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 联系人标签 Mapping
 *
 * @author xcs
 * @date 2023年12月22日 15时00分
 **/
@Mapper(componentModel = "spring")
public interface ContactLabelMapping {

    /**
     * 参数转换
     *
     * @param labels 标签
     * @return MsgDTO
     */
    List<ContactLabelVO> convert(List<ContactLabel> labels);
}
