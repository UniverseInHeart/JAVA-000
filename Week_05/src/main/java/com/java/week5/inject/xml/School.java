package com.java.week5.inject.xml;

public class School {

    Klass class1;

    Student student;

    public void ding() {

        System.out.println("Class1 have " + this.class1.students.size() + " students and one is " + this.student);

    }

}
