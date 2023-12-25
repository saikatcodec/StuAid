package com.retake.stuaid;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import com.retake.stuaid.database.DatabaseHandler;
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
    private final String color = "#B80000";
    
    @FXML
    void cancelAssignmentStage(ActionEvent event) {
        Stage stage = (Stage) rootAssignment.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void addNewAssignment(ActionEvent event) throws ParseException {
        String AssignmentTitle = txtAssignment.getText();
        String date = String.valueOf(txtAssignmentDate.getValue());
//        LocalDate date = LocalDate.now();
        String hour = txtAssignmentHr.getText();
        String minute = txtAssignmentMin.getText();
        String amOrPm = (String) choiceAssignmentAmPm.getValue();
        boolean flag = true;

        if (AssignmentTitle.isBlank()) {
            Utility.setBorderColor(txtAssignment, color);
            flag = false;
        } else {
            Utility.setBorderColor(txtAssignment, "transparent");
        }

        if(date.isBlank()) {
            Utility.setBorderColor(txtAssignmentDate.getEditor(), color);
            flag = false;
        }
        else {
            Utility.setBorderColor(txtAssignmentDate.getEditor(), "transparent");
        }

        if (hour.isBlank() || minute.isBlank()) {
            Utility.setBorderColor(txtAssignmentHr, color);
            Utility.setBorderColor(txtAssignmentMin, color);
            flag = false;
        } else {
            Utility.setBorderColor(txtAssignmentHr, "transparent");
            Utility.setBorderColor(txtAssignmentMin, "transparent");
        }

        if (flag) {
            String timeString = hour + ":" + minute + " " + amOrPm;
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
            Date timeParse = timeFormat.parse(timeString);
            String time = timeFormat.format(timeParse);

            DatabaseHandler dbUser = new DatabaseHandler();
            dbUser.insertTask(AssignmentTitle, LocalDate.parse(date), time, "assignment");
            closeStage(event);
        }
    }

    @FXML
    private void closeStage(ActionEvent actionEvent) {
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
