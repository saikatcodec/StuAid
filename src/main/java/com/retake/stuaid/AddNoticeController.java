package com.retake.stuaid;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

import com.retake.stuaid.database.DatabaseHandler;
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
    private final String color = "#B80000";

    @FXML
    private void addNewNotice(ActionEvent event) throws ParseException {
        String NoticeTitle = txtRefArea.getText();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        boolean flag = true;

        if (NoticeTitle.isBlank()) {
            Utility.setBorderColorArea(txtRefArea, color);
            flag = false;
        } else {
            Utility.setBorderColorArea(txtRefArea, "transparent");
        }

        if (flag) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
            Date timeParse = timeFormat.parse(String.valueOf(time));
            String time1 = timeFormat.format(timeParse);

            DatabaseHandler dbUser = new DatabaseHandler();
            dbUser.insertTask(NoticeTitle, date, time1, "notice");
            closeStage(event);
        }
    }

    @FXML
    private void closeStage(ActionEvent event) {
        Stage stage = (Stage) rootAddNotice.getScene().getWindow();
        stage.close();
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
