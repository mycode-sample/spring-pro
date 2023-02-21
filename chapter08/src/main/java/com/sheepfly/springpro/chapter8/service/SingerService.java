package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;
import com.sheepfly.springpro.chapter8.pojo.SingerSummary;

import java.util.List;

public interface SingerService {
    List<Singer> findByCriteriaQuery(String firstName, String lastName);

    List<Singer> queryAllSinger();

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(long id);

    Singer save(Singer singer);

    Singer update(Singer singer);

    void delete(Singer singer);

    List<Singer> findAllByNativeQuery();

    void displayAllSingerSummary();

    List<SingerSummary> findAllUsePojo();

    Singer findSingerWithMaxId();

    List<Singer> findByFirstName(String firstName);

    Long countAllSingers();
}
