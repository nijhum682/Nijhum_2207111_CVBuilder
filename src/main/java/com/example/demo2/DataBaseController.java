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

    private void loadTableData() {
        List<Info> list = helper.getAllCVs();
        ObservableList<Info> data = FXCollections.observableArrayList(list);
        cvTable.setItems(data);
    }
}
