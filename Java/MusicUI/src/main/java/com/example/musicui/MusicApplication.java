package com.example.musicui;

import com.example.musicui.model.Datasource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MusicApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MusicApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        MusicController controller = fxmlLoader.getController();
        controller.listArtists();

        stage.setTitle("Music Database");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if (!Datasource.getInstance().open()){
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        };
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Datasource.getInstance().close();
    }

    public static void main(String[] args) {
        launch();
    }
}