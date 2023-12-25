package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import com.retake.stuaid.model.StudentModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class AddStudentController {
    @FXML
    private Label lblSerial;
    @FXML
    private Label lblStudentName;
    @FXML
    private CheckBox chkBoxCr;
    private StudentModel studentModel;

    public void initialize() {
        chkBoxCr.setOnAction(event -> {
            DatabaseHandler dbUser = new DatabaseHandler();
            try {
                dbUser.changeCr(studentModel.getEmail(), studentModel.getUserType());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setProperties(int i, StudentModel student) {
        studentModel = student;
        lblSerial.setText(i + ".");
        lblStudentName.setText(student.getName());
        if (student.getUserType() == 'c') {
            chkBoxCr.setSelected(true);
        }
        if (Utility.session.getUserType() != 't') {
            chkBoxCr.setDisable(true);
        }

    }
}
