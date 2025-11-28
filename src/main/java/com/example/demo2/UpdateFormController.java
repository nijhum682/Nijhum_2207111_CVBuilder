package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateFormController {

    @FXML private TextField txtFullName, txtFatherName, txtMotherName, txtEmail, txtPhone, txtPhotoPath;
    @FXML private TextField txtArea, txtUpazilla, txtDistrict, txtDivision;
    @FXML private TextField txtJscSchool, txtJscYear, txtJscBoard, txtJscGpa;
    @FXML private TextField txtSscSchool, txtSscYear, txtSscBoard, txtSscGpa;
    @FXML private TextField txtHscCollege, txtHscYear, txtHscBoard, txtHscGpa;
    @FXML private TextField txtGraduationUniversity, txtGraduationDepartment, txtGraduationYear, txtGraduationCgpa;
    @FXML private TextField txtSkills, txtExperience, txtProjects;
    @FXML private javafx.scene.control.Button btnSubmit;

    private Info originalInfo;
    private DatabaseHelper db = new DatabaseHelper();
    private Runnable onUpdateCallback;

    public void setInfo(Info info, Runnable callback) {
        this.originalInfo = info;
        this.onUpdateCallback = callback;

        txtFullName.setText(info.getFullName());
        txtFatherName.setText(info.getFatherName());
        txtMotherName.setText(info.getMotherName());
        txtEmail.setText(info.getEmail());
        txtPhone.setText(info.getPhone());
        txtPhotoPath.setText(info.getPhotoPath());
        txtArea.setText(info.getArea());
        txtUpazilla.setText(info.getUpazilla());
        txtDistrict.setText(info.getDistrict());
        txtDivision.setText(info.getDivision());

        txtJscSchool.setText(info.getJscSchool());
        txtJscYear.setText(info.getJscYear());
        txtJscBoard.setText(info.getJscBoard());
        txtJscGpa.setText(info.getJscGpa());

        txtSscSchool.setText(info.getSscSchool());
        txtSscYear.setText(info.getSscYear());
        txtSscBoard.setText(info.getSscBoard());
        txtSscGpa.setText(info.getSscGpa());

        txtHscCollege.setText(info.getHscCollege());
        txtHscYear.setText(info.getHscYear());
        txtHscBoard.setText(info.getHscBoard());
        txtHscGpa.setText(info.getHscGpa());

        txtGraduationUniversity.setText(info.getGraduationUniversity());
        txtGraduationDepartment.setText(info.getGraduationDepartment());
        txtGraduationYear.setText(info.getGraduationYear());
        txtGraduationCgpa.setText(info.getGraduationCgpa());

        txtSkills.setText(String.join(",", info.getSkills()));
        txtExperience.setText(String.join(",", info.getExperience()));
        txtProjects.setText(String.join(",", info.getProjects()));
    }

    @FXML
    private void initialize() {
        btnSubmit.setOnAction(e -> {
            Info updatedInfo = new Info(
                    originalInfo.getId(),
                    txtFullName.getText(),
                    txtFatherName.getText(),
                    txtMotherName.getText(),
                    txtEmail.getText(),
                    txtPhone.getText(),
                    txtPhotoPath.getText(),
                    txtArea.getText(),
                    txtUpazilla.getText(),
                    txtDistrict.getText(),
                    txtDivision.getText(),
                    txtJscSchool.getText(),
                    txtJscYear.getText(),
                    txtJscBoard.getText(),
                    txtJscGpa.getText(),
                    txtSscSchool.getText(),
                    txtSscYear.getText(),
                    txtSscBoard.getText(),
                    txtSscGpa.getText(),
                    txtHscCollege.getText(),
                    txtHscYear.getText(),
                    txtHscBoard.getText(),
                    txtHscGpa.getText(),
                    txtGraduationUniversity.getText(),
                    txtGraduationDepartment.getText(),
                    txtGraduationYear.getText(),
                    txtGraduationCgpa.getText(),
                    splitToList(txtSkills.getText()),
                    splitToList(txtExperience.getText()),
                    splitToList(txtProjects.getText())
            );

            db.updateCV(updatedInfo);
            if(onUpdateCallback != null) onUpdateCallback.run();
            ((Stage) txtFullName.getScene().getWindow()).close();
        });
    }

    private List<String> splitToList(String text) {
        if (text == null || text.isBlank()) return List.of();
        return Arrays.stream(text.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
