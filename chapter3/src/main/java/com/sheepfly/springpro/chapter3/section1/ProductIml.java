package com.sheepfly.springpro.chapter3.section1;

import org.example.beans.entity.Company;
import org.example.beans.entity.User;

public class ProductIml implements Product {
    private Company company;
    private User user;

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
