package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import com.retake.stuaid.security.PasswordHash;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class SignupController {
    @FXML
    private BorderPane root;
    @FXML
    private CheckBox chkboxTeacher;
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

    /**
     * Handler of LogIn Button
     *
     * @param actionEvent event of LogIn button
     * @throws IOException throw exception
     */
    @FXML
    private void gotoLoginPagebyClickingLogIn(ActionEvent actionEvent) throws IOException {
        Utility.changeScene(root, "LoginForm.fxml", "Log In");
    }

    /**
     * Handler of SignUp Button
     *
     * @param actionEvent event of SigUp Button
     * @throws IOException exception
     */
    @FXML
    private void gotoLoginPagebyClickingSignUp(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        // TODO check email before creating account
        String password = txtPass.getText();
        String confirmPassword = txtConfirmPass.getText();
        String name = txtName.getText();
        String emailText = txtEmail.getText();
        boolean teacherOrNot = chkboxTeacher.isSelected();
        boolean flag = true;
        DatabaseHandler dbUser = new DatabaseHandler();

        if (name.isBlank()) {
            setBorderColor(txtName, "red");
            flag = false;
        } else {
            setBorderColor(txtName, "transparent");
        }

        if (emailText.isBlank() || !(isValidEmail(emailText)) || dbUser.getUser(emailText).next()) {
            setBorderColor(txtEmail, "red");
            flag = false;
        } else {
            setBorderColor(txtEmail, "transparent");
        }

        if (checkConfirmPassword(password, confirmPassword) && flag) {
            String hashPassword = PasswordHash.hashPassword(password);
            dbUser.signupUser(emailText, name, hashPassword, ((teacherOrNot) ? 't' : 's'));
            Utility.changeScene(root, "LoginForm.fxml", "Log In");
        }
    }

    /**
     * Checking two password are equal or not
     *
     * @param password        password from passwordField
     * @param confirmPassword password from passwordField for confirmation
     * @return Are two password same?
     */
    private boolean checkConfirmPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword) && !password.isBlank()) {
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

    /**
     * Set border of Node
     *
     * @param node  Node of textField
     * @param color border color
     */
    private void setBorderColor(TextField node, String color) {
        node.setStyle("-fx-border-color: " + color);
    }

    /**
     * Method For Email Validation
     *
     * @param emailText text of email field
     * @return matches with email pattern or not
     */
    private boolean isValidEmail(String emailText) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern ptn = Pattern.compile(emailRegex);
        if (emailText == null) {
            return false;
        }
        return ptn.matcher(emailText).matches();
    }

}
