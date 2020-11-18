package com.java.week5.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Test {

    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(proxyHandler);

        Student student = (Student)enhancer.create();
        student.toClass();
    }
}
