package com.retake.stuaid;

import com.retake.stuaid.model.StudentModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class AddStudentController {
    @FXML
    private Label lblSerial;
    @FXML
    private Label lblStudentName;
    @FXML
    private CheckBox chkBoxCr;

    public void setProperties(int i, StudentModel student) {
        lblSerial.setText(i + ".");
        lblStudentName.setText(student.getName());
        if (student.getUserType() == 'c') {
            chkBoxCr.fire();
        }
        if (Utility.session.getUserType() != 't') {
            chkBoxCr.setDisable(true);
        }

    }
}
