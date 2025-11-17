package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FormController {

    @FXML private TextField fullNameField;
    @FXML private TextField fatherNameField;
    @FXML private TextField motherNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;

    @FXML private TextField areaField;
    @FXML private TextField upazillaField;
    @FXML private TextField districtField;
    @FXML private TextField divisionField;

    @FXML private TextField jscSchoolField, jscYearField, jscBoardField, jscGPAField;
    @FXML private TextField sscSchoolField, sscYearField, sscBoardField, sscGPAField;
    @FXML private TextField hscCollegeField, hscYearField, hscBoardField, hscGPAField;

    @FXML private VBox skillsBox;
    @FXML private VBox experienceBox;
    @FXML private VBox projectsBox;

    @FXML private ImageView photoView;

    @FXML
    private void onAddSkill() {
        TextArea a = new TextArea();
        a.setPrefRowCount(3);
        skillsBox.getChildren().add(skillsBox.getChildren().size() - 1, a);
    }

    @FXML
    private void onAddExperience() {
        TextArea a = new TextArea();
        a.setPrefRowCount(3);
        experienceBox.getChildren().add(experienceBox.getChildren().size() - 1, a);
    }

    @FXML
    private void onAddProject() {
        TextArea a = new TextArea();
        a.setPrefRowCount(3);
        projectsBox.getChildren().add(projectsBox.getChildren().size() - 1, a);
    }

    @FXML
    private void onChooseImage() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Profile Photo");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            photoView.setImage(new Image(file.toURI().toString()));
        }
    }

    public List<String> getAllSkills() {
        return skillsBox.getChildren().stream()
                .filter(n -> n instanceof TextArea)
                .map(n -> ((TextArea) n).getText())
                .collect(Collectors.toList());
    }

    public List<String> getAllExperience() {
        return experienceBox.getChildren().stream()
                .filter(n -> n instanceof TextArea)
                .map(n -> ((TextArea) n).getText())
                .collect(Collectors.toList());
    }

    public List<String> getAllProjects() {
        return projectsBox.getChildren().stream()
                .filter(n -> n instanceof TextArea)
                .map(n -> ((TextArea) n).getText())
                .collect(Collectors.toList());
    }

    @FXML
    private void onGenerateCV(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cv-show.fxml"));
        Scene scene=new Scene(loader.load());
        CvController controller = loader.getController();


        String skillsText = String.join("\n", getAllSkills());
        String experienceText = String.join("\n", getAllExperience());
        String projectsText = String.join("\n", getAllProjects());

        controller.setCVData(
                fullNameField.getText(),
                fatherNameField.getText(),
                motherNameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                areaField.getText(),
                upazillaField.getText(),
                districtField.getText(),
                divisionField.getText(),
                jscSchoolField.getText(),
                jscYearField.getText(),
                jscBoardField.getText(),
                jscGPAField.getText(),
                sscSchoolField.getText(),
                sscYearField.getText(),
                sscBoardField.getText(),
                sscGPAField.getText(),
                hscCollegeField.getText(),
                hscYearField.getText(),
                hscBoardField.getText(),
                hscGPAField.getText(),
                skillsText,
                experienceText,
                projectsText,
                photoView.getImage()
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
