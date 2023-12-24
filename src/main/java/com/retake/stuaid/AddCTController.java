package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddCTController {

    public Button btnCtSubmit;
    public Button btnCtCancel;
    public ChoiceBox choiceCtAmPm;
    public TextField txtCtMin;
    public DatePicker txtCtDate;
    public TextField txtCtHr;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCTCancel;

    @FXML
    private Button btnCTSubmit;

    @FXML
    private ChoiceBox<String> choiceCTAmPm;

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
    ObservableList<String> CTAmPmList = FXCollections.observableArrayList("AM", "PM");

    @FXML
    void initialize() {
        choiceCTAmPm.setValue("AM");
        choiceCTAmPm.setItems(CTAmPmList);
    }

    public void addNewCt(ActionEvent actionEvent) {
    }

    @FXML
    private void cancelCtStage(ActionEvent actionEvent) {
        Stage stage = (Stage) rootAddCT.getScene().getWindow();
        stage.close();
    }
}
