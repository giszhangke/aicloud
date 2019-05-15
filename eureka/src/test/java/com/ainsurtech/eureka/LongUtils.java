package com.ainsurtech.eureka;

public class LongUtils {
        private final static char[] digits = {
                '0' , '1'
        };

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