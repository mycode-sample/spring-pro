package com.sheepfly.springpro.chapter4.section9;

import org.example.beans.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

public class UserFactoryBean implements FactoryBean<User>, InitializingBean {
    private Map<String, User> userMap;
    private String userType = "teacher";

    @Override
    public User getObject() throws Exception {
        return userMap.get(userType);
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        userMap = new HashMap<>();
        User teacher = new User("老师", 25, 1);
        User student = new User("张三", 14, 1);
        User president = new User("校长", 44, 1);
        userMap.put("teacher", teacher);
        userMap.put("student", student);
        userMap.put("president", president);
    }
}
