package dao;

import models.Appointment;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    private final Connection conn;

    public AppointmentDAO(DBConnection db) {
        this.conn = db.getConnection();
    }

    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO Appointments (studentName, counselorName, date, time, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, appointment.getStudentName());
            stmt.setString(2, appointment.getCounselorName());
            stmt.setString(3, appointment.getDate());
            stmt.setString(4, appointment.getTime());
            stmt.setString(5, appointment.getStatus());
            stmt.executeUpdate();
            System.out.println("Appointment added.");
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM Appointments";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"),
                        rs.getString("studentName"),
                        rs.getString("counselorName"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Select failed: " + e.getMessage());
        }
        return list;
    }

    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE Appointments SET studentName = ?, counselorName = ?, date = ?, time = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, appointment.getStudentName());
            stmt.setString(2, appointment.getCounselorName());
            stmt.setString(3, appointment.getDate());
            stmt.setString(4, appointment.getTime());
            stmt.setString(5, appointment.getStatus());
            stmt.setInt(6, appointment.getId());
            stmt.executeUpdate();
            System.out.println("Appointment updated.");
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
        }
    }

    public void deleteAppointment(int id) {
        String sql = "DELETE FROM Appointments WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Appointment deleted.");
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
        }
    }
}
