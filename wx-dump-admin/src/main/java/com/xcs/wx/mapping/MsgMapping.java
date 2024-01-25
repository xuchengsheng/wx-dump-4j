package com.xcs.wx.mapping;

import com.xcs.wx.domain.Msg;
import com.xcs.wx.domain.vo.ExportMsgVO;
import com.xcs.wx.domain.vo.MsgVO;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * 消息 Mapping
 *
 * @author xcs
 * @date 2023年12月21日 18时46分
 **/
@Mapper(componentModel = "spring")
public interface MsgMapping {

    /**
     * 参数转换
     *
     * @param msgs 消息
     * @return MsgDTO
     */
    List<MsgVO> convert(List<Msg> msgs);

    /**
     * 参数转换
     *
     * @param msgVOList 参数
     * @return ExportMsgVO
     */
    List<ExportMsgVO> convertToExportMsgVO(List<MsgVO> msgVOList);
}
