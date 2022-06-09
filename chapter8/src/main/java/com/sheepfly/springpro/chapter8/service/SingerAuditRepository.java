package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.SingerAudit;
import org.springframework.data.repository.CrudRepository;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
