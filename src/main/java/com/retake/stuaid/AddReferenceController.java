package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddReferenceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRefCancel;

    @FXML
    private Button btnRefSubmit;

    @FXML
    private AnchorPane rootAddAssignment;

    @FXML
    private TextArea txtRefArea;

    @FXML
    void addNewRef(MouseEvent event) {

    }

    @FXML
    void cancelRefStage(ActionEvent event) {
        Stage stage = (Stage) rootAddAssignment.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}
