/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOSCI.CHRISTIAN
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnessioneDb {
    
    private static final String URL = "jdbc:mysql://localhost:3306/apicoltura";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
    
    


