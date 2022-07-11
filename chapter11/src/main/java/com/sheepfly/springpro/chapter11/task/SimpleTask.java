package com.sheepfly.springpro.chapter11.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class SimpleTask {
    private static final Logger log = LoggerFactory.getLogger(SimpleTask.class);

    public void doTask() {
        log.info("任务开始");
        log.info(new Date().toString());
        log.info("任务完成");
    }
}
