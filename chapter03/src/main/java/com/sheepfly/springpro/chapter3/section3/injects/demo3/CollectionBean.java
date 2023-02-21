package com.sheepfly.springpro.chapter3.section3.injects.demo3;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
    private List list;
    private Map map;
    private Set set;
    private Properties properties;

    public void display() {
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);
        System.out.println(set);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
