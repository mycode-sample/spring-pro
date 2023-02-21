package com.sheepfly.springpro.chapter10.bean;

public class Company {
    private User user;
    private Person person;

    @Override
    public String toString() {
        return "Company{" +
                "user=" + user +
                ", person=" + person +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
