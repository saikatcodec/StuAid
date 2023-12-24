package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddClass {

    @FXML
    private AnchorPane root;

    @FXML
    private ChoiceBox<String> choiceAmPm;

    @FXML
    private ChoiceBox<String> choiceTdayTmrow;

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
    ObservableList<String> dayList = FXCollections.observableArrayList("Today", "Tomorrow");

    @FXML
    public void initialize() {
        choiceAmPm.setValue("AM");
        choiceAmPm.setItems(AmPmlist);
        choiceTdayTmrow.setValue("Today");
        choiceTdayTmrow.setItems(dayList);
    }

    @FXML
    private void addNewCourse(ActionEvent event) {

    }

    public void closeStage(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

}
