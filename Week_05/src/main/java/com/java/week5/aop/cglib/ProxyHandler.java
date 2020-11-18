package com.java.week5.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class ProxyHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始了");
        // invokesuper执行的是原始类的方法，invoke执行的是子类的方法，
        // 如果invoke后面传进去参数是子类的话，就会引起循环调用。
        methodProxy.invokeSuper(o, objects);
        System.out.println("结束了");
        return o;
    }
}
