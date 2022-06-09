package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.SingerAudit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:jpa.xml")
public class SingerAuditServiceImplTest {
    @Autowired
    private SingerAuditService singerAuditService;

    @Test
    public void testFindAll() {
        List<SingerAudit> list = singerAuditService.findAll();
        list.forEach(System.out::println);
        SingerAudit singerAudit = list.get(0);
        singerAudit.setFirstName("张三");
        singerAuditService.save(singerAudit);
        System.out.println(singerAudit);
    }
}