package model;

import java.sql.Array;
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
import view.Register;

/** Mô tả: Chương trình quản lý sinh viên
 *  Tác giả: Đổng Kiến Lợi
 *  Email: kienloi10@gmail.com
 *  Ngày cập nhật: 10/07/20148
 */
public class ConnectDB {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    public String role = "";
    
    
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
    */
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
            if (passDB.isEmpty()){   //Kiểm tra tên đăng nhập có tồn tại không
                    JOptionPane.showMessageDialog(null,Constant.LOGIN_E001);
            }else{
                    if(passDB.equals(password.trim())){  //Kiểm tra password trong data trở về với password user nhập 
                        JOptionPane.showMessageDialog(null,Constant.LOGIN_SUCCESS);                      
                    }else{
                        JOptionPane.showMessageDialog(null,Constant.LOGIN_E002);
                    }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /*
        Tên hàm: getFaculty
        Mô tả: Lấy danh sách tên khoa
        KIểu trả về: List<Facult>
        Tham số: không có   
    */
    public List<Faculty> getFaculty(){
        List<Faculty> arrayList = new ArrayList<Faculty>();
        //faculty = null;
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
    
    public void addUser(String username, String password, String faculty ){
        try{
            st = con.createStatement();
            String query = "INSERT INTO Users(USERNAME,PASSWORD,MAKHOA) VALUES ('" + username + "','" + password + "','" +faculty+ "')";
            int result = st.executeUpdate(query);
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
    
    
}
