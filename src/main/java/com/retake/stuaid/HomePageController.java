package com.retake.stuaid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

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
    private VBox vTaskItems;

    @FXML
    private VBox vUpcmngTaskItems;

    public void initialize() {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("ClassItem.fxml"));
                vTaskItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Node[] upcommingNodes = new Node[10];
        for (int i = 0; i < upcommingNodes.length; i++) {
            try {
                upcommingNodes[i] = FXMLLoader.load(getClass().getResource("ClassItem.fxml"));
                vUpcmngTaskItems.getChildren().add(upcommingNodes[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    private void gotoLoginPageByClickingLogout(ActionEvent actionEvent) throws IOException {
        SceneChangerUtility.changeScene(root, "LoginForm.fxml", "Log In");
    }


}
