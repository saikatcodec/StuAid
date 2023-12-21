module com.retake.stuaid {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.retake.stuaid to javafx.fxml;
    exports com.retake.stuaid;
    exports com.retake.stuaid.controller;
    opens com.retake.stuaid.controller to javafx.fxml;
}