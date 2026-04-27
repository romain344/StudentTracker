package com.studenttracker.controller;

import com.studenttracker.model.Student;
import com.studenttracker.view.StudentView;
import com.studenttracker.view.detail;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private StudentView view;
    private List<Student> students = new ArrayList<>();

    public StudentController(StudentView view) {
        this.view = view;

        view.addButton.setOnAction(e -> add());

        view.studentList.setOnMouseClicked(e -> {
            int index = view.studentList.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                Student student = students.get(index);
                new detail().show(student, view.studentList, index);
            }
        });
    }

private void add() {
        String name = view.nameField.getText();

        Student s = new Student(name);
        students.add(s);
        view.studentList.getItems().add(s.toString());

        view.nameField.clear();
    }
}
