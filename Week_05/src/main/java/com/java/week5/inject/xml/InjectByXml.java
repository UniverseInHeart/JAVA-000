package com.java.week5.inject.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectByXml {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student)context.getBean("one");
        System.out.println(student.toString());
        Klass klass = (Klass)context.getBean("classOne");
        System.out.println(klass.toString());
    }
}
