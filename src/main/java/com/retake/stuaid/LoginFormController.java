package com.retake.stuaid;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.BreakIterator;
import java.util.ResourceBundle;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginFormController {
    @FXML
    private BorderPane root;

    @FXML
    private Button txtCreateAcc;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Label wrongPassMgs;

    @FXML
    private Button txtSignIn;

    @FXML
    private void createNewAccnt(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "SignupForm.fxml", "Sign Up");
    }

    @FXML
    private void signInButtonOnAction(ActionEvent e) throws IOException, SQLException {
        DatabaseHandler dbhandaler = new DatabaseHandler();
        String email = txtEmail.getText();
        String password = txtPass.getText();

        if (!email.isBlank() && !password.isBlank()) {
            if (dbhandaler.checklogin(email, password)) {
                SceneChangerUtility.changeScene(root, "HomePage.fxml", "Home Page");
            }
            else {
                wrongPassMgs.setText("Sorry invalid email or password.");
            }
        }
        else {
            wrongPassMgs.setText("Sorry invalid email or password.");
        }
    }
}
