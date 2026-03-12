package com.StudentTracker.controller;

import com.studenttracker.model.Student;
import com.studenttracker.view.StudentView;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private StudentView view;
    private List<Student> students = new ArrayList<>();

    public StudentController(StudentView view) {
        this.view = view;
        view.addButton.setOnAction(e -> addStudent());
    }

    private void addStudent() {
        String name = view.nameField.getText();
        double grade = Double.parseDouble(view.gradeField.getText());

        Student s = new Student(name, grade);
        students.add(s);
        view.studentList.getItems().add(s.toString());

        view.nameField.clear();
        view.gradeField.clear();
    }
}