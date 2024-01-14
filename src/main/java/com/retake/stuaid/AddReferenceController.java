package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddReferenceController {
    @FXML
    private final String color = "#B80000";
    @FXML
    private AnchorPane rootAddRef;
    @FXML
    private TextArea txtRefArea;

    @FXML
    private void addNewRef(ActionEvent event) {
        String ReferenceTitle = txtRefArea.getText();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        boolean flag = true;

        if (ReferenceTitle.isBlank() || ReferenceTitle.length() > 80) {
            Utility.setBorderColorArea(txtRefArea, color);
            flag = false;
        } else {
            Utility.setBorderColorArea(txtRefArea, "transparent");
        }

        if (flag) {
            DatabaseHandler dbUser = new DatabaseHandler();
            dbUser.insertTask(ReferenceTitle, date, String.valueOf(time), "reference");
            closeStage(event);
        }
    }

    @FXML
    private void closeStage(ActionEvent event) {
        Stage stage = (Stage) rootAddRef.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelRefStage(ActionEvent event) {
        Stage stage = (Stage) rootAddRef.getScene().getWindow();
        stage.close();
    }
}
