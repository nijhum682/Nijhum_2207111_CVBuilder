package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button createButton;

    @FXML
    private Button createBtn;

    @FXML
    public void onCreateBtnClk() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("form-show.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) createBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
