package com.example.demo2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataBaseController {

    @FXML private TableView<Info> cvTable;
    @FXML private TableColumn<Info, Number> colId;
    @FXML private TableColumn<Info, String> colFullName;
    @FXML private TableColumn<Info, String> colFatherName;
    @FXML private TableColumn<Info, String> colMotherName;
    @FXML private TableColumn<Info, String> colEmail;
    @FXML private TableColumn<Info, String> colPhone;
    @FXML private TableColumn<Info, Void> colAddress;
    @FXML private TableColumn<Info, Void> colEducation;
    @FXML private TableColumn<Info, Void> colSkills;
    @FXML private TableColumn<Info, Void> colExperience;
    @FXML private TableColumn<Info, Void> colProjects;
    @FXML private TableColumn<Info, String> colPhotoPath;
    @FXML private TableColumn<Info, Void> colDelete;
    @FXML private TableColumn<Info, Void> colPreview;
    @FXML private TableColumn<Info, Void> colUpdate;

    private DatabaseHelper helper;

    @FXML
    public void initialize() {
        helper = new DatabaseHelper();

        colId.setCellValueFactory(c -> new SimpleIntegerProperty(cvTable.getItems().indexOf(c.getValue()) + 1));
        colFullName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFullName()));
        colFatherName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFatherName()));
        colMotherName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getMotherName()));
        colEmail.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
        colPhone.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPhone()));
        colPhotoPath.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPhotoPath()));

        setVerticalAddress();
        setVerticalEducation();
        setVerticalSkills();
        setVerticalExperience();
        setVerticalProjects();

        addDeleteButtonToTable();
        addPreviewButtonToTable();
        addUpdateButtonToTable();

        loadTableData();
    }

    private void setVerticalAddress() {
        colAddress.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); return; }
                Info i = getTableView().getItems().get(getIndex());
                VBox box = new VBox(3,
                        new Label("• " + i.getArea()),
                        new Label("• " + i.getUpazilla()),
                        new Label("• " + i.getDistrict()),
                        new Label("• " + i.getDivision())
                );
                setGraphic(box);
            }
        });
    }

    private void setVerticalEducation() {
        colEducation.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); return; }
                Info i = getTableView().getItems().get(getIndex());
                VBox box = new VBox(3,
                        new Label("• JSC: " + i.getJscSchool() + " | " + i.getJscYear() + " | " + i.getJscBoard() + " | " + i.getJscGpa()),
                        new Label("• SSC: " + i.getSscSchool() + " | " + i.getSscYear() + " | " + i.getSscBoard() + " | " + i.getSscGpa()),
                        new Label("• HSC: " + i.getHscCollege() + " | " + i.getHscYear() + " | " + i.getHscBoard() + " | " + i.getHscGpa()),
                        new Label("• Graduation: " + i.getGraduationUniversity() + " | " + i.getGraduationDepartment() + " | " + i.getGraduationYear() + " | " + i.getGraduationCgpa())
                );
                setGraphic(box);
            }
        });
    }

    private void setVerticalSkills() {
        colSkills.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); return; }
                Info i = getTableView().getItems().get(getIndex());
                VBox box = new VBox(3);
                for (String x : i.getSkills()) box.getChildren().add(new Label("• " + x));
                setGraphic(box);
            }
        });
    }

    private void setVerticalExperience() {
        colExperience.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); return; }
                Info i = getTableView().getItems().get(getIndex());
                VBox box = new VBox(3);
                for (String x : i.getExperience()) box.getChildren().add(new Label("• " + x));
                setGraphic(box);
            }
        });
    }

    private void setVerticalProjects() {
        colProjects.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); return; }
                Info i = getTableView().getItems().get(getIndex());
                VBox box = new VBox(3);
                for (String x : i.getProjects()) box.getChildren().add(new Label("• " + x));
                setGraphic(box);
            }
        });
    }

    private void addDeleteButtonToTable() {
        colDelete.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("Delete");
            { btn.setOnAction(e -> { Info info = getTableView().getItems().get(getIndex()); helper.deleteCV(info.getId()); loadTableData(); }); }
            @Override protected void updateItem(Void item, boolean empty) { super.updateItem(item, empty); setGraphic(empty ? null : btn); }
        });
    }

    private void addPreviewButtonToTable() {
        colPreview.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("Preview");
            { btn.setOnAction(e -> { Info info = getTableView().getItems().get(getIndex()); showPreviewCV(info); }); }
            @Override protected void updateItem(Void item, boolean empty) { super.updateItem(item, empty); setGraphic(empty ? null : btn); }
        });
    }

    private void addUpdateButtonToTable() {
        colUpdate.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("Update");
            {
                btn.setOnAction(e -> {
                    Info info = getTableView().getItems().get(getIndex());
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("update-form.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(loader.load()));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        UpdateFormController controller = loader.getController();
                        controller.setInfo(info, () -> loadTableData()); // fixed here
                        stage.showAndWait();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });
    }
    private void showPreviewCV(Info info) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("CV Preview");

        VBox left = new VBox(3,
                createTitleLabel("Full Name: "), new Label(info.getFullName()),
                createTitleLabel("Father's Name: "), new Label(info.getFatherName()),
                createTitleLabel("Mother's Name: "), new Label(info.getMotherName()),
                createTitleLabel("Email: "), new Label(info.getEmail()),
                createTitleLabel("Phone: "), new Label(info.getPhone()),
                createTitleLabel("Address:"),
                new Label("• " + info.getArea()),
                new Label("• " + info.getUpazilla()),
                new Label("• " + info.getDistrict()),
                new Label("• " + info.getDivision())
        );

        VBox edu = new VBox(3,
                createTitleLabel("Education:"),
                new Label("• JSC: " + info.getJscSchool() + " | " + info.getJscYear() + " | " + info.getJscBoard() + " | " + info.getJscGpa()),
                new Label("• SSC: " + info.getSscSchool() + " | " + info.getSscYear() + " | " + info.getSscBoard() + " | " + info.getSscGpa()),
                new Label("• HSC: " + info.getHscCollege() + " | " + info.getHscYear() + " | " + info.getHscBoard() + " | " + info.getHscGpa()),
                new Label("• Graduation: " + info.getGraduationUniversity() + " | " + info.getGraduationDepartment() + " | " + info.getGraduationYear() + " | " + info.getGraduationCgpa())
        );

        VBox skills = new VBox(3, createTitleLabel("Skills:"));
        for (String x : info.getSkills()) skills.getChildren().add(new Label("• " + x));

        VBox exp = new VBox(3, createTitleLabel("Experience:"));
        for (String x : info.getExperience()) exp.getChildren().add(new Label("• " + x));

        VBox proj = new VBox(3, createTitleLabel("Projects:"));
        for (String x : info.getProjects()) proj.getChildren().add(new Label("• " + x));

        left.getChildren().addAll(edu, skills, exp, proj);

        ImageView image = new ImageView();
        try { File f = new File(info.getPhotoPath()); if (f.exists()) image.setImage(new Image(f.toURI().toString())); } catch (Exception ignored) {}
        image.setFitWidth(150);
        image.setFitHeight(150);
        image.setPreserveRatio(true);

        VBox right = new VBox(image);
        HBox layout = new HBox(40, left, right);
        dialog.getDialogPane().setContent(layout);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.showAndWait();
    }

    private Label createTitleLabel(String text) {
        Label l = new Label(text);
        l.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 14));
        return l;
    }

    private void loadTableData() {
        List<Info> list = helper.getAllCVs();
        cvTable.setItems(FXCollections.observableArrayList(list));
    }
}
