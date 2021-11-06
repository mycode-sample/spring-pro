package com.sheepfly.springpro.chapter5.section4;

import java.util.ArrayList;
import java.util.List;

public class SessionManagement {
    private List<String> session = new ArrayList<>();

    public void addSession(String session) {
        this.session.add(session);
    }

    public String removeSession(int index) {
        return session.remove(index);
    }

    public String doService(int index, String message) {
        return this.session.get(index) + ": " + message;
    }
}
