package com.klovis.aicloudcore.sequence;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;


/**
 * @program: aicloud
 * @description:
 * @author: klovis
 * @create: 2019-05-14 19:03
 **/
@Slf4j
public class SnowFlake {

    private static long START_TIMESTAMP = 1557833070903L;
    private static int TOTAL_BIT = 64;
    private static int SIGN_BIT = TOTAL_BIT - 1;
    private static int TIMESTAMP_BIT = SIGN_BIT - 41;
    private static int DATA_CENTER_BIT = TIMESTAMP_BIT - 3;
    private static int MACHINE_PER_CENTER_BIT = DATA_CENTER_BIT - 3;
    private static int SEQUENCE_BIT = MACHINE_PER_CENTER_BIT - 9;
    private static int MAX_RANDOM = (1 << SEQUENCE_BIT) - 1;
    private static int SEQUENCE_INIT = 0;
    /**
     * 相对时间
     * @return
     */
    public static long relativeTimestamp() {
        return System.currentTimeMillis() - START_TIMESTAMP;
    }

    /**
     * 获取 9 位的序列号
     * @return
     */
    public static long getSequence() {
        SEQUENCE_INIT++;
        SEQUENCE_INIT &= (1 << 10) - 1;
        return SEQUENCE_INIT;
    }

    public static synchronized long nextId(int dataCenter, int machine) {
        return (relativeTimestamp() << TIMESTAMP_BIT
        | dataCenter << DATA_CENTER_BIT
        | machine << MACHINE_PER_CENTER_BIT
        | getSequence() << SEQUENCE_BIT
        | RandomUtils.nextInt(MAX_RANDOM + 1));
    }

}
