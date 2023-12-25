package com.retake.stuaid;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddReferenceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRefCancel;

    @FXML
    private Button btnRefSubmit;

    @FXML
    private AnchorPane rootAddRef;

    @FXML
    private TextArea txtRefArea;

    @FXML
    private final String color = "#B80000";

    @FXML
    private void addNewRef(ActionEvent event) throws ParseException {
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

    @FXML
    void initialize() {

    }

}
