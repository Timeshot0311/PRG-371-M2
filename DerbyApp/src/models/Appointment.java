/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Suhil Jugroop
 */
public class Appointment {
    private int id;
    private String studentName;
    private String counselorName;
    private String date;
    private String time;
    private String status;

    // Constructor with ID (used when reading from DB)
    public Appointment(int id, String studentName, String counselorName, String date, String time, String status) {
        this.id = id;
        this.studentName = studentName;
        this.counselorName = counselorName;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    // Constructor without ID (used when creating new records)
    public Appointment(String studentName, String counselorName, String date, String time, String status) {
        this.studentName = studentName;
        this.counselorName = counselorName;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    // Getters
    public int getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getCounselorName() { return counselorName; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setCounselorName(String counselorName) { this.counselorName = counselorName; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setStatus(String status) { this.status = status; }
    
}
