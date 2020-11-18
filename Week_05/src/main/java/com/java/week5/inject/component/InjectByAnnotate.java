package com.java.week5.inject.component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectByAnnotate {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CreateStudentConfig.class);
        context.refresh();

        Klass aClass = context.getBean(Klass.class);
        aClass.dong();
    }
}
