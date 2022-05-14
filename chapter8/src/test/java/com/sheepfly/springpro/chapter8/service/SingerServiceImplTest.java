package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;
import com.sheepfly.springpro.chapter8.pojo.SingerSummary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:jpa.xml")
@RunWith(SpringRunner.class)
public class SingerServiceImplTest {
    @Resource(name = "singerServiceImpl")
    private SingerService singerService;

    @Test
    public void testFindAll() {
        List<Singer> all = singerService.findAll();
        System.out.println(all.size());
        all.forEach(System.out::println);
    }

    @Test
    public void testFindAllWithAlbum() {
        List<Singer> allWithAlbum = singerService.findAllWithAlbum();
        allWithAlbum.forEach(System.out::println);
    }

    @Test
    public void testFindById() {
        System.out.println(singerService.findById(1));
    }

    @Test
    public void testDisplayAllSingerSummary() {
        singerService.displayAllSingerSummary();
    }

    @Test
    public void testFindAllUsePojo() {
        List<SingerSummary> list = singerService.findAllUsePojo();
        System.out.println(list.size());
    }
}