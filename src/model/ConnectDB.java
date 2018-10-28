package model;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.AdminManager;
import view.Login;
import view.Register;
import view.UserManager;

/*  Description: Chương trình quản lý sinh viên
 *  Author: Đổng Kiến Lợi
 *  Email: kienloi10@gmail.com
 *  Date: 10/08/2018
 */
public class ConnectDB {
    private Connection con;
    Statement st;
    CallableStatement cs;
    ResultSet rs = null;
    public String role = "";
    int result; //Kết quả trả về cho executeQuery
    
    
    
    String hostName = "localhost";  //Tên miền
    String port = "1433";           //Cổng
    String dbName = "qlsv";         //Tên database
    String userName = "sa";         //Tên đăng nhập vào cơ sở dữ liệu
    String pass = "123";            //Mật khẩu đăng nhập vào cơ sở dữ liệu
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    String URL = "jdbc:sqlserver://" + hostName + ":" + port + ";database=" + dbName;
    
    /*  Tên hàm: getConnect
    *   Mô tả: Kết nối project vào cơ sở dữ liệu
    *   Kiểu trả về: không có
    *   Tham số: không có
    */
    public final void getConnect(){
     try {
         Class.forName(driver);
         con = DriverManager.getConnection(URL, userName, pass);
         System.out.print(Constant.CONNECT_OK);
     } catch (Exception ex) {
         System.out.print(Constant.CONNECT_FAILED + " Error: "+ ex);
     }
 }
    
    /*  Tên hàm: checkLogin
    *   Mô tả: Kiểm tra user và password do người dùng nhập vào
    *   Kiểu trả về: không có
    *   Tham số: String userName - chuỗi tài khoản user đăng nhập
    *   Tham số: String passWord - chuỗi password user đăng nhập
        2.2.a Check hạng mục
    */
    public void checkLogin(String username,String password){
        String codeRole = "";
        Login login = new Login();
        try {          
            st = con.createStatement();
            String query = "SELECT password,makhoa,maquyen FROM dbo.users WHERE username ='"+username+"'";
            rs = st.executeQuery(query);
           
            String passDB = "";
            if(rs.next())
            {
                passDB  = rs.getString(1).trim();
                role = rs.getString(2);
                codeRole = rs.getString(3);
            }        
            if (passDB.isEmpty()){   //Kiểm tra tên đăng nhập có tồn tại không
                    JOptionPane.showMessageDialog(null,Constant.LOGIN_E001);
            }else{
                    if(passDB.equals(password.trim())){  //Kiểm tra password trong data trở về với password user nhập 
                        JOptionPane.showMessageDialog(null,Constant.LOGIN_SUCCESS);
                        System.out.println("Quyền là: " + codeRole);
                        if (codeRole.trim().equals("1")){
                            AdminManager adminManager =  new AdminManager();
                            adminManager.setVisible(true);
                            login.setVisible(false);
                        }else{
                            UserManager userManager = new UserManager();
                            userManager.setVisible(true);
                            login.setVisible(false);
                        }                       
                    }else{
                        JOptionPane.showMessageDialog(null,Constant.LOGIN_E002);
                    }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /*
        Name: getFaculty
        Description: Get list name faculty
        Return: List<Facult>
        Parameter: null   
    */
    public List<Faculty> getFaculty(){
        List<Faculty> arrayList = new ArrayList<Faculty>();
        try{
            st = con.createStatement();
            String query = "SELECT MAKHOA, TENKHOA FROM KHOA";
            rs = st.executeQuery(query);
            while(rs.next()){            
                arrayList.add(new Faculty(rs.getString(1), rs.getString(2)));
            }         
            return arrayList;   

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    /*
        Name: addUser
        Description: Add user into table Users in database
        Return: null
        Parameter: String username - Name username
        Parameter: String password - Name password
        Parameter: String faculty - Name Khoa
        2.a.5 
    */
    public void addUser(String username, String password, String faculty ){
        try{
            String query = "{call SP_THEMUSERS(?,?,?)}";
            cs = con.prepareCall(query);
            cs.setString(1,username);
            cs.setString(2, password);
            cs.setString(3, faculty);
            result = cs.executeUpdate();           
            if (result == 1)
            {
                JOptionPane.showMessageDialog(null, Constant.REGISTER_SUCCESS);
            }else{
                JOptionPane.showMessageDialog(null, Constant.REGISTER_E002);
            }
                    
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    public void addFaculty(String codeFaculty, String nameFaculty){
        try{
            st = con.createStatement();
            String query = "INSERT INTO KHOA(MAKHOA,TENKHOA) VALUES ('" + codeFaculty + "',N'" + nameFaculty + "')";
            result = st.executeUpdate(query);
            if (result == 1){
                JOptionPane.showMessageDialog(null, Constant.FACULTY_ADD_SUCCESS);                
            }else{
                JOptionPane.showMessageDialog(null, Constant.FACULTY_ADD_FAILED);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void deleteFaculty(String codeFaculty){
        try{
            st = con.createStatement();
            String query = "DELETE FROM KHOA WHERE MAKHOA ='" + codeFaculty + "'";
            result = st.executeUpdate(query);
            if (result == 1){
                JOptionPane.showMessageDialog(null, Constant.FACULTY_DEL_SUCCESS);                
            }else{
                JOptionPane.showMessageDialog(null, Constant.FACULTY_DEL_FAILED);                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    /*
        Name: getUser
        Description: Get list name user
        Return: List<User>
        Parameter: null   
    */
    public List<User> getUser(){
        List<User> arrayList = new ArrayList<User>();
        try{
            st = con.createStatement();
            String query = "SELECT USERNAME, PASSWORD, MAKHOA FROM USERS WHERE MAQUYEN = '2'";
            rs = st.executeQuery(query);
            while(rs.next()){            
                arrayList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3)));
            }         
            return arrayList;   

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    
    public void updateUsers(String username, String password){
        try{
            st = con.createStatement();
            String query = "UPDATE USERS SET PASSWORD = '" + password + "'  WHERE USERNAME = '" + username + "'";
            result = st.executeUpdate(query);
            if (result == 1){
                JOptionPane.showMessageDialog(null, Constant.USER_UPDATESUCCESS);
            }else{
                JOptionPane.showMessageDialog(null, Constant.USER_E001);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void deleteUser(String username){
        try{
            st = con.createStatement();
            String query = "DELETE FROM USERS WHERE USERNAME ='" + username + "'";
            result = st.executeUpdate(query);
            if (result == 1){
                JOptionPane.showMessageDialog(null, Constant.USER_DEL_SUCCESS);                
            }else{
                JOptionPane.showMessageDialog(null, Constant.USER_DEL_FAILED);                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public List<Classes> getClasses(String nameFaculty){
        List<Classes> arrayList = new ArrayList<Classes>();
        try{
            st = con.createStatement();
            String query = "SELECT MALOP, TENLOP, LOP.MAKHOA "
                    + "FROM LOP, KHOA "
                    + "WHERE LOP.MAKHOA = KHOA.MAKHOA AND KHOA.TENKHOA = N'" + nameFaculty + "'";
            rs = st.executeQuery(query);
            while(rs.next()){            
                arrayList.add(new Classes(rs.getString(1), rs.getString(2), rs.getString(3)));
            }         
            return arrayList;   

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
