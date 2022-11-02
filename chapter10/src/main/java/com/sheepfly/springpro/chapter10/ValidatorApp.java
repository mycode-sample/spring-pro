package com.sheepfly.springpro.chapter10;

import com.sheepfly.springpro.chapter10.bean.User;
import com.sheepfly.springpro.chapter10.validator.SingerValidator;
import com.sheepfly.springpro.chapter16.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import java.util.Set;

public class ValidatorApp {
    private static final Logger log = LoggerFactory.getLogger(ValidatorApp.class);

    public static void main(String[] args) {
        String packageName = "com.sheepfly.springpro.chapter10";
        ApplicationContext context = new AnnotationConfigApplicationContext(packageName);
        SingerValidator singerValidator = context.getBean("singerValidator", SingerValidator.class);
        Singer singer = new Singer();
        log.info("初始化结果1");
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(singer, "singer");
        log.info("开始验证");
        singerValidator.validate(singer, result);
        result.getAllErrors().forEach(System.out::println);

        singer.setFirstName("张");
        log.info("结果2");
        BeanPropertyBindingResult result2 = new BeanPropertyBindingResult(singer, "singer2");
        log.info("开始验证");
        ValidationUtils.invokeValidator(singerValidator, singer, result2);
        result2.getAllErrors().forEach(System.out::println);
        Validator validator = context.getBean(Validator.class);
        log.info("使用JSR-349验证");
        Set<ConstraintViolation<Singer>> list = validator.validate(singer);
        list.forEach(ele -> {
            Path path = ele.getPropertyPath();
            log.info(path + ": " + ele.getInvalidValue() + ", " + ele.getMessage());
        });
        User user = new User();
        Set<ConstraintViolation<User>> list2 = validator.validate(user);
        list2.forEach(ele -> {
            Path path = ele.getPropertyPath();
            log.info(path + ": " + ele.getInvalidValue() + ", " + ele.getMessage());
        });
        user.setAge(10);
        list2 = validator.validate(user);
        list2.forEach(ele -> {
            Path path = ele.getPropertyPath();
            log.info(path + ": " + ele.getInvalidValue() + ", " + ele.getMessage());
        });
        user.setAge(20);
        list2 = validator.validate(user);
        list2.forEach(ele -> {
            Path path = ele.getPropertyPath();
            log.info(path + ": " + ele.getInvalidValue() + ", " + ele.getMessage());
        });
    }
}
