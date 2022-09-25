package com.sheepfly.springpro.chapter16.dao;

import com.sheepfly.springpro.chapter16.entities.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerDao extends PagingAndSortingRepository<Singer, Long> {
}
