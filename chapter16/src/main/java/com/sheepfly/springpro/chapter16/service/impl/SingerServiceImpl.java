package com.sheepfly.springpro.chapter16.service.impl;

import com.sheepfly.springpro.chapter16.dao.SingerDao;
import com.sheepfly.springpro.chapter16.entities.Singer;
import com.sheepfly.springpro.chapter16.service.SingerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = Throwable.class)
@Repository
public class SingerServiceImpl implements SingerService {
    @Resource(name = "singerDao")
    private SingerDao singerDao;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        Iterable<Singer> all = singerDao.findAll();
        List<Singer> list = new ArrayList<>();
        all.forEach(list::add);
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        return singerDao.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerDao.save(singer);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Singer> findAllByPage(Pageable pageable) {
        return singerDao.findAll(pageable);
    }
}
