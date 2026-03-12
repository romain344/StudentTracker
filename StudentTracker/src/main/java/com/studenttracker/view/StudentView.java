package com.studenttracker.view;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class StudentView {
    public TextField nameField = new TextField();
    public TextField gradeField = new TextField();
    public Button addButton = new Button("Add");
    public ListView<String> studentList = new ListView<>();

    public VBox getLayout() {
        nameField.setPromptText("Name");
        gradeField.setPromptText("Grade");

        HBox form = new HBox(10, nameField, gradeField, addButton);
        VBox layout = new VBox(15, form, studentList);
        return layout;
    }
}