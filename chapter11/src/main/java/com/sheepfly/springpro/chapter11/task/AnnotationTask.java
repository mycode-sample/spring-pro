package com.sheepfly.springpro.chapter11.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AnnotationTask {
    private static final Logger log = LoggerFactory.getLogger(AnnotationTask.class);

    @Scheduled(fixedRate = 1000)
    public void doTask() {
        log.info("开始注解任务");
        log.info("注解任务:" + new Date());
        log.info("完成注解任务");
    }
}
