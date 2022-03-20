package com.sheepfly.springpro.chapter7.dao;

import com.sheepfly.springpro.chapter7.entity.Singer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SingerDaoImplTest {
    private ApplicationContext context;
    private SingerDao singerDao;

    @Before
    public void initContext() {
        context = new ClassPathXmlApplicationContext("helloWorld.xml");
        singerDao = context.getBean("singerDao", SingerDao.class);
    }

    @Test
    public void testFindAll() {
        singerDao.findAll().forEach(System.out::println);
    }

    @Test
    public void testFindAllWithAlbum() {
        List<Singer> allWithAlbum = singerDao.findAllWithAlbum();
        allWithAlbum.forEach(ele -> {
            System.out.println(">>>开始>>>");
            System.out.println(ele);
            if (ele.getAlbums() != null) {
                ele.getAlbums().forEach(System.out::println);
            }
            if (ele.getInstruments() != null) {
                ele.getInstruments().forEach(System.out::println);
            }
            System.out.println("<<<结束<<<");
        });
    }

    @Test
    public void testFindById() {
        Singer singer = singerDao.findById(1L);
        System.out.println(singer);
    }
}