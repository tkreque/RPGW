/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reque.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author reque
 */
public class mysqlBD {

    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_STRING = "jdbc:mysql://localhost:3306/RPG";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    
    public mysqlBD(){
     try{
         Class.forName(DB_DRIVER);
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Connection open(){
        try{
            final Connection conn = DriverManager.getConnection(DB_STRING, DB_USER, DB_PASS); 
            return conn;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }    
    }
    
    public void close(Connection conn){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }    
    
}
