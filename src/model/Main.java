package model;

import view.AdminManager;
import view.Login;
import view.UserManager;


/** Mô tả: Chương trình quản lý sinh viên
 *  Tác giả: Đổng Kiến Lợi
 *  Email: kienloi10@gmail.com
 *  Ngày cập nhật: 10/07/20148
 */
public class Main{ 
        
    /*  Tên hàm: main
    *   Mô tả: Hàm main của project
    *   Kiểu trả về: không có
    *   Tham số: String [] args    
    */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Login lg = new Login();
        lg.setVisible(true);
//            UserManager user = new UserManager();
//            user.setVisible(true);
//            AdminManager admin = new AdminManager();
//            admin.setVisible(true);
    }
    
}
