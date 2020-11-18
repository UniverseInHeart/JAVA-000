package com.java.week5.inject.bean;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectByAnnotate {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CreateStudentBeanConfig.class);
        context.refresh();

        Klass aClass = (Klass)context.getBean("class");
        aClass.dong();

        Student student = (Student)context.getBean("one");
        student.init();

    }
}
