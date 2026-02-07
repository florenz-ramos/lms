package com.sky.lms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //Singleton Pattern
    private static DatabaseConnection _instance;
    private Connection _connection;

    public static DatabaseConnection getInstance(){
        if(_instance == null){
            _instance = new DatabaseConnection();
        }

        return _instance;
    }

    public void setConnection(Connection connection){
        _connection = connection;
    }

    public Connection getConnection() throws SQLException {
        String st = "localhost";
        int port = 3306;
        String dbName = "lms";
        String uname = "root";
        String pass = "";

        String cs = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
                st, port, dbName);

        _connection = DriverManager.getConnection(cs, uname, pass);

        return _connection;
    }



}
