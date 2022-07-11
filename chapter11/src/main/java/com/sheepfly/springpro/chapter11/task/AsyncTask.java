package com.sheepfly.springpro.chapter11.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    private static final Logger log = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    @Scheduled(fixedRate = 5000)
    public void doAsyncTask() throws Exception {
        log.info("开始异步任务，睡眠3秒");
        Thread.sleep(3000);
        log.info("完成异步任务，睡眠3秒");
    }

    @Async
    @Scheduled(fixedRate = 2000)
    public void doAsyncTask2() throws Exception {
        log.info("开始异步任务，睡眠5秒");
        Thread.sleep(5000);
        log.info("完成异步任务，睡眠5秒");
    }
}
