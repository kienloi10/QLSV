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
public class Faculty {

    private String codeFaculty;
    private String nameFaculty;
    
    public Faculty(String codeFaculty, String nameFaculty) {
        this.codeFaculty = codeFaculty;
        this.nameFaculty = nameFaculty;
    }

    public Faculty() {
    }
    

    public String getCodeFaculty() {
        return codeFaculty;
    }

    public void setCodeFaculty(String codeFaculty) {
        this.codeFaculty = codeFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }
    
    
    
}
