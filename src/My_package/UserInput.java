/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_package;

/**
 *
 * @author Yamashita
 */

public class UserInput {
    
    private String fullName;
    private String idNumber;
    private String password;
    
    public UserInput(String fullName, String idNumber, String password) {
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.password = password;
    }
 
    public String getFullName() {
        return fullName;
    }
    
    public String getIdNumber() {
        return idNumber;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String toFile() {
        return fullName + "|" + idNumber + "|" + password;
    }
}
