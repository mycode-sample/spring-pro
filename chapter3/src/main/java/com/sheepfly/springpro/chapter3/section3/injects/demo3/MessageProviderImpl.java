package com.sheepfly.springpro.chapter3.section3.injects.demo3;

import com.sheepfly.springpro.chapter2.MessageProvider;
import org.example.beans.entity.Company;
import org.example.beans.entity.User;

public class MessageProviderImpl implements MessageProvider {
    private String message;

    private MessageProviderImpl() {
    }

    public MessageProviderImpl(String message) {
        this.message = message;
    }

    public MessageProviderImpl(User user, Company company) {
        this.message = user.getName() + "_" + company.getName();
        System.out.println("user_company");
    }

    public MessageProviderImpl(String company, String user, String separator) {
        this.message = company + separator + user;
    }


    public MessageProviderImpl(Company company, User user, String separator) {
        this.message = company + separator + user;
    }

    public MessageProviderImpl(Company company, User user ) {
        this.message = user.getName() + "_" + company.getName();
        System.out.println("company_user");
    }

    public MessageProviderImpl(User user) {
        this.message = user.getName();
    }

    public MessageProviderImpl(Company company) {
        this.message = company.getName();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
