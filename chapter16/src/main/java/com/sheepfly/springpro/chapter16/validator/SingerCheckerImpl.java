package com.sheepfly.springpro.chapter16.validator;

import com.sheepfly.springpro.chapter16.entities.Singer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SingerCheckerImpl implements ConstraintValidator<SingerChecker, Singer> {
    @Override
    public void initialize(SingerChecker constraintAnnotation) {

    }

    @Override
    public boolean isValid(Singer value, ConstraintValidatorContext context) {
        if (value.getId() == null) {
            return false;
        }
        return true;
    }
}
