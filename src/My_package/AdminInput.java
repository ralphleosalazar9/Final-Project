/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_package;

/**
 *
 * @author Yamashita
 */

public class AdminInput {
    
    private String fullName;
    private String idNumber;
    private String password;
    private String task;
    private String dueDate;
    String status = "Pending...";
    
    public AdminInput(String fullName, String idNumber, String password) {
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.password = password;
    }
    public AdminInput(String task, String dueDate) {
        this.task = task;
        this.dueDate = dueDate;
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
    
    public String toRegister() {
        return fullName + "|" + idNumber + "|" + password;
    }
    
    public String getTask() {
        return task;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    public String toTask() {
        return task + "|" + dueDate + "|" + status;
    }
}
