package com.sheepfly.springpro.chapter3.section7;

import org.example.beans.education.School;
import org.example.beans.entity.Company;
import org.example.beans.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoBean {
    private static final Logger log = LoggerFactory.getLogger(DemoBean.class);

    private User user;
    private Company company;
    private School school;
    private Company companyPlus;

    public DemoBean() {
        log.info("调用无参构造函数");
    }

    public DemoBean(User user) {
        log.info("调用user构造函数");
        this.user = user;
    }

    public DemoBean(Company company) {
        log.info("调用company构造函数");
        this.company = company;
    }

    public DemoBean(School school) {
        log.info("调用school构造函数");
        this.school = school;
    }

    public DemoBean(User user, Company company) {
        log.info("调用user，company构造函数");
        this.user = user;
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        log.info("调用setUser");
        this.user = user;
    }

    public Company getCompanyPlus() {
        return companyPlus;
    }

    public void setCompanyPlus(Company companyPlus) {
        this.companyPlus = companyPlus;
    }

    public Company getCompany() {
        log.info("调用setCompany");
        return company;
    }

    public void setCompany(Company company) {
        log.info("调用setCompany");
        this.company = company;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        log.info("调用setSchool");
        this.school = school;
    }
}
