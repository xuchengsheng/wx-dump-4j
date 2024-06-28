package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.bo.UserBO;
import com.xcs.wx.domain.vo.UserInfoVO;
import com.xcs.wx.domain.vo.UserVO;
import com.xcs.wx.mapping.UserMapping;
import com.xcs.wx.repository.ContactHeadImgUrlRepository;
import com.xcs.wx.repository.ContactRepository;
import com.xcs.wx.service.UserService;
import com.xcs.wx.util.DSNameUtil;
import com.xcs.wx.util.DirUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * UserService 实现类
 *
 * @author xcs
 * @date 2024年6月15日16:06:37
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ContactHeadImgUrlRepository contactHeadImgUrlRepository;
    private final ContactRepository contactRepository;
    private final UserMapping userMapping;

    @Override
    public UserInfoVO userInfo() {
        // 当前选中账号
        String wxId = currentUser();
        // 空校验
        if (wxId == null) {
            return null;
        }
        // 当前账号目录
        String userDir = DirUtil.getUserDir(wxId);
        // 空校验
        if (!FileUtil.exist(userDir)) {
            return null;
        }
        // 解析并返回
        UserBO userBO = JSONUtil.toBean(FileUtil.readUtf8String(userDir), UserBO.class);
        // 补全昵称
        if (StrUtil.NULL.equals(userBO.getNickname())) {
            userBO.setNickname(getNickName(userBO.getWxId()));
        }
        return userMapping.convert(userBO);
    }

    @Override
    public String avatar() {
        String wxId = currentUser();
        // 空校验
        if (wxId == null) {
            return null;
        }
        return getAvatar(wxId);
    }

    @Override
    public String nickname() {
        String wxId = currentUser();
        // 空校验
        if (wxId == null) {
            return null;
        }
        return getNickName(wxId);
    }

    @Override
    public List<UserVO> users() {
        // 用户信息
        List<UserVO> users = new ArrayList<>();
        // 获取微信Id
        List<String> wxIds = getWxIds();
        // 遍历
        for (String wxId : wxIds) {
            // 当前选中账号
            boolean current = wxId.equals(currentUser());
            // 头像
            String avatar = getAvatar(wxId);
            // 昵称
            String nickName = getNickName(wxId);
            // 用户信息
            users.add(new UserVO(wxId, nickName, avatar, current));
        }
        return users;
    }

    @Override
    public void switchUser(String wxId) {
        FileUtil.writeString(wxId, DirUtil.getSwitchUserDir(), "UTF-8");
    }

    @Override
    public String currentUser() {
        // 获取用户切换配置目录
        String switchUserDir = DirUtil.getSwitchUserDir();
        // 不存在的情况下，默认读取第一个
        if (!FileUtil.exist(switchUserDir)) {
            // 获取微信Id
            return Optional.of(getWxIds())
                    .filter(items -> !items.isEmpty()).map(items -> items.get(0))
                    .orElse(null);
        }
        return FileUtil.readUtf8String(switchUserDir);
    }

    @Override
    public void saveUser(UserBO userBO) {
        FileUtil.writeString(JSONUtil.toJsonStr(userBO), DirUtil.getUserDir(userBO.getWxId()), "UTF-8");
    }

    @Override
    public String getBasePath(String wxId) {
        String userDir = DirUtil.getUserDir(wxId);
        // 空校验
        if (!FileUtil.exist(userDir)) {
            return null;
        }
        String userJson = FileUtil.readUtf8String(userDir);
        // 转换json并获取basePath参数
        return JSONUtil.toBean(userJson, UserBO.class).getBasePath();
    }

    /**
     * 获取微信Id
     *
     * @return wxIds
     */
    private List<String> getWxIds() {
        // 用户信息
        List<String> userVOList = new ArrayList<>();
        // 目录
        Path path = Paths.get(DirUtil.getDbDir());
        // 查看目录是否存在
        if (!FileUtil.exist(path.toFile())) {
            return userVOList;
        }
        // 指定要扫描的目录
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            // 遍历
            for (Path entry : stream) {
                // 判断是否为文件夹
                if (FileUtil.isDirectory(entry)) {
                    userVOList.add(FileUtil.getName(entry));
                }
            }
        } catch (IOException e) {
            log.error("allUser error", e);
        }
        return userVOList;
    }

    /**
     * 根据wxId获取头像
     *
     * @param wxId wxId
     * @return 头像
     */
    private String getAvatar(String wxId) {
        DynamicDataSourceContextHolder.push(DSNameUtil.getDSName(wxId, DataSourceType.MICRO_MSG_DB));
        String avatar = contactHeadImgUrlRepository.queryHeadImgUrlByUserName(wxId);
        DynamicDataSourceContextHolder.clear();
        return avatar;
    }

    /**
     * 根据wxId获取昵称
     *
     * @param wxId wxId
     * @return 昵称
     */
    private String getNickName(String wxId) {
        DynamicDataSourceContextHolder.push(DSNameUtil.getDSName(wxId, DataSourceType.MICRO_MSG_DB));
        String nickName = contactRepository.getNickName(wxId);
        DynamicDataSourceContextHolder.clear();
        return nickName;
    }
}
