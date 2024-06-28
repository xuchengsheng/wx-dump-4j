package com.xcs.wx.util;

import java.nio.file.FileSystems;

/**
 * DirUtil
 *
 * @author 林雷
 * @date 2024年6月27日17:26:43
 */
public class DirUtil {

    /**
     * 获得工作目录
     */
    private static final String USER_DIR = System.getProperty("user.dir");

    /**
     * 文件分隔符
     */
    private static final String SEPARATOR = FileSystems.getDefault().getSeparator();

    /**
     * 数据目录
     */
    private static final String DATA = "data";

    /**
     * 文件导出目录
     */
    private static final String EXPORT = "export";

    /**
     * 数据库目录
     */
    private static final String DB = "db";

    /**
     * 图片目录
     */
    private static final String IMG = "img";

    /**
     * user.config
     */
    private static final String USER_CONFIG = "User.config";

    /**
     * SwitchUser.config
     */
    private static final String SWITCH_USER_CONFIG = "SwitchUser.config";


    private DirUtil() {
    }

    /**
     * 动态组装目录
     *
     * @param dirs 文件夹名称
     * @return 路径
     */
    public static String getDir(String... dirs) {
        // 拼接路径
        StringBuilder sb = new StringBuilder();
        // 遍历
        for (int i = 0; i < dirs.length; i++) {
            sb.append(dirs[i]);
            if ((i + 1) < dirs.length) {
                sb.append(SEPARATOR);
            }
        }
        return sb.toString();
    }

    /**
     * 获取图片目录
     *
     * @param wxId wxId
     * @return dir
     */
    public static String getImgDir(String wxId) {
        return USER_DIR + SEPARATOR + DATA + SEPARATOR + DB + SEPARATOR + wxId + SEPARATOR + IMG;
    }

    /**
     * 获取图片目录
     *
     * @param wxId wxId
     * @return dir
     */
    public static String getImgDirWithName(String wxId, String fileName) {
        return USER_DIR + SEPARATOR + DATA + SEPARATOR + DB + SEPARATOR + wxId + SEPARATOR + IMG + SEPARATOR + fileName;
    }

    /**
     * 获取用户切换配置目录
     *
     * @return 目录
     */
    public static String getSwitchUserDir() {
        return USER_DIR + SEPARATOR + DATA + SEPARATOR + SWITCH_USER_CONFIG;
    }

    /**
     * 获取用户配置目录
     *
     * @return 目录
     */
    public static String getUserDir(String wxId) {
        return USER_DIR + SEPARATOR + DATA + SEPARATOR + DB + SEPARATOR + wxId + SEPARATOR + USER_CONFIG;
    }

    /**
     * 获取数据库目录
     *
     * @return 目录
     */
    public static String getDbDir() {
        return USER_DIR + SEPARATOR + DATA + SEPARATOR + DB;
    }

    /**
     * 获取数据库目录
     *
     * @return 目录
     */
    public static String getDbDir(String wxId) {
        return USER_DIR + SEPARATOR + DATA + SEPARATOR + DB + SEPARATOR + wxId + SEPARATOR;
    }

    /**
     * 获取导出目录
     *
     * @return 目录
     */
    public static String getExportDir(String fileName) {
        return USER_DIR + SEPARATOR + DATA + SEPARATOR + EXPORT + SEPARATOR + fileName;
    }
}
