package com.sheepfly.springpro.chapter6.section9;

import com.sheepfly.springpro.chapter6.daos.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class JdbcTemplateRunner {
    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateRunner.class);

    @Resource(name = "simpleDaoImpl")
    private SimpleDao simpleDao;

    public void work() {
        runQueryById();
        runQueryByName();
        runQueryAllList();
    }

    private void runQueryAllList() {
        log.info(simpleDao.queryAllList().toString());
    }

    private void runQueryByName() {
        Map<String, Object> map = simpleDao.queryOneByName("Ed");
        log.info(map.toString());
    }

    public void runQueryById() {
        List<Map<String, Object>> list = simpleDao.queryById("1");
        log.info("数量:" + list.size());
    }
}
