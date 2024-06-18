package com.xcs.wx.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.xcs.wx.domain.vo.WeChatVO;

import java.nio.file.FileSystems;

/**
 * @author xcs
 * @date 2024年01月16日 13时52分
 **/
public class UserUtil {

    /**
     * 保存用户信息
     *
     * @param weChatDTO 参数
     */
    public static void saveUser(WeChatVO weChatDTO) {
        FileUtil.writeString(JSONUtil.toJsonStr(weChatDTO), getUserPath(), "UTF-8");
    }

    /**
     * 保存用户信息
     */
    public static WeChatVO getUser() {
        String userPath = getUserPath();
        if (!FileUtil.exist(userPath)) {
            return null;
        }
        String json = FileUtil.readUtf8String(userPath);
        return JSONUtil.toBean(json, WeChatVO.class);
    }

    /**
     * 获得User目录
     *
     * @return path
     */
    private static String getUserPath() {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 存储目录
        return userDir + separator + "data" + separator + "config" + separator + "user.json";
    }
}
