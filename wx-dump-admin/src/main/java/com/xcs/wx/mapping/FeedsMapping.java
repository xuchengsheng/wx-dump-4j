package com.xcs.wx.mapping;

import com.xcs.wx.domain.Feeds;
import com.xcs.wx.domain.vo.FeedsVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 朋友圈 Mapping
 *
 * @author xcs
 * @date 2023年12月21日 18时46分
 **/
@Mapper(componentModel = "spring")
public interface FeedsMapping {

    /**
     * 转换参数
     *
     * @param feeds 请求参数
     * @return FeedsVO
     */
    List<FeedsVO> convert(List<Feeds> feeds);
}
