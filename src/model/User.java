/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class User {
    private String username;
    private String password;
    private String codeFaculty;
    private String codeRole;
    
    public String getCodeRole() {
        return codeRole;
    }

    public void setCodeRole(String codeRole) {
        this.codeRole = codeRole;
    }
    
    public User(String username, String password, String codeFaculty) {
        this.username = username;
        this.password = password;
        this.codeFaculty = codeFaculty;
    }


    public String getCodeFaculty() {
        return codeFaculty;
    }

    public void setCodeFaculty(String codeFaculty) {
        this.codeFaculty = codeFaculty;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
    
}
