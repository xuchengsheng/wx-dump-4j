package com.xcs.wx.service;

import com.xcs.wx.domain.vo.WeChatConfigVO;

import java.util.List;

/**
 * 微信服务
 *
 * @author xcs
 * @date 2023年12月25日09:37:30
 */
public interface WeChatService {

    /**
     * 获取微信配置信息
     *
     * @return WeChatDTO
     */
    List<WeChatConfigVO> readWeChatConfig();

    /**
     * 获取当前运行的微信进程的进程 ID。
     *
     * @return 微信进程的进程 ID。如果未找到，返回空集合。
     */
    List<Integer> wechatPid();

    /**
     * 根据提供的进程 ID 找到相应进程的模块基地址。
     *
     * @param pid 目标进程的 ID。
     * @return 进程的模块基地址，如果找不到则返回 0。
     */
    long baseAddress(int pid);

    /**
     * 获取指定进程ID的可执行文件版本。
     *
     * @param pid 进程ID。
     * @return 文件的版本号，如果无法获取，则返回 null。
     */
    String getVersion(int pid);

    /**
     * 根据进程ID获取微信ID。
     *
     * @param pid 目标进程ID
     * @return 微信ID
     */
    String getWxId(int pid);

    /**
     * 从指定进程的指定内存地址读取信息。
     *
     * @param pid     目标进程的 ID。
     * @param address 要读取的内存地址。
     * @return 读取到的数据，如果失败则返回 null。
     */
    String getInfo(int pid, long address);

    /**
     * 获取指定进程和数据库路径下的密钥
     *
     * @param pid    目标进程的进程ID
     * @param dbPath 数据库路径
     * @return 返回找到的密钥，如果未找到则返回null
     */
    String getKey(int pid, String dbPath);
}
