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

        TableColumn<String[], String> materialCol = new TableColumn<>("Matériel");
        materialCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[0]));

        TableColumn<String[], String> gradeCol = new TableColumn<>("Note");
        gradeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[1]));

        painting.getColumns().addAll(Arrays.asList(materialCol, gradeCol));

        TextField materialField = new TextField();
        materialField.setPromptText("Matériel");
        TextField gradeField = new TextField();
        gradeField.setPromptText("Note");

        Label titleLabel = new Label(buildTitle(student));

        Button addButton = new Button("Ajouter");
        addButton.setOnAction(e -> {
            String material = materialField.getText();
            double grade = Double.parseDouble(gradeField.getText());

            student.addMaterial(material, grade);
            painting.getItems().add(new String[] { material, String.valueOf(grade) });

            titleLabel.setText(buildTitle(student));
            if (parentList != null && studentIndex >= 0) {
                parentList.getItems().set(studentIndex, student.toString());
            }

            materialField.clear();
            gradeField.clear();
        });

        HBox form = new HBox(10, materialField, gradeField, addButton);
        VBox root = new VBox(15, titleLabel, painting, form);
        root.setStyle("-fx-padding: 20;");

        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    private String buildTitle(Student student) {
        return String.format("Détails de %s - Moyenne: %s",
                student.getName(),
                student.getMaterials().isEmpty() ? "--" : String.format("%.2f", student.getAverage()));
    }
}
