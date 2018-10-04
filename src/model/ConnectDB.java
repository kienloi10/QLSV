/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ConnectDB {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    
    String hostName = "localhost";
    String port = "1433";
    String dbName = "qlsv"; 
    String username = "sa";
    String pass = "123";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    String URL = "jdbc:sqlserver://" + hostName + ":" + port + ";database=" + dbName;
    
    public final void getConnect(){
     try {
         Class.forName(driver);
         con = DriverManager.getConnection(URL, username, pass);
         System.out.print(Constant.CONNECT_OK);
     } catch (Exception ex) {
         System.out.print(Constant.CONNECT_FAILED + " Error: "+ ex);
     }

 }
    
    public void checkLogin(){
        try {          
            st = con.createStatement();
            String query = " SELECT * FROM users WHERE username ='adminCNTT'";
            rs = st.executeQuery(query);
            //System.out.println();
            while(rs.next())
            {
                String password  = rs.getString(2);
                System.out.println("Password =" + password);
            }
        } catch (Exception e) {
            System.out.println("Erro "+ e);
        }
    }
    
    
    
}
