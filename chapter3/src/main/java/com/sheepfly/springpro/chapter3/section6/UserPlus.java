package com.sheepfly.springpro.chapter3.section6;

import org.example.beans.entity.User;

public class UserPlus extends User {
    public UserPlus() {
        System.out.println("init UserPlus.");
    }

    public void work() {
        System.out.println("start work");
        System.out.println("end work");
    }
}
