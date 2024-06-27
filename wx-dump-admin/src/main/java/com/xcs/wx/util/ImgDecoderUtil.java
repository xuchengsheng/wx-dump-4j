package com.xcs.wx.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 图片解密工具类
 *
 * @author xcs
 * @date 2023年12月28日 15时44分
 **/
@Slf4j
public class ImgDecoderUtil {

    /**
     * 图片文件头信息定义：JPEG, PNG, GIF
     */
    private static final int[] PIC_HEAD = {0xff, 0xd8, 0x89, 0x50, 0x47, 0x49};

    /**
     * 解密.dat文件并将其转换为图片。
     * 根据文件类型将输出文件保存为相应的图片格式。
     *
     * @param filePath 输入文件的路径。
     * @param outPath  输出文件的目标路径。
     */
    public static String decodeDat(String filePath, String outPath) {
        try {
            // 创建文件对象并检查文件是否存在
            File file = new File(filePath);
            if (!file.exists()) {
                return null;
            }

            // 获取文件的解密代码
            int[] codeResult = getCode(filePath);
            int fileType = codeResult[0];
            int decodeCode = codeResult[1];

            // 如果解密代码为-1，说明文件类型不支持或读取有误，退出方法
            if (decodeCode == -1) {
                return null;
            }

            // 文件后缀
            String extension;

            switch (fileType) {
                case 1:
                    extension = ".jpg";
                    break;
                case 3:
                    extension = ".png";
                    break;
                case 5:
                    extension = ".gif";
                    break;
                default:
                    extension = ".jpg";
                    break;
            }
            // 获取文件名（不包含扩展名）
            String fileName = file.getName();
            // 文件名+后缀
            String picName = fileName.replace(".dat", "") + extension;

            // 构造输出文件的完整路径
            String fileOutPath = Paths.get(outPath, picName).toString();

            // 检查输出文件是否已存在
            if (new File(fileOutPath).exists()) {
                return fileOutPath;
            }

            // 读取文件数据
            byte[] data = Files.readAllBytes(Paths.get(filePath));

            // 创建输出流并写入解密后的数据
            try (FileOutputStream fileOut = new FileOutputStream(fileOutPath)) {
                for (byte b : data) {
                    // 对每个字节进行异或操作以解密
                    fileOut.write(b ^ decodeCode);
                }
            }
            return fileOutPath;
        } catch (IOException e) {
            log.error("decode dat failed", e);
        }
        return null;
    }

    /**
     * 获取.dat文件的解密代码。
     * 读取文件的前两个字节并与已知的图片头信息比对，以确定文件类型和解密密钥。
     *
     * @param filePath 输入文件的路径。
     * @return 返回一个包含文件类型和解密密钥的数组。
     */
    private static int[] getCode(String filePath) {
        // 创建一个文件对象
        File file = new File(filePath);

        // 检查文件是否是一个目录
        if (file.isDirectory()) {
            return new int[]{-1, -1};
        }

        try (FileInputStream datFile = new FileInputStream(filePath)) {
            // 准备一个字节数组来读取文件的前两个字节
            byte[] datRead = new byte[2];

            // 读取前两个字节
            if (datFile.read(datRead, 0, 2) != 2) {
                return new int[]{-1, -1};
            }

            // 遍历图片头信息，检查文件类型
            for (int i = 0; i < PIC_HEAD.length; i += 2) {
                // 计算解密代码
                int code = (datRead[0] & 0xff) ^ PIC_HEAD[i];
                // 使用解密代码对第二个字节进行验证
                int idfCode = (datRead[1] & 0xff) ^ code;

                // 检查验证后的字节是否匹配图片头信息
                if (idfCode == PIC_HEAD[i + 1]) {
                    return new int[]{i, code};
                }
            }
        } catch (IOException e) {
            log.error("decode dat getCode failed", e);
        }

        // 如果没有匹配的文件类型，返回错误代码
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        decodeDat("D:\\xuchengsheng\\output_file1", "D:\\");
    }
}
