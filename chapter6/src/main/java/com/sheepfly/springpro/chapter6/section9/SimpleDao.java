package com.sheepfly.springpro.chapter6.section9;

import java.util.List;
import java.util.Map;

public interface SimpleDao {
    List<Map<String, Object>> queryById(String id);

    Map<String, Object> queryOneByName(String name);

    List<Map> queryAllList();
}
