package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.SingerAudit;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class JpaAuditDemo {
    @Resource(name = "singerAuditServiceImpl")
    private SingerAuditService singerAuditService;

    public void runDemo() {
        List<SingerAudit> list = singerAuditService.findAll();
        list.forEach(System.out::println);
        SingerAudit singerAudit = list.get(0);
        singerAudit.setFirstName("张三" + System.currentTimeMillis());
        singerAuditService.save(singerAudit);
    }
}
