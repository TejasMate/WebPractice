/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ApnDb {
    
    private static final String DATABASE = ApnDb.class.getSimpleName().toLowerCase();
    private static final String URL = "jdbc:mysql://localhost:3306/"+DATABASE;
    private static final String USER = "root";
    private static final String PASS = "12345";
    
    public static Connection connectDb(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connection open");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("com.qt.webpractice.database.ApnDb.connectDB()"+e.getMessage());
        }
        return con;
        
    }
    
    public static void main(String[] args) {
       connectDb();
    }
    
}
