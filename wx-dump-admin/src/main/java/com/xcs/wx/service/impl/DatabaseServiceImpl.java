package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.xcs.wx.constant.SqliteConstant;
import com.xcs.wx.domain.bo.DecryptBO;
import com.xcs.wx.domain.dto.DecryptDTO;
import com.xcs.wx.service.DatabaseService;
import com.xcs.wx.service.DecryptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Override
    public void decrypt(DecryptDTO decryptDTO) {
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 扫描目录
        String scanPath = decryptDTO.getBasePath() + separator + decryptDTO.getWxId() + separator + "MSG";
        // 替换目录
        String replacementPath = System.getProperty("user.dir") + separator + "data" + separator + "db";
        // 使用Files.walk创建一个Stream来遍历给定路径下的所有文件和目录
        try (Stream<Path> stream = Files.walk(Paths.get(scanPath))) {
            // 过滤出非目录的文件
            stream.filter(file -> !Files.isDirectory(file))
                    // 过滤出文件名以.db结尾的文件
                    .filter(file -> file.toString().endsWith(".db"))
                    // 过滤指定的数据库文件
//                    .filter(file -> {
//                        String filePath = file.toString();
//                        // 聊天记录数据库
//                        return filePath.matches(".*\\\\MSG\\d+\\.db") ||
//                                // 联系人
//                                filePath.endsWith("MicroMsg.db") ||
//                                // 朋友圈
//                                filePath.endsWith("Sns.db") ||
//                                // 索引联系人
//                                filePath.endsWith("FTSContact.db") ||
//                                // 图片
//                                filePath.endsWith("HardLinkImage.db") ||
//                                // 视频
//                                filePath.endsWith("HardLinkVideo.db");
//                    })
                    // 将每个符合条件的文件路径映射为DecryptDTO对象
                    .map(item -> new DecryptBO(item.toString(), item.toString().replace(scanPath, replacementPath)))
                    // 批量解密
                    .forEach(decryptBO -> {
                        // 解密
                        decryptService.wechatDecrypt(decryptDTO.getKey(), decryptBO);
                        // 注册数据源
                        registerDataSource(decryptBO.getOutput());
                    });
        } catch (Exception e) {
            log.error("Sqlite database decryption failed", e);
        }
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
        DataSourceProperty sourceProperty = new DataSourceProperty();
        sourceProperty.setUrl(SqliteConstant.URL_PREFIX + dbPath);
        sourceProperty.setDriverClassName(SqliteConstant.DRIVER_CLASS_NAME);
        sourceProperty.setPoolName(FileUtil.getName(dbPath));
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringUtil.getBean(DynamicRoutingDataSource.class);
        DefaultDataSourceCreator dataSourceCreator = SpringUtil.getBean(DefaultDataSourceCreator.class);
        DataSource dataSource = dataSourceCreator.createDataSource(sourceProperty);
        dynamicRoutingDataSource.addDataSource(sourceProperty.getPoolName(), dataSource);
    }
}
