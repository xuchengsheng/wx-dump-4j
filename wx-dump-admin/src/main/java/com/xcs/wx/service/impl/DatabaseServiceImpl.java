package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.creator.druid.DruidConfig;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.constant.SqliteConstant;
import com.xcs.wx.domain.bo.DecryptBO;
import com.xcs.wx.domain.dto.DecryptDTO;
import com.xcs.wx.domain.vo.DecryptVO;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.exception.BizException;
import com.xcs.wx.service.DatabaseService;
import com.xcs.wx.service.DecryptService;
import com.xcs.wx.service.UserService;
import com.xcs.wx.service.WeChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 注册数据源实现类
 *
 * @author xcs
 * @date 2023年12月25日19:30:26
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DatabaseServiceImpl implements DatabaseService, ApplicationRunner {

    private final DecryptService decryptService;
    private final WeChatService weChatService;
    private final UserService userService;

    @Override
    public void decrypt(SseEmitter emitter, DecryptDTO decryptDTO) {
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 微信目录
        String dbPath = decryptDTO.getBasePath() + separator + decryptDTO.getWxId();
        // 秘钥
        String key = weChatService.getKey(decryptDTO.getPid(), dbPath);
        // 获取微信秘钥失败
        if (StrUtil.isBlank(key)) {
            throw new BizException(-1, "获取微信秘钥失败，请稍后再试。");
        }
        // 扫描目录
        String scanPath = dbPath + separator + "MSG";
        // 输出目录
        String outputPath = System.getProperty("user.dir") + separator + "data" + separator + "db" + separator + decryptDTO.getWxId() + separator;
        // 使用Files.walk创建一个Stream来遍历给定路径下的所有文件和目录
        try (Stream<Path> stream = Files.walk(Paths.get(scanPath))) {
            // 过滤出非目录的文件
            List<DecryptBO> decryptBOList = getWeChatDb(stream, outputPath);
            // 遍历解密
            for (int i = 0; i < decryptBOList.size(); i++) {
                DecryptBO decryptBO = decryptBOList.get(i);
                // 计算进度百分比
                int currentProgress = ((i + 1) * 100) / decryptBOList.size();
                // 当前要处理的文件
                File currentFile = new File(decryptBO.getInput());
                // 响应给前端的对象
                DecryptVO decryptVO = DecryptVO.builder().fileName(FileUtil.getName(currentFile)).fileSize(FileUtil.readableFileSize(currentFile)).total(decryptBOList.size()).currentProgress(currentProgress).build();
                try {
                    emitter.send(ResponseVO.ok(decryptVO), MediaType.APPLICATION_JSON);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // 解密
                decryptService.wechatDecrypt(key, decryptBO);
                // 注册数据源
                registerDataSource(decryptBO.getOutput());
            }
            userService.saveBasePath(decryptDTO.getWxId(), decryptDTO.getBasePath());
        } catch (Exception e) {
            log.error("Sqlite database decryption failed", e);
        } finally {
            emitter.complete();
        }
    }

    /**
     * 获取微信的db文件
     *
     * @param stream     目录
     * @param outputPath 输出目录
     * @return DecryptBO
     */
    private List<DecryptBO> getWeChatDb(Stream<Path> stream, String outputPath) {
        return stream.filter(file -> !Files.isDirectory(file))
                // 过滤出文件名以.db结尾的文件
                .filter(file -> file.toString().endsWith(".db"))
                // 过滤指定的数据库文件
                .filter(file -> {
                    String filePath = file.toString();
                    // 聊天记录数据库
                    return filePath.matches(".*\\\\MSG\\d+\\.db") ||
                            // 联系人
                            filePath.endsWith(DataSourceType.MICRO_MSG_DB) ||
                            // 朋友圈
                            filePath.endsWith(DataSourceType.SNS_DB) ||
                            // 索引联系人
                            filePath.endsWith(DataSourceType.FTS_CONTACT_DB) ||
                            // 图片
                            filePath.endsWith(DataSourceType.HARD_LINK_IMAGE_DB) ||
                            // 头像
                            filePath.endsWith(DataSourceType.MISC_DB) ||
                            // 视频
                            filePath.endsWith(DataSourceType.HARD_LINK_VIDEO_DB);
                })
                // 将每个符合条件的文件路径映射为DecryptDTO对象
                .map(item -> new DecryptBO(item.toString(), outputPath + FileUtil.getName(item.toString())))
                // 转换成List
                .collect(Collectors.toList());
    }

    @Override
    public void run(ApplicationArguments args) {
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 获取当前工作目录下的 db 目录
        String dbPath = System.getProperty("user.dir") + separator + "data" + separator + "db";
        // 获得目录
        Path dbDirectory = Paths.get(dbPath);
        // 检查目录是否存在
        if (!Files.exists(dbDirectory)) {
            return;
        }
        // 使用 Files.walk 创建一个 Stream 来遍历给定路径下的所有文件和目录
        try (Stream<Path> stream = Files.walk(dbDirectory)) {
            // 处理文件流
            stream.filter(file -> !Files.isDirectory(file))
                    // 过滤出文件名以 .db 结尾的文件
                    .filter(file -> file.toString().endsWith(".db"))
                    // 将每个符合条件的文件创建 DataSourceProperty 对象
                    .forEach(dbFile -> registerDataSource(dbFile.toString()));
        } catch (Exception e) {
            log.error("Failed to register the data source", e);
        }
    }

    /**
     * 动态注册数据源
     *
     * @param dbPath 数据库路径
     */
    private void registerDataSource(String dbPath) {
        String wxId = FileUtil.getName(FileUtil.getParent(dbPath, 1));
        String dbName = FileUtil.getName(dbPath);
        DruidConfig druidConfig = new DruidConfig();
        druidConfig.setInitialSize(5);
        druidConfig.setMinIdle(5);
        druidConfig.setMaxActive(20);
        druidConfig.setMaxWait(60000);
        druidConfig.setValidationQuery("SELECT 1");
        druidConfig.setTestWhileIdle(true);
        druidConfig.setTestOnBorrow(false);
        druidConfig.setTestOnReturn(false);
        druidConfig.setPoolPreparedStatements(true);
        DataSourceProperty sourceProperty = new DataSourceProperty();
        sourceProperty.setUrl(SqliteConstant.URL_PREFIX + dbPath);
        sourceProperty.setDriverClassName(SqliteConstant.DRIVER_CLASS_NAME);
        sourceProperty.setPoolName(wxId + "#" + dbName);
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringUtil.getBean(DynamicRoutingDataSource.class);
        DefaultDataSourceCreator dataSourceCreator = SpringUtil.getBean(DefaultDataSourceCreator.class);
        DataSource dataSource = dataSourceCreator.createDataSource(sourceProperty);
        dynamicRoutingDataSource.addDataSource(sourceProperty.getPoolName(), dataSource);
    }
}
