package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class HomePageController {
    @FXML
    private Button btnAddCT;
    @FXML
    private Button btnAddAssignment;
    @FXML
    private Button btnAddRef;
    @FXML
    private Button btnAddNotice;
    @FXML
    private Button btnToday;
    @FXML
    private VBox root;
    @FXML
    private VBox vTaskItems;
    @FXML
    private VBox vUpcmngTaskItems;
    @FXML
    private VBox vCT;
    @FXML
    private VBox vRef;

    @FXML
    private VBox vNotice;

    @FXML
    private VBox vAssignment;

    DatabaseHandler handler = new DatabaseHandler();

    public void updateHomeDisplay() throws SQLException, IOException {
        vTaskItems.getChildren().clear();
        vUpcmngTaskItems.getChildren().clear();
        vCT.getChildren().clear();
        vCT.getChildren().add(btnAddCT);
        vAssignment.getChildren().clear();
        vAssignment.getChildren().add(btnAddAssignment);
        vRef.getChildren().clear();
        vRef.getChildren().add(btnAddRef);
        vNotice.getChildren().clear();
        vNotice.getChildren().add(btnAddNotice);

        LocalDate today = LocalDate.now();
        handler.DeletePreviousTasks(today);

        Utility.showClassItem(today, "ClassItem.fxml", vTaskItems);

        LocalDate tomorrow = today.plusDays(1);
        Utility.showClassItem(tomorrow, "ClassItem.fxml", vUpcmngTaskItems);
        Utility.showCtAssignment("ct", "ClassItem.fxml", vCT);
        Utility.showCtAssignment("assignment", "ClassItem.fxml", vAssignment);
        Utility.showCtAssignment("reference", "ClassItem.fxml", vRef);
        Utility.showCtAssignment("notice", "ClassItem.fxml", vNotice);
    }

    public void reload() {
        Platform.runLater(() -> {
            try {
                updateHomeDisplay();
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void initialize() throws SQLException {
        if (Utility.session.getUserType() == 's') {
            btnToday.setDisable(true);
            btnAddAssignment.setDisable(true);
            btnAddCT.setDisable(true);
        }
        Platform.runLater(() -> {
            try {
                updateHomeDisplay();
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    private void gotoLoginPageByClickingLogout(ActionEvent actionEvent) throws IOException {
        Utility.session.cleanLoginSession();
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

    @FXML
    private void profileInfoPopUp(ActionEvent actionEvent) throws IOException {
        Utility.popUp("ProfileInfo.fxml", "Profile Information");
    }

}
