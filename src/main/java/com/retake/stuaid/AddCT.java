package com.retake.stuaid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddCT {

    public Button btnCtSubmit;
    public Button btnCtCancel;
    public ChoiceBox choiceCtAmPm;
    public TextField txtCtMin;
    public DatePicker txtCtDate;
    public TextField txtCtHr;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCTCancel;

    @FXML
    private Button btnCTSubmit;

    @FXML
    private ChoiceBox<?> choiceCTAmPm;

    @FXML
    private DatePicker dateCT;

    @FXML
    private AnchorPane rootAddCT;

    @FXML
    private TextField txtCTHr;

    @FXML
    private TextField txtCTMin;

    @FXML
    private TextField txtClassTest;

    @FXML
    void addNewCourse(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

    public void addNewCt(ActionEvent actionEvent) {
    }

    public void cancelCtStage(ActionEvent actionEvent) {
    }
}
