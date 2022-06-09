package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.SingerAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(rollbackFor = Throwable.class)
public class SingerAuditServiceImpl implements SingerAuditService {
    @Autowired
    private SingerAuditRepository singerAuditRepository;

    @Override
    public List<SingerAudit> findAll() {
        Iterable<SingerAudit> iterable = singerAuditRepository.findAll();
        List<SingerAudit> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Override
    public SingerAudit save(SingerAudit singerAudit) {
        return singerAuditRepository.save(singerAudit);
    }
}
