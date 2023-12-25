package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import com.retake.stuaid.session.LoginSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {
    @FXML
    private BorderPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Label wrongPassMgs;

    @FXML
    private void createNewAccnt(ActionEvent actionEvent) throws IOException {
        Utility.changeScene(root, "SignupForm.fxml", "Sign Up");
    }

    @FXML
    private void signInButtonOnAction(ActionEvent e) throws IOException, SQLException {
        String email = txtEmail.getText();
        String password = txtPass.getText();

        if (!email.isBlank() && !password.isBlank()) {
            if (checkLogin(email, password)) {
                Utility.changeScene(root, "HomePage.fxml", "Home Page");
            } else {
                wrongPassMgs.setText("Sorry invalid email or password.");
            }
        } else {
            wrongPassMgs.setText("Sorry invalid email or password.");
        }
    }

    private boolean checkLogin(String email, String password) throws SQLException {
        DatabaseHandler dbUser = new DatabaseHandler();
        ResultSet userRow = dbUser.getUser(email, password);

        while (userRow.next()) {
            String emailSql = userRow.getString("email");
            String name = userRow.getString("name");
            char userType = userRow.getString("usertype").charAt(0);
            Utility.session = LoginSession.getLoginSession(emailSql, name, userType);
            return true;
        }

        return false;
    }

}
