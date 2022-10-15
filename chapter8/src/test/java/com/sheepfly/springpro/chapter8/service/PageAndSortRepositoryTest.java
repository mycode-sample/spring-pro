package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@ContextConfiguration("classpath:jpa.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PageAndSortRepositoryTest {
    @Autowired
    private PageAndSortRepository repository;

    @Test
    public void testPage() {
        PageRequest pageRequest = PageRequest.of(3, 4);
        Page<Singer> singerPage = repository.findAll(pageRequest);
        int totalPages = singerPage.getTotalPages();
        System.out.println(totalPages);
        List<Singer> list = singerPage.getContent();
        list.forEach(System.out::println);
    }

    @Test
    public void testSort() {
        Sort sort = Sort.by("firstName").ascending();
        List<Singer> list = repository.findAll(sort);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }

}
