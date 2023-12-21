module com.retake.stuaid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.retake.stuaid to javafx.fxml;
    exports com.retake.stuaid;
}