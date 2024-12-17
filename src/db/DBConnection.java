/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;

/**
 *
 * @author Stefan
 */
public class DBConnection {
     private static DBConnection instance;
    private Connection connection;
    
    public DBConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/seminarski";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
        } catch(Exception e) {
            System.out.println("Greska pri uspostavljanju konekcije!\n" + e.getMessage());
        }
    }
    
    public static DBConnection getInstance() {
        if(instance == null)
            instance = new DBConnection();
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
}
