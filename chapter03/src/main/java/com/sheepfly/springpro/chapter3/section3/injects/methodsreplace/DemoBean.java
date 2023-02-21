package com.sheepfly.springpro.chapter3.section3.injects.methodsreplace;

import org.example.beans.entity.Company;
import org.example.beans.entity.User;

public class DemoBean {
    public void display(User user) {
        System.out.println("username:" + user.getName());
    }

    public void display(Company company) {
        System.out.println("companyName:" + company.getName());
    }
}
