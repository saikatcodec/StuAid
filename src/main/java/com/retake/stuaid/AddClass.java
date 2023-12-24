package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddClass {

    @FXML
    private ChoiceBox<String> choiceAmPm;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField txtCourseTitle;

    @FXML
    private DatePicker txtDateString;

    @FXML
    private TextField txtTimeHr;

    @FXML
    private TextField txtTimeMin;

    @FXML
    ObservableList<String> AmPmlist = FXCollections.observableArrayList("AM", "PM");

    @FXML
    public void initialize() {
        choiceAmPm.setValue("AM");
        choiceAmPm.setItems(AmPmlist);
    }

    @FXML
    private void addNewCourse(ActionEvent event) {

    }

    @FXML
    void gotoHomePageByClickingCancel(ActionEvent event) {

    }

}
