package com.retake.stuaid;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomePageController {

    @FXML
    private VBox root;

    @FXML
    private URL location;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnProfile;

    @FXML
    private void gotoLoginPageByClickingLogout(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
    }

}
