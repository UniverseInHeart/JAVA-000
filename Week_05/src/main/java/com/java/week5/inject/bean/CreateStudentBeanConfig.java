package com.java.week5.inject.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class CreateStudentBeanConfig {

    @Bean(name = "one")
    public Student createOne() {
        return new Student(1, "xjf");
    }

    @Bean(name = "two")
    public Student createTwo() {
        return new Student(2, "lj");
    }

    @Bean(name = "list")
    public List<Student> createList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(createOne());
        studentList.add(createTwo());
        return studentList;
    }

    @Bean(name = "class")
    public Klass createClass(List<Student> student) {
        Klass klass = new Klass(student);
        return klass;
    }
}
