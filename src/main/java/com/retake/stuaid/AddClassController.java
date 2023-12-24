package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AddClassController {
    @FXML
    private AnchorPane root;

    @FXML
    private ChoiceBox<String> choiceAmPm;

    @FXML
    private ChoiceBox<String> choiceTdayTmrow;

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
    private final String color = "#B80000";

    @FXML
    ObservableList<String> AmPmlist = FXCollections.observableArrayList("AM", "PM");

    @FXML
    ObservableList<String> dayList = FXCollections.observableArrayList("Today", "Tomorrow");

    /**
     * Before load the scene, init function is closed
     */
    @FXML
    public void initialize() {
        choiceAmPm.setValue("AM");
        choiceAmPm.setItems(AmPmlist);
        choiceTdayTmrow.setValue("Today");
        choiceTdayTmrow.setItems(dayList);
    }

    /**
     * Handler of submit button
     *
     * @param event event of button
     * @throws ParseException throws an exception
     */
    @FXML
    private void addNewCourse(ActionEvent event) throws ParseException {
        String classTitle = txtCourseTitle.getText();
        String dateOf = choiceTdayTmrow.getValue();
        LocalDate date = LocalDate.now();
        String hour = txtTimeHr.getText();
        String minute = txtTimeMin.getText();
        String amOrPm = choiceAmPm.getValue();
        boolean flag = true;

        if (classTitle.isBlank()) {
            setBorderColor(txtCourseTitle, color);
            flag = false;
        } else {
            setBorderColor(txtCourseTitle, "transparent");
        }

        if (hour.isBlank() || minute.isBlank()) {
            setBorderColor(txtTimeHr, color);
            setBorderColor(txtTimeMin, color);
            flag = false;
        } else {
            setBorderColor(txtTimeHr, "transparent");
            setBorderColor(txtTimeMin, "transparent");
        }

        if (flag) {
            if (dateOf.equals("Tomorrow")) {
                date = date.plusDays(1);
            }

            String timeString = hour + ":" + minute + " " + amOrPm;
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
            Date timeParse = timeFormat.parse(timeString);
            String time = timeFormat.format(timeParse);

            DatabaseHandler dbUser = new DatabaseHandler();
            dbUser.insertTask(classTitle, date, time, "class");
            closeStage(event);
        }
    }

    /**
     * Handler of cancel button
     *
     * @param actionEvent event of button
     */
    public void closeStage(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    /**
     * Set border of Node
     *
     * @param node  Node of textField
     * @param color border color
     */
    private void setBorderColor(TextField node, String color) {
        node.setStyle("-fx-border-color: " + color);
    }
}
