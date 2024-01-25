package com.xcs.wx.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.xcs.wx.domain.vo.WeChatVO;

/**
 * @author xcs
 * @date 2024年01月16日 13时52分
 **/
public class UserUtil {

    /**
     * 保存用户信息
     *
     * @param weChatDTO
     */
    public static void saveUser(WeChatVO weChatDTO) {
        FileUtil.writeString(JSONUtil.toJsonStr(weChatDTO), getUserPath(), "UTF-8");
    }

    /**
     * 保存用户信息
     */
    public static WeChatVO getUser() {
        String json = FileUtil.readUtf8String(getUserPath());
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
        String separator = System.getProperty("file.separator");
        // 存储目录
        return userDir + separator + "config" + separator + "user.json";
    }
}
