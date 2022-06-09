package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.SingerAudit;

import java.util.List;

public interface SingerAuditService {
    List<SingerAudit> findAll();

    SingerAudit save(SingerAudit singerAudit);
}
