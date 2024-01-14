package com.retake.stuaid;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AddCTController {
    @FXML
    private final String color = "#B80000";
    @FXML
    ObservableList<String> CTAmPmList = FXCollections.observableArrayList("AM", "PM");
    @FXML
    private TextField txtCtMin;
    @FXML
    private DatePicker txtCtDate;
    @FXML
    private TextField txtCtHr;
    @FXML
    private ChoiceBox<String> choiceCTAmPm;
    @FXML
    private AnchorPane rootAddCT;
    @FXML
    private TextField txtClassTest;

    @FXML
    void initialize() {
        choiceCTAmPm.setValue("AM");
        choiceCTAmPm.setItems(CTAmPmList);
    }

    @FXML
    private void addNewCt(ActionEvent event) throws ParseException {
        String CtTitle = txtClassTest.getText();
        String date = String.valueOf(txtCtDate.getValue());
        String hour = txtCtHr.getText();
        String minute = txtCtMin.getText();
        String amOrPm = choiceCTAmPm.getValue();
        boolean flag = true;

        if (CtTitle.isBlank()) {
            Utility.setBorderColor(txtClassTest, color);
            flag = false;
        } else {
            Utility.setBorderColor(txtClassTest, "transparent");
        }

        if (hour.isBlank() || minute.isBlank() || Integer.parseInt(hour) > 12 || Integer.parseInt(hour) < 1 || Integer.parseInt(minute) > 59 || Integer.parseInt(minute) < 0) {
            Utility.setBorderColor(txtCtHr, color);
            Utility.setBorderColor(txtCtMin, color);
            flag = false;
        } else {
            Utility.setBorderColor(txtCtHr, "transparent");
            Utility.setBorderColor(txtCtMin, "transparent");
        }

        if (flag) {
            String timeString = hour + ":" + minute + " " + amOrPm;
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
            Date timeParse = timeFormat.parse(timeString);
            String time = timeFormat.format(timeParse);

            DatabaseHandler dbUser = new DatabaseHandler();
            dbUser.insertTask(CtTitle, LocalDate.parse(date), time, "ct");
            closeStage(event);
        }
    }

    @FXML
    private void closeStage(ActionEvent event) {
        Stage stage = (Stage) rootAddCT.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void cancelCtStage(ActionEvent actionEvent) {
        Stage stage = (Stage) rootAddCT.getScene().getWindow();
        stage.close();
    }
}
