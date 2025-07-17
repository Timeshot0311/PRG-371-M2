package dao;

import database.DBConnection;
import models.Counselor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CounselorDAO {

    private final Connection conn;

    public CounselorDAO(DBConnection db) {
        this.conn = db.getConnection();
    }

    public void addCounselor(Counselor counselor) {
        String sql = "INSERT INTO Counselors (name, specialization, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, counselor.getName());
            stmt.setString(2, counselor.getSpecialization());
            stmt.setString(3, counselor.getEmail());
            stmt.executeUpdate();
            System.out.println("Counselor added.");
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
        }
    }

    public List<Counselor> getAllCounselors() {
        List<Counselor> list = new ArrayList<>();
        String sql = "SELECT * FROM Counselors";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Counselor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Fetch failed: " + e.getMessage());
        }
        return list;
    }

    public void updateCounselor(Counselor counselor) {
        String sql = "UPDATE Counselors SET name = ?, specialization = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, counselor.getName());
            stmt.setString(2, counselor.getSpecialization());
            stmt.setString(3, counselor.getEmail());
            stmt.setInt(4, counselor.getId());
            stmt.executeUpdate();
            System.out.println("Counselor updated.");
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
        }
    }

    public void deleteCounselor(int id) {
        String sql = "DELETE FROM Counselors WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Counselor deleted.");
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
        }
    }
}
