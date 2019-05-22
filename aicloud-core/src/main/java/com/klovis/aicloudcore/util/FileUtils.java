package com.klovis.aicloudcore.util;

import net.coobird.thumbnailator.Thumbnails;
import java.io.File;
import java.util.Base64;

/**
 * @program: aicloud-core
 * @description:
 * @author: klovis
 * @create: 2019-05-14 11:00
 **/
public abstract class FileUtils extends org.apache.commons.io.FileUtils {

    /**
     * <p>
     * 1. 压缩文件<br>
     * 2. 转换成Base64字符串<br>
     * 3. 默认文件名后缀为 .jpeg
     * </p>
     * @param source 文件二进制流
     * @param maxSize
     * @return
     * @throws Exception
     */
    public static String compressAndBase64(byte[] source, long maxSize) throws Exception {
        return compressAndBase64(source, maxSize, ".jpeg");
    }

    /**
     * <p>
     * 1. 压缩文件<br>
     * 2. 转换成Base64字符串<br>
     * </p>
     * @param source 文件二进制流
     * @param maxSize
     * @param suffix 文件后缀
     * @return
     * @throws Exception
     */
    public static String compressAndBase64(byte[] source, long maxSize, String suffix) throws Exception {
        byte[] bytes = compress(source, maxSize, suffix);
        String value = Base64.getEncoder().encodeToString(bytes);
        return value;
    }

    /**
     * <p>
     * 1. 压缩文件<br>
     * </p>
     * @param source 文件二进制流
     * @param maxSize
     * @param suffix 文件后缀
     * @return
     * @throws Exception
     */
    public static byte[] compress(byte[] source, long maxSize, String suffix) throws Exception {
        File file = File.createTempFile("source-", suffix);
        writeByteArrayToFile(file, source);
        byte[] result = compress(file, maxSize);
        // help GC
        file = null;
        return result;
    }

    /**
     * <p>
     * 1. 压缩文件<br>
     * </p>
     * @param source File
     * @param maxSize
     * @return
     * @throws Exception
     */
    public static byte[] compress(File source, long maxSize) throws Exception {
        String fileName = source.getName();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        File target = File.createTempFile("target-", suffix);
        long sourceLength = source.length();
        float quality = 1f;
        if (sourceLength > maxSize) {
            quality = (float) Math.sqrt((maxSize * 1f) / sourceLength);
        }
        Thumbnails.of(source).scale(1f).outputQuality(quality).toFile(target);
        byte[] bytes = readFileToByteArray(target);
        deleteQuietly(target);
        // help GC
        target = null;
        return bytes;
    }

}
