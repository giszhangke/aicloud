package com.klovis.aicloudcore.job;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: aicloud
 * @description:
 * @author: klovis
 * @create: 2019-05-30 14:47
 **/
@Component
@EnableAsync
@EnableScheduling
public class PrintStringJob {
    private int i = 0;

    @Scheduled(cron="0/3 * * * * ?")
    public void print() {
        System.out.println(i++);
    }

}
