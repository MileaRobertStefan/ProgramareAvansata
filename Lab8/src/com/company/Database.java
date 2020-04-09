package com.company;

import java.sql.*;

public class Database {
   private static Connection myConn;
    private static Database singleton = null;

    public void append(String command) {
        try {
            Statement myStmt = myConn.createStatement();
            myStmt.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String command){
        try {
            Statement myStmt = myConn.createStatement();
            return myStmt.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Database getInstance() {
        if (singleton == null) {
            singleton = new Database();
            try {
                 myConn = DriverManager.getConnection(Controller.getUrl(), Controller.getName(), Controller.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return singleton;
    }

    private Database() {
    }


}
