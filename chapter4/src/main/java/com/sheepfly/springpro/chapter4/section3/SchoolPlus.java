package com.sheepfly.springpro.chapter4.section3;

import org.example.beans.education.School;

import javax.annotation.PostConstruct;

public class SchoolPlus extends School {
    @PostConstruct
    public void init() {
        if (super.getName() == null) {
            System.out.println("没有学校名称，将设置为默认名称");
            super.setName("希望小学");
        } else {
            System.out.println("学校名称:" + super.getName());
        }
    }
}
