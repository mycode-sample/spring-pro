package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingerRepositoryService extends CrudRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);
}
