package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.xcs.wx.repository.HardLinkImageAttributeRepository;
import com.xcs.wx.service.ImageService;
import com.xcs.wx.service.UserService;
import com.xcs.wx.util.DirUtil;
import com.xcs.wx.util.ImgDecoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystems;
import java.util.UUID;

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
    private final UserService userService;

    @Override
    public String downloadImgMd5(String md5) {
        // 查询数据库
        String imgUrl = hardLinkImageAttributeRepository.queryHardLinkImage(HexUtil.decodeHex(md5));
        // 查询结果为空，返回404
        if (StrUtil.isBlank(imgUrl)) {
            return DirUtil.notFoundImg();
        }
        // 获取用户信息
        String wxId = userService.currentUser();
        // 获得文件目录
        String filePath = DirUtil.getDirWithoutUser(userService.getBasePath(wxId), wxId, imgUrl);
        // 检查文件是否存在
        if (!FileUtil.exist(filePath)) {
            // 返回404
            return DirUtil.notFoundImg();
        }
        String outPath = DirUtil.getDir("data", "db", wxId, "img");
        // 解密并返回
        return ImgDecoderUtil.decodeDat(filePath, outPath);
    }

    @Override
    public String downloadImg(String path) {
        // 获取用户信息
        String wxId = userService.currentUser();
        // 返回默认图片
        String destPath = DirUtil.getDirFileName(IdUtil.fastSimpleUUID() + ".gif", "data", "db", wxId, "img");
        // 下载图片
        try {
            HttpUtil.downloadFile(path, destPath);
        } catch (Exception e) {
            // 返回404
            return DirUtil.notFoundImg();
        }
        // 返回下载后的图片
        return destPath;
    }

    @Override
    public String downloadImgFormLocal(String localPath) {
        // 获取用户信息
        String wxId = userService.currentUser();
        // 获得文件目录
        String filePath = DirUtil.getDirWithoutUser(userService.getBasePath(wxId), wxId, localPath);
        // 检查文件是否存在，返回404
        if (!FileUtil.exist(filePath)) {
            return DirUtil.notFoundImg();
        }
        String outPath = DirUtil.getDir("data", "db", wxId, "img");
        // 检查文件是否存在
        if (!FileUtil.exist(outPath)) {
            FileUtil.mkdir(outPath);
        }
        // 解密并返回
        return ImgDecoderUtil.decodeDat(filePath, outPath);
    }
}
