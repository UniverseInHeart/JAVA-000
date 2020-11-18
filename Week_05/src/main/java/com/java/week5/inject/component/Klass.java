package com.java.week5.inject.component;


import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Klass {

    List<Student> students;

    public Klass(List<Student> students) {
        this.students = students;
    }

    public Klass() {
        System.out.println("使用无参构造器----------");
    }

    public void dong() {
        System.out.println("dong~");
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Klass{" +
                "students=" + students +
                '}';
    }
}
