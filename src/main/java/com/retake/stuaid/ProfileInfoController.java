package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import com.retake.stuaid.model.StudentModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileInfoController {
    @FXML
    private VBox vBoxStudent;
    @FXML
    private Label lblProfileName;
    @FXML
    private Label lblProfileEmail;
    @FXML
    private Label lblUserType;

    public void initialize() throws SQLException, IOException {
        setProfileInfo();
        showStudents();
    }

    private void setProfileInfo() {
        lblProfileName.setText(Utility.session.getName());
        lblProfileEmail.setText(Utility.session.getEmail());
        switch (Utility.session.getUserType()) {
            case 't':
                lblUserType.setText("Teacher");
                break;
            case 's':
                lblUserType.setText("Student");
                break;
            case 'c':
                lblUserType.setText("Class Representative (CR)");
                break;
        }
    }

    private void showStudents() throws SQLException, IOException {
        DatabaseHandler dbUser = new DatabaseHandler();
        ResultSet resultSet = dbUser.ShowAllStudent();
        List<StudentModel> students = new ArrayList<>();
        int count = 0;

        while (resultSet.next()) {
            count++;
            students.add(new StudentModel(resultSet.getString("email"), resultSet.getString("name"), resultSet.getString("usertype").charAt(0)));
        }

        Node[] nodes = new Node[count];
        for (int i = 0; i < nodes.length; i++) {
            FXMLLoader loader = new FXMLLoader(ProfileInfoController.class.getResource("AddStudent.fxml"));
            AddStudentController controller = new AddStudentController();
            loader.setController(controller);
            nodes[i] = loader.load();
            vBoxStudent.getChildren().add(nodes[i]);
            controller.setProperties(i + 1, students.get(i));
        }
    }
}
