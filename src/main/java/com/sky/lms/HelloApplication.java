package com.sky.lms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException, SQLException {
        int WIDTH = 300;
        int HEIGHT = 300;

        var connectionView = DatabaseConnection.getInstance().getConnection() != null
                ? "hello-view.fxml"
                : "database-connection.fxml";

        var resource = HelloController.class.getResource(connectionView);

        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle("Library Management System");
        stage.setScene(scene);

        if(connectionView.equals("hello-view.fxml")){
            stage.setMaximized(true);
        }

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}