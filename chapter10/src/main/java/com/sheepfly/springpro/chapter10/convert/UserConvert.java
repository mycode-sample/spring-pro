package com.sheepfly.springpro.chapter10.convert;

import com.sheepfly.springpro.chapter10.bean.Person;
import com.sheepfly.springpro.chapter10.bean.User;
import org.springframework.core.convert.converter.Converter;

public class UserConvert implements Converter<Person, User> {
    @Override
    public User convert(Person source) {
        User user = new User();
        user.setUsername(source.getUsername());
        user.setAge(source.getAge());
        user.setGender(source.getGender());
        return user;
    }
}
