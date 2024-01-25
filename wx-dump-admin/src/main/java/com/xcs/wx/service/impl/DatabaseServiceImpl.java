package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.constant.SqliteConstant;
import com.xcs.wx.domain.Msg;
import com.xcs.wx.domain.bo.DecryptBO;
import com.xcs.wx.domain.vo.WeChatVO;
import com.xcs.wx.repository.MsgRepository;
import com.xcs.wx.service.DatabaseService;
import com.xcs.wx.service.DecryptService;
import com.xcs.wx.service.WeChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    private final WeChatService weChatService;
    private final DecryptService decryptService;
    private final MsgRepository msgRepository;

    @Override
    public void decrypt() {
        // 查询微信配置
        WeChatVO weChatDTO = weChatService.queryWeChat();
        // 文件分隔符
        String separator = System.getProperty("file.separator");
        // 扫描目录
        String scanPath = weChatDTO.getBasePath() + separator + weChatDTO.getWxId() + separator + "MSG";
        // 替换目录
        String replacementPath = System.getProperty("user.dir") + separator + "db";
        // 使用Files.walk创建一个Stream来遍历给定路径下的所有文件和目录
        try (Stream<Path> stream = Files.walk(Paths.get(scanPath))) {
            // 过滤出非目录的文件
            stream.filter(file -> !Files.isDirectory(file))
                    // 过滤出文件名以.db结尾的文件
                    .filter(file -> file.toString().endsWith(".db"))
                    // 过滤指定的数据库文件
                    .filter(file -> {
                        String filePath = file.toString();
                        // 聊天记录数据库
                        return filePath.matches(".*\\\\MSG\\d+\\.db") ||
                                // 联系人数据库
                                filePath.endsWith("MicroMsg.db") ||
                                // 朋友圈数据库
                                filePath.endsWith("Sns.db") ||
                                // 索引联系人数据库
                                filePath.endsWith("FTSContact.db") ||
                                // 图片数据库
                                filePath.endsWith("HardLinkImage.db");
                    })
                    // 将每个符合条件的文件路径映射为DecryptDTO对象
                    .map(item -> new DecryptBO(item.toString(), item.toString().replace(scanPath, replacementPath)))
                    // 批量解密
                    .forEach(decryptBO -> {
                        // 解密
                        decryptService.wechatDecrypt(weChatDTO.getKey(), decryptBO);
                        // 注册数据源
                        registerDataSource(decryptBO.getOutput());
                        // 赋值一份出来作为模板
                        if (decryptBO.getOutput().endsWith(DataSourceType.MSG0_DB)) {
                            // 原始地址
                            String msgDb = decryptBO.getOutput();
                            // 目标地址
                            String copyPath = msgDb.replace(DataSourceType.MSG0_DB, DataSourceType.MSG_DB);
                            // 复制一份出来
                            if (!FileUtil.exist(copyPath)) {
                                FileUtil.copy(msgDb, copyPath, true);
                            }
                            // 注册数据源
                            registerDataSource(copyPath);
                        }
                    });
            // 合并聊天记录
            mergeMsg();
        } catch (Exception e) {
            log.error("Sqlite数据库解密失败", e);
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

    @Override
    public void run(ApplicationArguments args) {
        // 文件分隔符
        String separator = System.getProperty("file.separator");
        // 获取当前工作目录下的 db 目录
        String dbPath = System.getProperty("user.dir") + separator + "db";
        // 获得目录
        Path dbDirectory = Paths.get(dbPath);
        // 检查目录是否存在
        if (!Files.exists(dbDirectory)) {
            log.info("Directory does not exist: " + dbPath);
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
     * 合并消息
     */
    private void mergeMsg() {
        List<String> msgDbs = DataSourceType.getMsgDb();
        // 获取MSG.db库的最大序列号
        Long nextSequence = msgRepository.getNextSequence(DataSourceType.MSG_DB);
        // 从第二个数据库(MSG0.db)开始合并
        for (int i = 1; i < msgDbs.size(); i++) {
            String msgDb = msgDbs.get(i);
            // 合并聊天记录
            nextSequence = doMergeMsg(DataSourceType.MSG_DB, msgDb, nextSequence);
        }
    }

    /**
     * 合并聊天记录
     *
     * @param targetDb     合并聊天记录的目标数据库
     * @param sourceDb     原始聊天记录数据库
     * @param nextSequence 下一个序列号
     */
    public Long doMergeMsg(String targetDb, String sourceDb, Long nextSequence) {
        // 查询数据
        List<Msg> records = msgRepository.queryMsgBySequence(sourceDb, nextSequence);
        // 空校验
        if (records == null || records.isEmpty()) {
            return nextSequence;
        }
        // 保存数据
        msgRepository.saveBatch(targetDb, records);
        // 返回下一个Sequence
        return records.get(records.size() - 1).getSequence();
    }
}
