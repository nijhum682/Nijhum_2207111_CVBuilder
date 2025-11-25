package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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

    @FXML private TextField graduationUniversityField, graduationDepartmentField, graduationYearField, graduationCGPAField;

    @FXML private VBox skillsBox;
    @FXML private VBox experienceBox;
    @FXML private VBox projectsBox;

    @FXML private ImageView photoView;

    private String photoPath = "";
    private final CVThreadRepository cvRepository = new CVThreadRepository();

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
            photoPath = file.getAbsolutePath();
        }
    }

    private List<String> getAllSkills() {
        return skillsBox.getChildren().stream()
                .filter(n -> n instanceof TextArea)
                .map(n -> ((TextArea) n).getText())
                .collect(Collectors.toList());
    }

    private List<String> getAllExperience() {
        return experienceBox.getChildren().stream()
                .filter(n -> n instanceof TextArea)
                .map(n -> ((TextArea) n).getText())
                .collect(Collectors.toList());
    }

    private List<String> getAllProjects() {
        return projectsBox.getChildren().stream()
                .filter(n -> n instanceof TextArea)
                .map(n -> ((TextArea) n).getText())
                .collect(Collectors.toList());
    }

    @FXML
    private void onGenerateCV(ActionEvent event) throws IOException {
        List<String> skills = getAllSkills();
        List<String> experience = getAllExperience();
        List<String> projects = getAllProjects();

        Info info = new Info(
                0,
                fullNameField.getText(),
                fatherNameField.getText(),
                motherNameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                photoPath,
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
                graduationUniversityField.getText(),
                graduationDepartmentField.getText(),
                graduationYearField.getText(),
                graduationCGPAField.getText(),
                skills,
                experience,
                projects
        );

        cvRepository.insertCVAsync(info, success -> {
            if (success) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("CV saved successfully!");
                alert.showAndWait();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("cv-show.fxml"));
                try {
                    Scene scene = new Scene(loader.load());
                    CvController controller = loader.getController();
                    controller.setCVData(
                            info.getFullName(),
                            info.getFatherName(),
                            info.getMotherName(),
                            info.getEmail(),
                            info.getPhone(),
                            info.getArea(),
                            info.getUpazilla(),
                            info.getDistrict(),
                            info.getDivision(),
                            info.getJscSchool(),
                            info.getJscYear(),
                            info.getJscBoard(),
                            info.getJscGpa(),
                            info.getSscSchool(),
                            info.getSscYear(),
                            info.getSscBoard(),
                            info.getSscGpa(),
                            info.getHscCollege(),
                            info.getHscYear(),
                            info.getHscBoard(),
                            info.getHscGpa(),
                            info.getGraduationUniversity(),
                            info.getGraduationDepartment(),
                            info.getGraduationYear(),
                            info.getGraduationCgpa(),
                            String.join("\n", info.getSkills()),
                            String.join("\n", info.getExperience()),
                            String.join("\n", info.getProjects()),
                            photoView.getImage()
                    );
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
