package com.studenttracker.view;

import com.studenttracker.model.Student;
import java.util.Arrays;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class detail {

    public void show(Student student) {
        show(student, null, -1);
    }

    public void show(Student student, ListView<String> parentList, int studentIndex) {
        Stage stage = new Stage();
        stage.setTitle("Détail - " + student.getName());

        TableView<String[]> painting = new TableView<>();

        TableColumn<String[], String> materialCol = new TableColumn<>("Matière");
        materialCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[0]));

        TableColumn<String[], String> gradeCol = new TableColumn<>("Note");
        gradeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[1]));

        TableColumn<String[], String> coefCol = new TableColumn<>("Coefficient");
        coefCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[2]));

        painting.getColumns().addAll(Arrays.asList(materialCol, gradeCol, coefCol));

        TextField materialField = new TextField();
        materialField.setPromptText("Matière");
        TextField gradeField = new TextField();
        gradeField.setPromptText("Note");
        TextField coefField = new TextField("1");
        coefField.setPromptText("Coefficient");

        Label titleLabel = new Label(buildTitle(student));

        Button addButton = new Button("Ajouter");
        addButton.setOnAction(e -> {
            String material = materialField.getText();
            double grade = Double.parseDouble(gradeField.getText());
            double coefficient = Double.parseDouble(coefField.getText());

            student.addMaterial(material, grade, coefficient);
            painting.getItems().add(new String[] { material, String.valueOf(grade), String.valueOf(coefficient) });

            titleLabel.setText(buildTitle(student));
            if (parentList != null && studentIndex >= 0) {
                parentList.getItems().set(studentIndex, student.toString());
            }

            materialField.clear();
            gradeField.clear();
            coefField.setText("1");
        });

        HBox form = new HBox(10, materialField, gradeField, coefField, addButton);
        VBox root = new VBox(15, titleLabel, painting, form);
        root.setStyle("-fx-padding: 20;");

        stage.setScene(new Scene(root, 580, 400));
        stage.show();
    }

    private String buildTitle(Student student) {
        return String.format("Détails de %s - Moyenne pondérée: %s",
                student.getName(),
                student.getMaterials().isEmpty() ? "--" : String.format("%.2f", student.getAverage()));
    }
}
