package com.retake.stuaid;

import com.retake.stuaid.database.DatabaseHandler;
import com.retake.stuaid.model.TodoModel;
import com.retake.stuaid.session.LoginSession;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static LoginSession session;

    public static void changeScene(Parent root, String name, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(Utility.class.getResource(name));
        Scene scene = new Scene(loader.load());
        Stage crntStage = (Stage) root.getScene().getWindow();
        crntStage.setScene(scene);
        crntStage.setTitle(title);
        crntStage.centerOnScreen();
    }

    public static void popUp(String name, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(Utility.class.getResource(name));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle(title);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.isAlwaysOnTop();
        stage.show();
    }

    public static void addClassItem(LocalDate today, String name, VBox vBox) throws SQLException, IOException {
        DatabaseHandler dbUser = new DatabaseHandler();
        ResultSet result = dbUser.getTodayTasksClass(today);
        List<TodoModel> model = new ArrayList<>();
        int count = 0;

        while (result.next()) {
            count++;
            model.add(new TodoModel(result.getString("course_title"), result.getString("cdate"), result.getString("ctime")));
        }

        Node[] nodes = new Node[count];
        for (int i = 0; i < nodes.length; i++) {
            FXMLLoader loader = new FXMLLoader(HomePageController.class.getResource(name));
            ClassItemController controller = new ClassItemController();
            loader.setController(controller);
            nodes[i] = loader.load();
            vBox.getChildren().add(nodes[i]);
            controller.setTask(i + 1, model.get(i));
        }
    }

    public static void setBorderColor(TextField node, String color) {
        node.setStyle("-fx-border-color: " + color);
    }

    public static void setBorderColorArea(TextArea txtRefArea, String color) {
        txtRefArea.setStyle("-fx-border-color: " + color);
    }
}
