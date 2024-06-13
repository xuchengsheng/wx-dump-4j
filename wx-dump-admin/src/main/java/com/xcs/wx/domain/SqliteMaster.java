package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * SQLite 数据库中的一个系统表
 *
 * @author xcs
 * @date 2024年6月13日09:18:29
 */
@Data
@TableName("sqlite_master")
public class SqliteMaster {

    /**
     * type
     */
    @TableField("type")
    private String type;

    /**
     * tblName
     */
    @TableField("tbl_name")
    private String tblName;

    /**
     * rootPage
     */
    @TableField("rootpage")
    private String rootPage;

    /**
     * sql
     */
    @TableField("sql")
    private String sql;

}
