package com.xcs.wx.repository;

/**
 * SQLite 数据库中的一个系统表 Repository
 *
 * @author xcs
 * @date 2024年6月13日09:19:24
 */
public interface SqliteMasterRepository {

    /**
     * 查看表是否存在
     *
     * @param tableName 表名
     * @return 是否存在
     */
    boolean isTableExists(String tableName);
}
