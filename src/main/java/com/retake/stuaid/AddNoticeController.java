package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddNoticeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNoticeCancel;

    @FXML
    private Button btnNoticeSubmit;

    @FXML
    private AnchorPane rootAddNotice;

    @FXML
    private TextArea txtRefArea;

    @FXML
    void addNewNotice(ActionEvent event) {

    }

    @FXML
    void addNewRef(MouseEvent event) {

    }

    @FXML
    void cancelNoticeStage(ActionEvent event) {
        Stage stage = (Stage) rootAddNotice.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}
