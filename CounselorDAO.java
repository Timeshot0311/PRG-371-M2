/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystems.dao;
import LibrarySystems.models.Counselor;
import LibrarySystems.database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CounselorDAO {
    // Constructor creates the table if it doesn't exist
    public CounselorDAO() {
        createTable();
    }

    // STEP 1: Create Counselor table
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Counselors ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "name VARCHAR(100), "
                + "department VARCHAR(100), "
                + "email VARCHAR(100))";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            if (!e.getSQLState().equals("X0Y32")) {
                System.err.println("Error creating Counselors table: " + e.getMessage());
            }
        }
    }

    // STEP 2: Add new counselor
    public void addCounselor(Counselor counselor) {
        String sql = "INSERT INTO Counselors (name, department, email) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, counselor.getName());
            stmt.setString(2, counselor.getDepartment());
            stmt.setString(3, counselor.getEmail());

            stmt.executeUpdate();
            System.out.println("Counselor added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding counselor: " + e.getMessage());
        }
    }

    // STEP 3: View all counselors
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
            System.err.println("Error fetching counselors: " + e.getMessage());
        }

        return list;
    }

    // STEP 4: Update counselor
    public void updateCounselor(Counselor counselor) {
        String sql = "UPDATE Counselors SET name = ?, department = ?, email = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, counselor.getName());
            stmt.setString(2, counselor.getDepartment());
            stmt.setString(3, counselor.getEmail());
            stmt.setInt(4, counselor.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Counselor updated successfully.");
            } else {
                System.out.println("No counselor found with ID: " + counselor.getId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating counselor: " + e.getMessage());
        }
    }

    // STEP 5: Delete counselor by ID
    public void deleteCounselor(int id) {
        String sql = "DELETE FROM Counselors WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Counselor deleted successfully.");
            } else {
                System.out.println("No counselor found with ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting counselor: " + e.getMessage());
        }
    }

    public void addCounselor(Counselor counselor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
