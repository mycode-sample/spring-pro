package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Album;
import com.sheepfly.springpro.chapter7.entity.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ContextConfiguration("classpath:jpa.xml")
@RunWith(SpringRunner.class)
public class AlbumRepositoryTest {
    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void findBySinger() {
        List<Album> list = albumRepository.findBySinger(new Singer());
        list.forEach(System.out::println);
    }

    @Test
    public void findByTitle() {
        List<Album> list = albumRepository.findByTitle("张三");
        list.forEach(System.out::println);
    }
}