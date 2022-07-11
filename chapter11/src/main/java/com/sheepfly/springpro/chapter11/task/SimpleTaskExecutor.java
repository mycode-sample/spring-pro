package com.sheepfly.springpro.chapter11.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;

public class SimpleTaskExecutor implements TaskExecutor {
    private static final Logger log = LoggerFactory.getLogger(SimpleTaskExecutor.class);

    @Override
    public void execute(Runnable task) {
        log.info("开始执行任务");
        log.info("任务执行完成");
    }
}
