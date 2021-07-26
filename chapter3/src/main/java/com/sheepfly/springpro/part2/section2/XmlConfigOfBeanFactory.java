package com.sheepfly.springpro.part2.section2;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigOfBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(
                new ClassPathResource("com/sheepfly/springpro/iocanddi/di/XmlConfigOfBeanFactory.xml"));
        MyHome myHome = (MyHome) factory.getBean("myHome");
        myHome.printAddress();
    }
}
