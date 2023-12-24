package com.retake.stuaid;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utility {
    public static void changeScene(Parent root, String name, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(Utility.class.getResource(name));
        Scene scene = new Scene(loader.load());
        Stage crntStage = (Stage) root.getScene().getWindow();
        crntStage.setScene(scene);
        crntStage.setTitle(title);
        crntStage.centerOnScreen();
    }

    public static void popUp() {

    }
}
