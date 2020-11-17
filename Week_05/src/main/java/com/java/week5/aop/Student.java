package com.java.week5.aop;

public class Student implements IStudent{
    @Override
    public void toClass() {
        System.out.println("上课了");
    }
}
