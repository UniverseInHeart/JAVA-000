package com.java.week5.starter;

import com.java.week5.inject.bean.Student;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringOutput implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Student student = (Student)applicationContext.getBean("starter_one");
        Student student1 = (Student)applicationContext.getBean("starter_two");

        System.out.println(student);
        System.out.println(student1);
    }
}
