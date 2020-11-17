package com.java.week5.aop;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        IStudent xiaoming = new Student();
        Class[] interfaces = {IStudent.class};
        ProxyHandler proxyHandler = new ProxyHandler(xiaoming);
        Object o = Proxy.newProxyInstance(Test.class.getClassLoader(), interfaces, proxyHandler);
        System.out.println(o instanceof  IStudent);
        System.out.println(o.getClass());
        IStudent iStudent = (IStudent) o;
        iStudent.toClass();
    }
}
