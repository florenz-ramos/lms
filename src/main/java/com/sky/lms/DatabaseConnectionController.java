package com.sky.lms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
            Connection driver = DriverManager.getConnection(cs,uname ,pass);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Connected successfully", ButtonType.OK);

            alert.show();
        }
        catch (Exception ex){
            Alert el = new Alert(Alert.AlertType.ERROR,
                    ex.getMessage(),ButtonType.OK);
            el.show();
        }

    }
}
