package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class FormController {

    @FXML
    private TextField fullNameField, emailField, phoneField;

    @FXML
    private TextArea addressArea, educationArea, skillsArea, experienceArea, projectsArea;

    @FXML
    private ImageView photoView;

    private File selectedImageFile;

    @FXML
    private void onChooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            selectedImageFile = file;
            Image image = new Image(file.toURI().toString());
            photoView.setImage(image);
        }
    }

    @FXML
    private void onGenerateCV() {
        if (fullNameField.getText().isEmpty() || emailField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields (Full Name and Email).");
            alert.showAndWait();
            return;
        }

        StringBuilder cv = new StringBuilder();
        cv.append("Full Name: ").append(fullNameField.getText()).append("\n")
                .append("Email: ").append(emailField.getText()).append("\n")
                .append("Phone: ").append(phoneField.getText()).append("\n")
                .append("Address: ").append(addressArea.getText()).append("\n")
                .append("Education: ").append(educationArea.getText()).append("\n")
                .append("Skills: ").append(skillsArea.getText()).append("\n")
                .append("Work Experience: ").append(experienceArea.getText()).append("\n")
                .append("Projects: ").append(projectsArea.getText()).append("\n");

        if (selectedImageFile != null) {
            cv.append("Photo: ").append(selectedImageFile.getAbsolutePath()).append("\n");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Generated CV");
        alert.setHeaderText("Your CV");
        alert.setContentText(cv.toString());
        alert.showAndWait();
    }
}
