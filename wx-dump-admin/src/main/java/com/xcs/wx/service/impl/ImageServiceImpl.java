package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.xcs.wx.domain.vo.WeChatVO;
import com.xcs.wx.repository.HardLinkImageAttributeRepository;
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

    private final HardLinkImageAttributeRepository hardLinkImageAttributeRepository;

    @Override
    public String downloadImgMd5(String md5) {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = System.getProperty("file.separator");
        // 查询数据库
        String imgUrl = hardLinkImageAttributeRepository.queryHardLinkImage(HexUtil.decodeHex(md5));
        // 查询结果为空，返回404
        if (StrUtil.isBlank(imgUrl)) {
            return userDir + separator + "asset" + separator + "404.png";
        }
        // 获取用户信息
        WeChatVO user = UserUtil.getUser();
        // 获得文件目录
        String filePath = user.getBasePath() + "\\" + user.getWxId() + imgUrl;
        // 检查文件是否存在，返回404
        if (!FileUtil.exist(filePath)) {
            return userDir + separator + "asset" + separator + "404.png";
        }
        String outPath = userDir + separator + "img";
        // 解密并返回
        return ImgDecoderUtil.decodeDat(filePath, outPath);
    }

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
}
