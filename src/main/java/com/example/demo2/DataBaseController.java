package com.example.demo2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

public class DataBaseController {
    @FXML
    private TableView<Info> cvTable;

    @FXML
    private TableColumn<Info, Number> colId;
    @FXML
    private TableColumn<Info, String> colFullName;
    @FXML
    private TableColumn<Info, String> colFatherName;
    @FXML
    private TableColumn<Info, String> colMotherName;
    @FXML
    private TableColumn<Info, String> colEmail;
    @FXML
    private TableColumn<Info, String> colPhone;
    @FXML
    private TableColumn<Info, String> colPhotoPath;
    @FXML
    private TableColumn<Info, String> colAddress;
    @FXML
    private TableColumn<Info, String> colEducation;
    @FXML
    private TableColumn<Info, String> colSkills;
    @FXML
    private TableColumn<Info, String> colExperience;
    @FXML
    private TableColumn<Info, String> colProjects;
    @FXML
    private TableColumn<Info, Void> colDelete;
    @FXML
    private TableColumn<Info, Void> colPreview;

    private DatabaseHelper helper;

    @FXML
    public void initialize() {
        helper = new DatabaseHelper();
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        colFullName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFullName()));
        colFatherName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFatherName()));
        colMotherName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotherName()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        colPhone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
        colPhotoPath.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhotoPath()));
        colAddress.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getArea() + ", " +
                        cellData.getValue().getUpazilla() + ", " +
                        cellData.getValue().getDistrict() + ", " +
                        cellData.getValue().getDivision()
        ));
        colEducation.setCellValueFactory(cellData -> new SimpleStringProperty(
                "JSC: " + cellData.getValue().getJscSchool() + " (" + cellData.getValue().getJscYear() + "), " +
                        "SSC: " + cellData.getValue().getSscSchool() + " (" + cellData.getValue().getSscYear() + "), " +
                        "HSC: " + cellData.getValue().getHscCollege() + " (" + cellData.getValue().getHscYear() + "), " +
                        "Graduation: " + cellData.getValue().getGraduationUniversity() + " (" +
                        cellData.getValue().getGraduationYear() + ")"
        ));
        colSkills.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getSkills())));
        colExperience.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getExperience())));
        colProjects.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getProjects())));

        addDeleteButtonToTable();
        addPreviewButtonToTable();
        loadTableData();
    }

    private void addDeleteButtonToTable() {
        colDelete.setCellFactory(param -> new TableCell<>() {
            private final Button deleteBtn = new Button("Delete");

            {
                deleteBtn.setOnAction(event -> {
                    Info info = getTableView().getItems().get(getIndex());
                    helper.deleteCV(info.getId());
                    loadTableData();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteBtn);
                }
            }
        });
    }

    private void addPreviewButtonToTable() {
        colPreview.setCellFactory(param -> new TableCell<>() {
            private final Button previewBtn = new Button("Preview");

            {
                previewBtn.setOnAction(event -> {
                    Info info = getTableView().getItems().get(getIndex());
                    showPreviewCV(info);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(previewBtn);
                }
            }
        });
    }

    private void showPreviewCV(Info info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CV Preview");

        StringBuilder content = new StringBuilder();
        content.append("Full Name: ").append(info.getFullName()).append("\n");
        content.append("Father Name: ").append(info.getFatherName()).append("\n");
        content.append("Mother Name: ").append(info.getMotherName()).append("\n");
        content.append("Email: ").append(info.getEmail()).append("\n");
        content.append("Phone: ").append(info.getPhone()).append("\n");
        content.append("Address: ").append(info.getArea()).append(", ")
                .append(info.getUpazilla()).append(", ")
                .append(info.getDistrict()).append(", ")
                .append(info.getDivision()).append("\n");
        content.append("Education: JSC: ").append(info.getJscSchool()).append(" (").append(info.getJscYear()).append("), ")
                .append("SSC: ").append(info.getSscSchool()).append(" (").append(info.getSscYear()).append("), ")
                .append("HSC: ").append(info.getHscCollege()).append(" (").append(info.getHscYear()).append("), ")
                .append("Graduation: ").append(info.getGraduationUniversity()).append(" (").append(info.getGraduationYear()).append(")\n");
        content.append("Skills: ").append(String.join(", ", info.getSkills())).append("\n");
        content.append("Experience: ").append(String.join(", ", info.getExperience())).append("\n");
        content.append("Projects: ").append(String.join(", ", info.getProjects()));

        alert.setContentText(content.toString());
        alert.showAndWait();
    }

    private void loadTableData() {
        List<Info> list = helper.getAllCVs();
        ObservableList<Info> data = FXCollections.observableArrayList(list);
        cvTable.setItems(data);
    }
}
