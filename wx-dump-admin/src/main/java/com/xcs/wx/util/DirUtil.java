package com.xcs.wx.util;

import java.nio.file.FileSystems;

public class DirUtil {

    private static final String DATA = "data";
    private static final String DB = "db";
    private static final String IMG = "img";

    private DirUtil() {
    }

    /**
     * 获得一个完整的文件夹路径
     *
     * @param dirs 文件夹名称
     * @return 路径
     */
    public static String getImgDir(String... dirs) {
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 拼接路径
        StringBuilder sb = new StringBuilder();
        // 遍历
        for (int i = 0; i < dirs.length; i++) {
            sb.append(dirs[i]);
            if ((i + 1) < dirs.length) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * 获取图片文件夹地址
     *
     * @param wxId wxId
     * @return dir
     */
    public static String getImgDir(String wxId) {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 拼接路径
        return userDir + separator + DATA + separator + DB + separator + wxId + separator + IMG;
    }

    /**
     * 获取图片文件夹地址与文件名
     *
     * @param wxId wxId
     * @return dir
     */
    public static String getImgDirWithName(String wxId, String fileName) {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 拼接路径
        return userDir + separator + DATA + separator + DB + separator + wxId + separator + IMG + separator + fileName;
    }
}
