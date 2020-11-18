package com.java.week5.inject.component;

import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class Student implements Serializable {

    private int id;
    private String name;


    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Student(){
    }

    public void init() {
        System.out.println("hello...........");
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
