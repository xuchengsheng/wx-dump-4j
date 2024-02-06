package com.xcs.wx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 微信参数偏移量配置
 *
 * @author xcs
 * @date 2023年12月25日 10时05分
 **/
@Data
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "wechat-offset")
public class WeChatOffsetProperties {

    /**
     * 微信各个版本对应的偏移量配置
     */
    private Map<String, VersionConfig> version;

    @Data
    public static class VersionConfig {
        private Long nickname;
        private Long account;
        private Long mobile;
    }
}
