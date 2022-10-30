package com.sheepfly.springpro.chapter10.validator;

import com.sheepfly.springpro.chapter16.entities.Singer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SingerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Singer.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName不能为空");
    }
}
