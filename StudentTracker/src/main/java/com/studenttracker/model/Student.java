package com.studenttracker.model;

public class Student {
    private String name;
    private Double grade;

    public Student(String name, Double grade) {
        // this is a clase for name and garde
        this.name = name;
        // for nota
        this.grade = grade;
        // for grade
    }

    public String getName() {
        // the clase for to recover the value for name
        return name;
    }

    public Double getGrade() {
        // the clase for to recover the value for grade
        return grade;
    }

    @Override
    public String toString() {
        // to recover name and grade
        return name + " - grade " + grade;
    }
}