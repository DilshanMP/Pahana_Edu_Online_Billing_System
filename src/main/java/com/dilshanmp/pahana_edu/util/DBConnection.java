package com.dilshanmp.pahana_edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DBConnection {
    private static  DBConnection instance;
    private Connection connection;

    //db config
    private static final String URL ="jdbc:mysql://localhost:3306/pahana_edu_billing";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="1234";

    private DBConnection() throws SQLException{
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (ClassNotFoundException e){
            throw new SQLException("MySQL Driver not found", e);
        }
    }
    public static DBConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }


}
