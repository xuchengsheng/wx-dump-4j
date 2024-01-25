package com.xcs.wx.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * LZ4 解压
 *
 * @author xcs
 * @date 2023年12月31日14:58:01
 */
@Slf4j
public class LZ4Util {

    private LZ4Util(){}

    /**
     * 解压
     *
     * @param compressedData 压缩后的数据
     * @return 解压后的字符串
     */
    public static String decompress(byte[] compressedData) {
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(compressedData);
             BufferedInputStream bufferedIn = new BufferedInputStream(byteIn);
             BlockLZ4CompressorInputStream lz4In = new BlockLZ4CompressorInputStream(bufferedIn)) {

            StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[4096];
            int n;
            while ((n = lz4In.read(buffer)) != -1) {
                String chunk = new String(buffer, 0, n, StandardCharsets.UTF_8);
                sb.append(chunk);
            }

            // 删除最后一个字符
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("LZ4解压数据失败", e);
        }
        return null;
    }
}
