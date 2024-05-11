package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpUtil;
import com.xcs.wx.domain.vo.WeChatVO;
import com.xcs.wx.service.ImageService;
import com.xcs.wx.util.ImgDecoderUtil;
import com.xcs.wx.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 图片服务
 *
 * @author xcs
 * @date 2024年1月18日22:06:46
 */
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Override
    public String downloadImg(String path) {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = System.getProperty("file.separator");
        // 返回默认图片
        String destPath = userDir + separator + "img" + separator + IdUtil.fastSimpleUUID() + ".gif";
        // 下载图片
        try {
            HttpUtil.downloadFile(path, destPath);
        } catch (Exception e) {
            // 返回404
            return userDir + separator + "asset" + separator + "404.png";
        }
        // 返回下载后的图片
        return destPath;
    }

    @Override
    public String downloadImgFormLocal(String localPath) {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = System.getProperty("file.separator");
        // 获取用户信息
        WeChatVO user = UserUtil.getUser();
        // 获得文件目录
        String filePath = user.getBasePath() + "\\" + localPath;
        // 检查文件是否存在，返回404
        if (!FileUtil.exist(filePath)) {
            return userDir + separator + "asset" + separator + "404.png";
        }
        String outPath = userDir + separator + "img";
        // 解密并返回
        return ImgDecoderUtil.decodeDat(filePath, outPath);
    }
}
