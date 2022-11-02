package com.sheepfly.springpro.chapter10.bean;

import javax.validation.constraints.AssertTrue;

public class User {
    private String username;
    private String gender;
    private int age;

    @AssertTrue(message = "禁止未成年人观看")
    public boolean isAdult() {
        if (age < 18) {
            return false;
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
