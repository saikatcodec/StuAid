package com.retake.stuaid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddAssignmentController {
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
        String hour = txtAssignmentHr.getText();
        String minute = txtAssignmentMin.getText();
        String amOrPm = choiceAssignmentAmPm.getValue();
        boolean flag = true;

        if (AssignmentTitle.isBlank()) {
            Utility.setBorderColor(txtAssignment, color);
            flag = false;
        } else {
            Utility.setBorderColor(txtAssignment, "transparent");
        }

        if(date.isBlank()) {
            Utility.setBorderColorDatepicker(txtAssignmentDate, color);
            flag = false;
        }
        else {
            Utility.setBorderColorDatepicker(txtAssignmentDate, "transparent");
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
