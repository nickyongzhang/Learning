module com.example.musicui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.musicui to javafx.fxml;
    opens com.example.musicui.model to javafx.fxml;
    exports com.example.musicui;
    exports com.example.musicui.model;
}