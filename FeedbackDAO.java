/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystems.dao;
import LibrarySystems.database.DBConnection;
import LibrarySystems.models.Feedback;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FeedbackDAO {
    // Add feedback
    public void addFeedback(Feedback feedback) {
        String sql = "INSERT INTO Feedback (studentName, message) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getStudentName());
            stmt.setString(2, feedback.getMessage());
            stmt.executeUpdate();
            System.out.println("Feedback submitted successfully.");
        } catch (SQLException e) {
            System.out.println("Error submitting feedback: " + e.getMessage());
        }
    }

    // Get all feedback
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT * FROM Feedback";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Feedback feedback = new Feedback(
                        rs.getInt("id"),
                        rs.getString("studentName"),
                        rs.getString("message")
                );
                feedbackList.add(feedback);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving feedback: " + e.getMessage());
        }

        return feedbackList;
    }

    // Update feedback
    public void updateFeedback(Feedback feedback) {
        String sql = "UPDATE Feedback SET studentName = ?, message = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getStudentName());
            stmt.setString(2, feedback.getMessage());
            stmt.setInt(3, feedback.getId());
            stmt.executeUpdate();
            System.out.println("Feedback updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating feedback: " + e.getMessage());
        }
    }

    // Delete feedback
    public void deleteFeedback(int id) {
        String sql = "DELETE FROM Feedback WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Feedback deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting feedback: " + e.getMessage());
        }
    }

    public void addFeedback(Feedback feedback) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
