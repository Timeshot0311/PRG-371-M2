package dao;

import database.DBConnection;
import models.Counselor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CounselorDAO {

    public CounselorDAO() {
        createTable();
    }

    private void createTable() {
        String sql = "CREATE TABLE Counselors ("
                   + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                   + "name VARCHAR(100), "
                   + "department VARCHAR(100), "
                   + "email VARCHAR(100))";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            if (!"X0Y32".equals(e.getSQLState())) {
                System.err.println("Error creating Counselors table: " + e.getMessage());
            }
        }
    }

    public void addCounselor(Counselor counselor) {
        String sql = "INSERT INTO Counselors (name, department, email) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, counselor.getName());
            stmt.setString(2, counselor.getDepartment());
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

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Counselor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Fetch failed: " + e.getMessage());
        }

        return list;
    }

    public void updateCounselor(Counselor counselor) {
        String sql = "UPDATE Counselors SET name = ?, department = ?, email = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, counselor.getName());
            stmt.setString(2, counselor.getDepartment());
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

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Counselor deleted.");
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
        }
    }
}
