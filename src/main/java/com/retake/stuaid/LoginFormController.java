package com.retake.stuaid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

//    @FXML
//    void initialize() {
//        txtCreateAcc.setOnAction(event -> {
//            txtCreateAcc.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("../SignupForm.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setTitle("Sign Up");
//            stage.setScene(new Scene(root));
//            stage.setResizable(false);
//            stage.showAndWait();
//        });
//    }

    public void createNewAccnt(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignupForm.fxml"));
        Scene scene = new Scene(loader.load());
        Stage crntStage = (Stage) root.getScene().getWindow();
        crntStage.setScene(scene);
        crntStage.setTitle("Sign Up");
        crntStage.centerOnScreen();
    }
}
