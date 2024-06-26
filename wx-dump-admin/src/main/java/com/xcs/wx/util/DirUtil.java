package com.xcs.wx.util;

import java.nio.file.FileSystems;

public class DirUtil {

    private DirUtil() {
    }

    /**
     * 获得一个完整的文件夹路径
     *
     * @param dirs 文件夹名称
     * @return 路径
     */
    public static String getDir(String... dirs) {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append(userDir);
        // 遍历
        for (String dir : dirs) {
            sb.append(separator);
            sb.append(dir);
        }
        sb.append(separator);
        return sb.toString();
    }

    /**
     * 获得一个完整的文件夹路径
     *
     * @param fileName 文件名
     * @param dirs     文件夹名称
     * @return 路径
     */
    public static String getDirFileName(String fileName, String... dirs) {
        return getDir(dirs) + fileName;
    }

    /**
     * 图片不存在
     *
     * @return 路径
     */
    public static String notFoundImg() {
        return getDirFileName("404.png", "asset");
    }

    /**
     * 获得一个完整的文件夹路径
     *
     * @param dirs 文件夹名称
     * @return 路径
     */
    public static String getDirWithoutUser(String... dirs) {
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
}
