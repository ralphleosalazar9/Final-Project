/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_package;

/**
 *
 * @author Yamashita
 */
import java.io.*;
public class FileHandler {
    
    public static void createFileRegister() {
        File file = new File("Register.txt");
    }
    
    public static void createFileAccount() {
        File file = new File("Account.txt");
    }
    
    public static void createTaskFile() {
        File file = new File("Task.txt");
    }
    
    public static void createMyTaskFile() {
        File file = new File("MyTask.txt");
    }
    
    public static boolean saveToRegister(UserInput account) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Register.txt", true));
            writer.write(account.toFile());
            writer.newLine();
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean checkId(String searchId, String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length > 1) {
                    if (parts[1].trim().equals(searchId)) {
                        reader.close();
                        return true;
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    public static boolean confirmRegister(String targetId) {
        String fileContent = "";
        boolean found = false;
        String approvedLine = "";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Register.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length > 1 && parts[1].trim().equals(targetId)) {
                    approvedLine = line;
                    found = true;
                } else {
                    fileContent += line + System.lineSeparator();
                }
            }
            reader.close();
        } catch (Exception e) {
            return false;
        }
        
        if (!found) return false;
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Account.txt", true));
            writer.write(approvedLine);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            return false;
        }
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Register.txt", false));
            writer.write(fileContent);
            writer.close();
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public static boolean loadRegisterTable(javax.swing.table.DefaultTableModel model) {
        model.setRowCount(0);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Register.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                model.addRow(data);
            }
            reader.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean deleteRecord(javax.swing.table.DefaultTableModel model, String fileName){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            for (int i = 0; i < model.getRowCount(); i++) {
                String fullName = model.getValueAt(i, 0).toString();
                String idNumber = model.getValueAt(i, 1).toString();
                String password = model.getValueAt(i, 2).toString();
                
                writer.write(fullName + "|" + idNumber + "|" + password);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean addClassTask(Task task) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Task.txt", true));
            writer.write(task.toFile());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean loadTask(javax.swing.table.DefaultTableModel model) {
        model.setRowCount(0);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Task.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] task = line.split("\\|");
                model.addRow(task);
            }
            reader.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static String getLoggedInUser(String inputId, String inputPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Account.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    String fileId = parts[1].trim();
                    String filePass = parts[2].trim();
                    
                    if (fileId.equals(inputId) && filePass.equals(inputPassword)) {
                        return line;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
    
    public static boolean saveTask(String studentId, String subject, String task, String dueDate, String status) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("MyTask.txt", true))) {
            writer.write(studentId + "|" + subject + "|" + task + "|" + dueDate + "|" + status);
            writer.newLine();
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean readTask(javax.swing.table.DefaultTableModel model, String currentStudentId) {
        model.setRowCount(0);
        
        System.out.println("Current Session ID: [" + currentStudentId + "]");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("MyTask.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 5) {
                    String fileId = parts[0].trim();
                    String subject = parts[1].trim();
                    String task = parts[2].trim();
                    String dueDate = parts[3].trim();
                    String status = parts[4].trim();
                    
                    if (fileId.equals(currentStudentId)) {
                        model.addRow(new Object[]{subject, task, dueDate, status});
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
