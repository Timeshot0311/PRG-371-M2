/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystems.models;


public class Feedback {
    private int id;
    private String studentName;
    private int rating; // Rating from 1 to 5
    private String comments;

    // Constructor with ID (used when reading from DB)
    public Feedback(int id, String studentName, int rating, String comments) {
        this.id = id;
        this.studentName = studentName;
        this.rating = rating;
        this.comments = comments;
    }

    // Constructor without ID (used when creating new records)
    public Feedback(String studentName, int rating, String comments) {
        this.studentName = studentName;
        this.rating = rating;
        this.comments = comments;
    }

    public Feedback(String studentName, String message) {
    }

    public Feedback(int id, String name, String message) {
    }

    // Getters
    public int getId() { return id; }
    public String getStudentName() { return studentName; }
    public int getRating() { return rating; }
    public String getComments() { return comments; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setRating(int rating) { this.rating = rating; }
    public void setComments(String comments) { this.comments = comments; }

    public String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
