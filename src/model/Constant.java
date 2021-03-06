/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*  Description: Chương trình quản lý sinh viên
 *  Author: Đổng Kiến Lợi
 *  Email: kienloi10@gmail.com
 *  Date: 10/08/2018
 */
public final class Constant {
    //Kết nối thành công
    public final static String CONNECT_OK = "Connect successfully";
    //Kết nối thất bại
    public final static String CONNECT_FAILED = "Connect failed";
    
    //Lỗi trong view Login
    public final static String LOGIN_EMPTY = "Empty Username or Password";
    public final static String LOGIN_E001 = "Wrong Username";
    public final static String LOGIN_E002 = "Wrong Password";
    public final static String LOGIN_E003 = "Username has a special character";
    public final static String LOGIN_E004 = "Username too long length";
    
    public final static String LOGIN_SUCCESS = "Login successfully";
    
    //Lỗi trong view Register
    public final static String REGISTER_EMPTY = "Empty Username or Password or Confirm password";
    public final static String REGISTER_E001 = "Password do not match";
    public final static String REGISTER_E002 = "Register failed,Username exist";
    public final static String REGISTER_E003 = "Username has a special character";
    public final static String REGISTER_E004 = "Username too long length";
    public final static String REGISTER_SUCCESS = "Register successfully";
    
    //Lỗi trong view Faculty
    public final static String FACULTY_ADD_SUCCESS = "Add successfully";
    public final static String FACULTY_ADD_FAILED = "Add failed";

    public final static String FACULTY_E001 = "Empty CodeFaculty or NameFaculty";
    public final static String FACULTY_E002 = "CodeFaculty or NameFaculty has a special character";

    public final static String FACULTY_DEL_SUCCESS = "Delete faculty successfully";
    public final static String FACULTY_DEL_FAILED = "Delete faculty failed";
    
    public final static String FACULTY_UPDATE_SUCCESS = "Update faculty successfully";
    public final static String FACULTY_UPDATE_FAILED = "Update faculty failed";
    
    //Lỗi trong view User
    public final static String USER_UPDATESUCCESS = "Update user successfully";
    public final static String USER_E001 = "Update failed";
    public final static String USER_E002 = "Username or password empty";
    public final static String USER_E003 = "Username or password has a special character";
    public final static String USER_QUESTION = "Do you want delete?";
    
    public final static String USER_DEL_SUCCESS = "Delete user successfully";
    public final static String USER_DEL_FAILED = "Delete user failed";
    
    
    
    //Lỗi trong view Class
    public final static String CLASS_E001 = "CodeClass or NameClass empty";
    public final static String CLASS_E002 = "CodeClass or NameClass has a special character";
    
    public final static String CLASS_ADD_SUCCESS = "Add class successfully";
    public final static String CLASS_ADD_FAILED = "Add class failed";
    
    public final static String CLASS_DEL_SUCCESS = "Delete class successfully";
    public final static String CLASS_DEL_FAILED = "Delete class failed";
    
    public final static String CLASS_UPDATE_SUCCESS = "Update class successfully";
    public final static String CLASS_UPDATE_FAILED = "Update class failed";
    
    
    //Lỗi trong view user
    public final static String UM_E001 = "CodeStudent is empty or has a special character";
    
    public final static String STUDENT_ADD_SUCCESS = "Add student successfully";
    public final static String STUDENT_ADD_FAILED = "Add student failed";
    
    public final static String STUDENT_DEL_SUCCESS = "Delete student successfully";
    public final static String STUDENT_DEL_FAILED = "Delete student failed";
    
    public final static String STUDENT_UPDATE_SUCCESS = "Update student successfully";
    public final static String STUDENT_UPDATE_FAILED = "Update student failed";
}


