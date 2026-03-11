package com.StudenTracker.model;

public class Student {
    private String name;
    private Double note;

        public Student(String name, Double note) {
            this.name = name;
            this.note = note;
        }


    public String getname() {return name;}
    public Double getNote() {return note;}

    @Override
    public String toString() {
        return name + " " note "- note" + note;
    }
}