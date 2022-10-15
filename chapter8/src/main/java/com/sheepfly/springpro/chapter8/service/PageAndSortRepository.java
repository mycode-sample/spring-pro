package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageAndSortRepository extends JpaRepository<Singer, Long> {
}
