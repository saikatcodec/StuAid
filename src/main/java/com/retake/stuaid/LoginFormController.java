package com.retake.stuaid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginFormController {
    @FXML
    private BorderPane root;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button txtCreateAcc;

    @FXML
    private AnchorPane txtEmail;

    @FXML
    private PasswordField txtPass;

    public void createNewAccnt(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "SignupForm.fxml", "Sign Up");
    }

    public void gotoHomePage(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "HomePage.fxml", "Home Page");
    }
}
