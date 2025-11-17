package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class CvController {
    @FXML private ImageView photoView;
    @FXML private Label fullNameLabel;
    @FXML private Label fatherNameLabel;
    @FXML private Label motherNameLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    @FXML private Label addressLabel;
    @FXML private Label jscLabel;
    @FXML private Label sscLabel;
    @FXML private Label hscLabel;
    @FXML private Label skillsLabel;
    @FXML private Label experienceLabel;
    @FXML private Label projectsLabel;

    public void setCVData(
            String fullName, String fatherName, String motherName,
            String email, String phone, String area, String upazilla, String district, String division,
            String jscSchool, String jscYear, String jscBoard, String jscGPA,
            String sscSchool, String sscYear, String sscBoard, String sscGPA,
            String hscCollege, String hscYear, String hscBoard, String hscGPA,
            String skills, String experience, String projects, Image photo) {

        fullNameLabel.setText(fullName);
        fatherNameLabel.setText(fatherName);
        motherNameLabel.setText(motherName);
        emailLabel.setText(email);
        phoneLabel.setText(phone);
        addressLabel.setText(area + ", " + upazilla + ", " + district + ", " + division);

        jscLabel.setText("JSC: " + jscSchool + ", " + jscBoard + " Board, " + jscYear + " - GPA: " + jscGPA);
        sscLabel.setText("SSC: " + sscSchool + ", " + sscBoard + " Board, " + sscYear + " - GPA: " + sscGPA);
        hscLabel.setText("HSC: " + hscCollege + ", " + hscBoard + " Board, " + hscYear + " - GPA: " + hscGPA);

        skillsLabel.setText(skills);
        experienceLabel.setText(experience);
        projectsLabel.setText(projects);
        if (photo != null) {
            photoView.setImage(photo);
        }
    }
}
