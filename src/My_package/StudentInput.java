/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_package;

/**
 *
 * @author Yamashita
 */
public class StudentInput {
    private String subject;
    private String task;
    private String dueDate;
    String status = "Pending...";
    
    public StudentInput(String subject, String task, String dueDate) {
        this.subject = subject;
        this.task = task;
        this.dueDate = dueDate;
    }
    
    public String getSubject() {
        return subject;
    }
    public String getTask() {
        return task;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    public String toMyTask() {
        return subject + "|" + task + "|" + dueDate + "|" + status;
    }
}
