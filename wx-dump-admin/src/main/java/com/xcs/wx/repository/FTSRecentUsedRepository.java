package com.xcs.wx.repository;

import java.util.List;

/**
 * 最新使用关键字 Repository
 *
 * @author xcs
 * @date 2024年1月23日11:20:56
 */
public interface FTSRecentUsedRepository {

    /**
     * 查询最近使用的关键字
     *
     * @return 返回关键字
     */
    List<String> queryRecentUsedKeyWord();
}
