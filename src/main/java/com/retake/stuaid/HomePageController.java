package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HomePageController {

    @FXML
    private Button btnToday;

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

    @FXML
    private VBox vCT;

    public void initialize() throws SQLException {
//        LocalDate today = LocalDate.now();
//        DatabaseHandler dbUser = new DatabaseHandler();
//        ResultSet result = dbUser.getTodayTasksClass(today);
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

        Node[] upcommingCT = new Node[10];
        for (int i = 0; i < upcommingCT.length; i++) {
            try {
                upcommingCT[i] = FXMLLoader.load(getClass().getResource("ClassItem.fxml"));
                vCT.getChildren().add(upcommingCT[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    private void gotoLoginPageByClickingLogout(ActionEvent actionEvent) throws IOException {
        Utility.changeScene(root, "LoginForm.fxml", "Log In");
    }

    @FXML
    private void todayPopUp(ActionEvent actionEvent) throws IOException {
        Utility.popUp("AddClass.fxml", "Add Class");
    }

    @FXML
    private void addCTPopUp(ActionEvent actionEvent) throws IOException {
        Utility.popUp("AddCT.fxml", "Add Class Test");
    }

    @FXML
    private void addAssignmentPupUp(ActionEvent actionEvent) throws IOException {
        Utility.popUp("AddAssignment.fxml", "Add Assignment");
    }

    @FXML
    private void addReferencePopUp(ActionEvent actionEvent) throws IOException {
        Utility.popUp("AddReference.fxml", "Add Reference");
    }

    @FXML
    private void addNoticePopUp(ActionEvent actionEvent) throws IOException {
        Utility.popUp("AddNotice.fxml", "Add Notice");
    }

}
