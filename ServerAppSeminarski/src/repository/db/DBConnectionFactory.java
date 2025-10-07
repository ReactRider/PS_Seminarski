package repository.db;

import util.MyConstants;
import java.io.*;
import java.util.*;
import java.sql.*;

public class DBConnectionFactory {
    private Connection conn;
    private static DBConnectionFactory instance;
    
    private DBConnectionFactory() throws Exception {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(MyConstants.DB_CONFIG_FILE_NAME));
            String url = prop.getProperty(MyConstants.DB_CONFIG_URL);
            String username = prop.getProperty(MyConstants.DB_CONFIG_USERNAME);
            String password = prop.getProperty(MyConstants.DB_CONFIG_PASSWORD);
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
        } catch(Exception ex) {
            throw new Exception("Connection not created!");
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    public static DBConnectionFactory getInstance() throws Exception  {
        if(instance == null) {
            instance = new DBConnectionFactory();
        }
        return instance;
    }
}
