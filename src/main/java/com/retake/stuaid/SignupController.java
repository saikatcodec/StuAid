package com.retake.stuaid;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.regex.Pattern;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class SignupController {

    public Button txtSignUp;
    public Button txtLogIn;
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

    /**
     * Handler of LogIn Button
     * @param actionEvent event of LogIn button
     * @throws IOException throw exception
     */
    @FXML
    private void gotoLoginPagebyClickingLogIn(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
    }

    /**
     * Handler of SignUp Button
     * @param actionEvent event of SigUp Button
     * @throws IOException exception
     */
    @FXML
    private void gotoLoginPagebyClickingSignUp(ActionEvent actionEvent) throws IOException {
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

        if (emailText.isBlank() || !(isValidEmail(emailText))) {
            setBorderColor(txtEmail, "red");
            flag = false;
        } else {
            setBorderColor(txtEmail, "transparent");
        }

        if (checkConfirmPassword(password, confirmPassword) && flag) {
            dbUser.signupUser(emailText, name, password, ((teacherOrNot) ? 't': 's'));
            SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
        }
    }

    /**
     * Checking two password are equal or not
     * @param password password from passwordField
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
     * @param node Node of textField
     * @param color border color
     */
    private void setBorderColor(TextField node, String color) {
        node.setStyle("-fx-border-color: " + color);
    }

    /**
     * Method For Email Validation
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
