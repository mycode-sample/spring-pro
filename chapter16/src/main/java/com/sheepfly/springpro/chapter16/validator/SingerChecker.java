package com.sheepfly.springpro.chapter16.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = SingerCheckerImpl.class)
public @interface SingerChecker {
    String message() default "数据错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
