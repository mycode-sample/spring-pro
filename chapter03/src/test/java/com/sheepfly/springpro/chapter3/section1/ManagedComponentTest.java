package com.sheepfly.springpro.chapter3.section1;

import org.example.beans.entity.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ManagedComponentTest {
    @Test
    public void testDoSearch() {
        Map<String, Object> map = new HashMap<>();
        map.put("creator", new User());
        Container container = new Container();
        container.init(map);

        Company company = new Company();
        map.put("company", company);
        company.doSearch(container);
        School school = new School();
        school.doSearch(container);
        System.out.println(school);
    }
}