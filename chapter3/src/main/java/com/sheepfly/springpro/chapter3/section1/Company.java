package com.sheepfly.springpro.chapter3.section1;

import org.example.beans.entity.User;

public class Company implements ManagedComponent {
    private User creator;

    @Override
    public void doSearch(Container container) {
        this.creator = (User) container.getDependency("creator");
    }
}
