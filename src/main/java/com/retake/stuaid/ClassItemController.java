package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import com.retake.stuaid.model.TodoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

public class ClassItemController {
    private int i;
    private TodoModel todoModel;
    @FXML
    private Label lblSerial;
    @FXML
    private Label lblCourseTitle;
    @FXML
    private Label lblTimeDate;
    @FXML
    private Button btnClassCancel;

    public void initialize() {
        if (Utility.session.getUserType() == 's') {
            btnClassCancel.setVisible(false);
        }

        btnClassCancel.setOnAction(event -> {
            DatabaseHandler dbUser = new DatabaseHandler();
            try {
                dbUser.deletTask(todoModel.getTaskId());
                btnClassCancel.getParent().setVisible(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setTask(int i, TodoModel todo) {
        this.i = i;
        lblSerial.setText(i + ".");
        lblCourseTitle.setText(todo.className);
        lblTimeDate.setText(todo.date + " | " + todo.time);
        todoModel = todo;
    }
}
