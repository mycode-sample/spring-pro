package com.sheepfly.springpro.chapter4.section3;

import org.example.beans.entity.User;

public class UserPlus extends User {
    public void init() {
        System.out.println("init user.");
        if (super.getName() == null) {
            System.out.println("没有用户名，将设置默认用户名");
            super.setName("default user.");
        } else {
            System.out.println("用户名:" + super.getName());
        }
    }
}
