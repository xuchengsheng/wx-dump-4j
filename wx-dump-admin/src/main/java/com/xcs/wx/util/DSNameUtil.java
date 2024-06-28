package com.xcs.wx.util;

import cn.hutool.extra.spring.SpringUtil;
import com.xcs.wx.service.UserService;

/**
 * DSNameUtil
 *
 * @author 林雷
 * @date 2024年6月27日17:26:43
 */
public class DSNameUtil {

    private DSNameUtil() {
    }

    /**
     * 获取数据源名称
     *
     * @param dbName 数据库名
     * @return dsName
     */
    public static String getDSName(String dbName) {
        return getDSName(SpringUtil.getBean(UserService.class).currentUser(), dbName);
    }

    /**
     * 获取数据源名称
     *
     * @param wxId   wxId
     * @param dbName 数据库名
     * @return dsName
     */
    public static String getDSName(String wxId, String dbName) {
        return wxId + "#" + dbName;
    }
}
