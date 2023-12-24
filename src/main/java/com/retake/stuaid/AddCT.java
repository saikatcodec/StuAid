package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddCT {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCTCancel;

    @FXML
    private Button btnCTSubmit;

    @FXML
    private ChoiceBox<?> choiceCTAmPm;

    @FXML
    private DatePicker dateCT;

    @FXML
    private AnchorPane rootAddCT;

    @FXML
    private TextField txtCTHr;

    @FXML
    private TextField txtCTMin;

    @FXML
    private TextField txtClassTest;

    @FXML
    void addNewCourse(ActionEvent event) {

    }

    @FXML
    private void closeStageCT(ActionEvent event) {
        Stage stage1 = (Stage) rootAddCT.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {

    }

}
