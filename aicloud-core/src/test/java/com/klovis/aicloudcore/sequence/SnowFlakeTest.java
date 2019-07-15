package com.klovis.aicloudcore.sequence;

import com.klovis.aicloudcore.util.LongUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

@Slf4j
public class SnowFlakeTest {
    @Test
    public void nextId() throws Exception {
        long id;
        int i = 0;
        for (;i < 10000; i++) {
            id = SnowFlake.nextId(4, 3);
            log.info("{} {}", id, LongUtils.toFullBinaryString(id));
        }
    }

}