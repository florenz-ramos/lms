package com.sky.lms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionController {
    @FXML
    private TextField server;

    @FXML
    private TextField port;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    private static final String URL = "";

    @FXML
    public void onTestConnectionEvent(ActionEvent actionEvent) {
        String st = server.getText();
        String pt = port.getText();
        String dbName = "lms";
        String uname = username.getText();
        String pass = password.getText();

        String cs = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
                st,pt,dbName);

        try{
            Connection driver = DriverManager.getConnection(cs, uname, pass);

            DatabaseConnection.getInstance().setConnection(driver);

            Stage currentStage = (Stage)((javafx.scene.Node)actionEvent.getSource())
                    .getScene().getWindow();

            currentStage.close();

            FXMLLoader loader = new FXMLLoader(
                    HelloController.class.getResource("hello-view.fxml"));

            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(loader.load()));
            nextStage.setTitle("Library Management System");
            nextStage.setMaximized(true);
            nextStage.show();

            new Alert(Alert.AlertType.INFORMATION,"Connected successfully", ButtonType.OK)
                    .show();
        }
        catch (Exception ex){
            new Alert(Alert.AlertType.ERROR,ex.getMessage(),ButtonType.OK)
                    .show();
        }

    }
}
