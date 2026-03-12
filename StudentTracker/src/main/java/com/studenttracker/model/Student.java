package com.studenttracker.model;

public class Student {
    private String name;
    private Double grade;

    public Student(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " - grade " + grade;
    }
}