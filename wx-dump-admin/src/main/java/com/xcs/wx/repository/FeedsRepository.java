package com.xcs.wx.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcs.wx.domain.Feeds;
import com.xcs.wx.domain.dto.FeedsDTO;

/**
 * 朋友圈 Repository
 *
 * @author xcs
 * @date 2024年01月03日 16时56分
 **/
public interface FeedsRepository {

    /**
     * 查询朋友圈
     *
     * @param feedsDTO 分页参数
     * @return Feeds
     */
    Page<Feeds> queryFeeds(FeedsDTO feedsDTO);
}
