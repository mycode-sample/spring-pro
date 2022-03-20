package com.sheepfly.springpro.chapter7.dao;


import com.sheepfly.springpro.chapter7.entity.Singer;

import java.util.List;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
public interface SingerDao {

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer singer);

    void saveOrUpdate(Singer singer);

    void delete(Singer singer);
}
