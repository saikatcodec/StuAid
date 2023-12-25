package com.retake.stuaid;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddNoticeController {
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

        if (NoticeTitle.isBlank() || NoticeTitle.length() > 80) {
            Utility.setBorderColorArea(txtRefArea, color);
            flag = false;
        } else {
            Utility.setBorderColorArea(txtRefArea, "transparent");
        }

        if (flag) {
            DatabaseHandler dbUser = new DatabaseHandler();
            dbUser.insertTask(NoticeTitle, date, String.valueOf(time), "notice");
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
}
