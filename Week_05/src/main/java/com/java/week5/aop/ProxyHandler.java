package com.java.week5.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private IStudent iStudent;

    ProxyHandler(IStudent iStudent) {
        this.iStudent = iStudent;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始了");
        iStudent.toClass();
        System.out.println("结束了");
        return null;
    }
}
