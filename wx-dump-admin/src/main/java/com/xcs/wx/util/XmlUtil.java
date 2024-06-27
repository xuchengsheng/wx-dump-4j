package com.xcs.wx.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * xml解析工具类
 *
 * @author xcs
 * @date 2024年01月24日 14时14分
 **/
@Slf4j
public class XmlUtil {

    private static final XmlMapper MAPPER = new XmlMapper();

    private XmlUtil() {
    }

    /**
     * 解析 XML
     *
     * @param content   被解析的内容
     * @param valueType 被解析的类对象
     * @param <T>       泛型参数
     * @return T
     */
    public static <T> T parseXml(String content, Class<T> valueType) {
        try {
            int xmlStart = content.indexOf("<?xml");
            if (xmlStart > 0) {
                content = content.substring(xmlStart);
            }
            return MAPPER.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            log.error("parse xml failed", e);
        }
        return null;
    }
}
