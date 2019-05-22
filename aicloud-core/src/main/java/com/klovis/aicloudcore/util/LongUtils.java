package com.klovis.aicloudcore.util;

/**
 * @program: aicloud-core
 * @description: 
 * @author: klovis
 * @create: 2019-05-14 11:00
 **/
public abstract class LongUtils {

    private final static char[] digits = {
            '0', '1'
    };

    /**
     * 转成完整的二进制字符串，左侧空位补零
     * @param val
     * @return
     */
    public static String toFullBinaryString(long val) {
        int shift = 1;
        int len = Long.SIZE;
        char[] buf = new char[len];
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--len] = digits[((int) val) & mask];
            val >>>= shift;
        } while (len > 0);
        return new String(buf);
    }

}