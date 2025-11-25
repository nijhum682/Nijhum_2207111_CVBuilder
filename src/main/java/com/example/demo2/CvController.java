package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CvController {

    @FXML private ImageView photoView;
    @FXML private Label fullNameLabel, fatherNameLabel, motherNameLabel, emailLabel, phoneLabel;
    @FXML private Label addressLabel, jscLabel, sscLabel, hscLabel, graduationLabel;
    @FXML private Label skillsLabel, experienceLabel, projectsLabel;

    @FXML
    public void showCV(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("database-show.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) photoView.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void setCvData(Info info) {
        fullNameLabel.setText(info.getFullName());
        fatherNameLabel.setText(info.getFatherName());
        motherNameLabel.setText(info.getMotherName());
        emailLabel.setText(info.getEmail());
        phoneLabel.setText(info.getPhone());
        addressLabel.setText("Area: " + info.getArea() + ", Upazilla: " + info.getUpazilla() +
                ", District: " + info.getDistrict() + ", Division: " + info.getDivision());

        jscLabel.setText("JSC: " + info.getJscSchool() + " | GPA: " + info.getJscGpa());
        sscLabel.setText("SSC: " + info.getSscSchool() + " | GPA: " + info.getSscGpa());
        hscLabel.setText("HSC: " + info.getHscCollege() + " | GPA: " + info.getHscGpa());
        graduationLabel.setText("Graduation: " + info.getGraduationUniversity() + " | CGPA: " + info.getGraduationCgpa());

        skillsLabel.setText(String.join(", ", info.getSkills()));
        experienceLabel.setText(String.join(", ", info.getExperience()));
        projectsLabel.setText(String.join(", ", info.getProjects()));

        if (info.getPhotoPath() != null && !info.getPhotoPath().isEmpty()) {
            File file = new File(info.getPhotoPath());
            if(file.exists()){
                photoView.setImage(new Image(file.toURI().toString()));
            }
        }
    }

    public static void showPreview(Info info) {
        try {
            FXMLLoader loader = new FXMLLoader(CvController.class.getResource("cv-show.fxml"));
            AnchorPane pane = loader.load();
            CvController controller = loader.getController();
            controller.setCvData(info);

            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.setTitle("CV Preview");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
