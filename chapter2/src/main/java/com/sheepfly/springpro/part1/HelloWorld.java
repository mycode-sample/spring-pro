package com.sheepfly.springpro.part1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private static Logger log = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        MessageRenderer renderer = new MessageRendererImpl();
        renderer.setMessageProvider(new MessageProviderImpl());
        try {
            renderer.render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
