/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_package;

/**
 *
 * @author Yamashita
 */
public class Task {
    
    String task;
    String dueDate;
    String status = "Pending...";
    
    public Task(String task, String dueDate) {
        this.task = task;
        this.dueDate = dueDate;
    }
    
    public String getTask() {
        return task;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    public String toFile() {
        return task + "|" + dueDate + "|" + status;
    }
}
