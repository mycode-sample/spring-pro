package com.sheepfly.springpro.chapter3.section1;

import org.example.beans.entity.Company;
import org.example.beans.entity.User;

public interface Product {
    void setCompany(Company company);

    void setUser(User user);
}
