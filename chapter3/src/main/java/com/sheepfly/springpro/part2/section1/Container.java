package com.sheepfly.springpro.part2.section1;

import java.util.Map;

public class Container {
    private Map<String, Object> map;

    public void init(Map<String, Object> map) {
        this.map = map;
    }

    public Object getDependency(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }
}
