package com.java.week5.inject.bean;


import java.util.List;

public class Klass {

    List<Student> students;

    public Klass(List<Student> students) {
        this.students = students;
    }

    public Klass() {
    }

    public void dong(){
        System.out.println(this.students);
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
