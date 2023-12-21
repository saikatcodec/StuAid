package com.retake.stuaid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SignupController {

    public Button txtSignUp;
    @FXML
    private BorderPane root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox chkboxTeacher;

    @FXML
    private Button txtSignIn;

    @FXML
    private PasswordField txtConfirmPass;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPass;

//    @FXML
//    void initialize() {
//
//    }
    public void gotoLoginPagebyClickingLogIn(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
    }

    public void gotoLoginPagebyClickingSignUp(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
    }
}
