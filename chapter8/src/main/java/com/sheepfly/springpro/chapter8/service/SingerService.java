package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> queryAllSinger();

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(long id);

    Singer save(Singer singer);

    void delete(Singer singer);

    List<Singer> findAllByNativeQuery();

    void displayAllSingerSummary();

}
