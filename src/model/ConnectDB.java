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
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ConnectDB {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    public String role = ""; 
    
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
    
    public void checkLogin(String username,String password){
        try {          
            st = con.createStatement();
            String query = "SELECT password,makhoa FROM dbo.users WHERE username ='"+username+"'";
            rs = st.executeQuery(query);
           
            String passDB = "";
            if(rs.next())
            {
                passDB  = rs.getString(1).trim();
                role = rs.getString(2);
            }        
            if (passDB.isEmpty()){   //Kiểm tra tên đăng nhập
                    JOptionPane.showMessageDialog(null,Constant.LOGIN_E001);
            }else{
                    if(passDB.equals(password.trim())){  //Kiểm tra password trong data trở về với password user nhập 
                        JOptionPane.showMessageDialog(null,Constant.LOGIN_SUCCESS);
                    }else{
                        JOptionPane.showMessageDialog(null,Constant.LOGIN_E002);
                    }
            }
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }
    }
    
    
    
}
