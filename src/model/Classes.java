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
public class Classes {

    private String codeClass;
    private String nameClass;
    private String codeFaculty;
    
    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getCodeFaculty() {
        return codeFaculty;
    }

    public void setCodeFaculty(String codeFaculty) {
        this.codeFaculty = codeFaculty;
    }

    public Classes(String codeClass, String nameClass, String codeFaculty) {
        this.codeClass = codeClass;
        this.nameClass = nameClass;
        this.codeFaculty = codeFaculty;
    }
    
    
}
