package com.retake.stuaid;

import com.retake.stuaid.model.TodoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClassItemController {
    @FXML
    private Label lblSerial;
    @FXML
    private Label lblCourseTitle;
    @FXML
    private Label lblTimeDate;
    @FXML
    private Button btnClassCancel;

    public void setTask(int i, TodoModel todo) {
        lblSerial.setText(i + ".");
        lblCourseTitle.setText(todo.className);
        lblTimeDate.setText(todo.date + " | " + todo.time);
    }

    @FXML
    private void classCancel(ActionEvent actionEvent) {
        System.out.println("Cancel");
    }

}
