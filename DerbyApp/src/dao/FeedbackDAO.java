package dao;

import database.DBConnection;
import models.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    private final Connection conn;

    public FeedbackDAO(DBConnection db) {
        this.conn = db.getConnection();
    }

    public void addFeedback(Feedback feedback) {
        String sql = "INSERT INTO Feedback (studentName, rating, comments) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getStudentName());
            stmt.setInt(2, feedback.getRating());
            stmt.setString(3, feedback.getComments());
            stmt.executeUpdate();
            System.out.println("Feedback submitted.");
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
        }
    }

    public List<Feedback> getAllFeedback() {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM Feedback";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Feedback(
                        rs.getInt("id"),
                        rs.getString("studentName"),
                        rs.getInt("rating"),
                        rs.getString("comments")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Fetch failed: " + e.getMessage());
        }
        return list;
    }

    public void updateFeedback(Feedback feedback) {
        String sql = "UPDATE Feedback SET studentName = ?, rating = ?, comments = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getStudentName());
            stmt.setInt(2, feedback.getRating());
            stmt.setString(3, feedback.getComments());
            stmt.setInt(4, feedback.getId());
            stmt.executeUpdate();
            System.out.println("Feedback updated.");
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
        }
    }

    public void deleteFeedback(int id) {
        String sql = "DELETE FROM Feedback WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Feedback deleted.");
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
        }
    }
}
