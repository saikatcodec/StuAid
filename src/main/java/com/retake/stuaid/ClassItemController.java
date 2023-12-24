package com.retake.stuaid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClassItemController {
    @FXML
    private Button btnClassCancel;

    @FXML
    private void classCancel(ActionEvent actionEvent) {
        System.out.println("Cancel");
    }

}
