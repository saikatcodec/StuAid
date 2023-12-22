package com.retake.stuaid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SignupController {

    public Button txtSignUp;
    @FXML
    private BorderPane root;

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

    @FXML
    private Label lblPassMsg;

    @FXML
    private void gotoLoginPagebyClickingLogIn(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
    }

    @FXML
    private void gotoLoginPagebyClickingSignUp(ActionEvent actionEvent) throws IOException {
        String password = txtPass.getText();
        String confirmPassword = txtConfirmPass.getText();

        if (checkConfirmPassword(password, confirmPassword)) {
            SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
        }
    }

    private boolean checkConfirmPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            setBorderColor(txtPass, "transparent");
            setBorderColor(txtConfirmPass, "transparent");
            lblPassMsg.setStyle("visibility: false");
            return true;
        } else {
            setBorderColor(txtPass, "red");
            setBorderColor(txtConfirmPass, "red");
            lblPassMsg.setStyle("visibility: true");
            return false;
        }
    }

    private void setBorderColor(TextField node, String color) {
        node.setStyle("-fx-border-color: " + color);
    }
}
