/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class CheckAll {
    
    private final static int MAX_LENGTH = 10;
    /*
        Tên hàm: checkSpecialValue
        Mô tả: Kiểm tra chuỗi truyền vào có ký tự đặc biệt không
        Kiểu trả về: true / false
        Tham số: String s - Chuỗi s
    */
    public boolean checkSpecialValue(String s)
    {
        char [] specialValue = {'=','!','@','#','$','%','^','&','*',' '};
        boolean result = false; // Mặc định chuỗi truyền vào chưa có ký tự đặc biệt
        char a[] = s.toCharArray(); //Tách chuỗi s thành mảng a ký tự
        for ( int i = 0; i < a.length; i++)
        {
            for ( int j = 0; j < specialValue.length; j++)
            {
                if (a[i] == specialValue[j])
                    result = true;
            }
        }
        return result;
    }
    
        /*
        Tên hàm: checkLength
        Mô tả: Kiểm tra chuỗi truyền vào có quá độ dài cho phép không
        Kiểu trả về: true / false
        Tham số: String s - Chuỗi s
    */
    public boolean checkLength(String s)
    {
        char a[] = s.toCharArray(); //Tách chuỗi s thành mảng a ký tự
        boolean result = false;     //Mặc định chuỗi truyền vào đủ độ dài
        if (a.length > MAX_LENGTH)
        {
            result = true;
        }
        return result;
    }
    
    public void clearTable(DefaultTableModel tb) {
        tb.setRowCount(0);
    }
    
    public boolean checkEmpty(String s){
        boolean result = false;
        if (s.equals("")){
            result = true;
        }
        return result;
    }
    
    public String changeSex(String sex){
        String result = "";
        if (sex.equals("1")){
            result = "Nam";
        }else{
            result = "Nữ";
        }
        return result;
    }
}
