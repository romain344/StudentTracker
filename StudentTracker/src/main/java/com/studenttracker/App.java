package com.studenttracker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.studenttracker.view.StudentView;
import com.studenttracker.controller.StudentController;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        StudentView view = new StudentView();
        new StudentController(view);
        Scene scene = new Scene(view.getLayout(), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Tracker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
