package com.xcs.wx.service;

import com.xcs.wx.domain.dto.FeedsDTO;
import com.xcs.wx.domain.vo.FeedsVO;
import com.xcs.wx.domain.vo.PageVO;

/**
 * 朋友圈服务
 *
 * @author xcs
 * @date 2024年1月3日17:25:26
 */
public interface FeedsService {

    /**
     * 查询朋友圈
     *
     * @param feedsDTO 分页参数
     * @return FeedsVO
     */
    PageVO<FeedsVO> queryFeeds(FeedsDTO feedsDTO);
}
