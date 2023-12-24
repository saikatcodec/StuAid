package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;

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

public class AddAssignmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAssignmentCancel;

    @FXML
    private Button btnAssignmentSubmit;

    @FXML
    private ChoiceBox<String> choiceAssignmentAmPm;

    @FXML
    private AnchorPane rootAssignment;

    @FXML
    private TextField txtAssignment;

    @FXML
    private DatePicker txtAssignmentDate;

    @FXML
    private TextField txtAssignmentHr;

    @FXML
    private TextField txtAssignmentMin;

    @FXML
    void addNewAssignment(ActionEvent event) {

    }

    @FXML
    void cancelAssignmentStage(ActionEvent event) {
        Stage stage = (Stage) rootAssignment.getScene().getWindow();
        stage.close();
    }

    @FXML
    ObservableList<String> AssignAmPm = FXCollections.observableArrayList("AM", "PM");

    @FXML
    void initialize() {
        choiceAssignmentAmPm.setValue("AM");
        choiceAssignmentAmPm.setItems(AssignAmPm);
    }

}
