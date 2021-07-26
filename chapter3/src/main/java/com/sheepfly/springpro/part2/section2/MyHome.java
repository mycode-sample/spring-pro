package com.sheepfly.springpro.part2.section2;

import org.example.beans.entity.User;

public class MyHome implements Home {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void printAddress() {
        System.out.println("地址");
        System.out.println(MyHome.class.getName());
    }
}
