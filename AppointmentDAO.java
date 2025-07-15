/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystems.dao;
// Import the Appointment model class
import LibrarySystems.models.Appointment;
// Import database connection utility
import LibrarySystems.database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AppointmentDAO {
    // Constructor that creates the table when DAO is initialized
    public AppointmentDAO() {
        createTable();
    }

    // STEP 2: Create the Appointments table if it does not exist already
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Appointments ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "studentName VARCHAR(100), "
                + "counselorName VARCHAR(100), "
                + "date VARCHAR(20), "
                + "time VARCHAR(20), "
                + "status VARCHAR(20)"
                + ")";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            // If the error is not "table already exists", show error
            if (!e.getSQLState().equals("X0Y32")) {
                System.err.println("Error creating Appointments table: " + e.getMessage());
            }
        }
    }

    // STEP 3: Insert a new appointment into the table
    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO Appointments (studentName, counselorName, date, time, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, appointment.getStudentName());
            stmt.setString(2, appointment.getCounselorName());
            stmt.setString(3, appointment.getDate());
            stmt.setString(4, appointment.getTime());
            stmt.setString(5, appointment.getStatus());

            stmt.executeUpdate();
            System.out.println("Appointment successfully added.");
        } catch (SQLException e) {
            System.err.println("Failed to insert appointment: " + e.getMessage());
        }
    }

    // STEP 4: Retrieve all appointments from the database
    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM Appointments";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Creating a new Appointment object for each row
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
            System.err.println("Error fetching appointments: " + e.getMessage());
        }

        return list;
    }

    
}
