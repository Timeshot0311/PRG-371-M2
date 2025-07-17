package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnection {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:testDB;create=true";
    public Connection con;

    public DBConnection() {
        try {
            connect();
            createTableIfNotExists("Appointments", getAppointmentsTableSQL());
            createTableIfNotExists("Counselors", getCounselorsTableSQL());
            createTableIfNotExists("Feedback", getFeedbackTableSQL());
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found.");
            e.printStackTrace();
        }
    }
    
    public void addMissingCounselorColumns() {
    try (Statement stmt = this.con.createStatement()) {
        // Add 'specialization' if not exists
        try {
            stmt.executeUpdate("ALTER TABLE Counselors ADD COLUMN specialization VARCHAR(100)");
            System.out.println("Column 'specialization' added.");
        } catch (SQLException e) {
            if (!e.getSQLState().equals("X0Y32")) // Column already exists
                System.err.println("Error adding 'specialization': " + e.getMessage());
        }

        // Add 'availability' if not exists
        try {
            stmt.executeUpdate("ALTER TABLE Counselors ADD COLUMN availability VARCHAR(100)");
            System.out.println("Column 'availability' added.");
        } catch (SQLException e) {
            if (!e.getSQLState().equals("X0Y32"))
                System.err.println("Error adding 'availability': " + e.getMessage());
        }
    } catch (SQLException e) {
        System.err.println("General error while altering table: " + e.getMessage());
    }
}

    public void connect() throws ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            this.con = DriverManager.getConnection(JDBC_URL);
            if (this.con != null) {
                System.out.println("Connected to database");
            }
        } catch (SQLException ex) {
            System.err.println("Failed to connect to DB.");
            ex.printStackTrace();
        }
    }

    private void createTableIfNotExists(String tableName, String createSQL) {
        try {
            if (!tableExists(tableName)) {
                Statement stmt = this.con.createStatement();
                stmt.execute(createSQL);
                System.out.println(tableName + " table created.");
            } else {
                System.out.println(tableName + " table already exists.");
            }
        } catch (SQLException ex) {
            System.err.println("Error checking/creating " + tableName + " table: " + ex.getMessage());
        }
    }

    private boolean tableExists(String tableName) {
        try {
            ResultSet rs = con.getMetaData().getTables(null, null, tableName.toUpperCase(), null);
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error checking table existence: " + e.getMessage());
            return false;
        }
    }

    private String getAppointmentsTableSQL() {
        return "CREATE TABLE Appointments (" +
               "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
               "studentName VARCHAR(100), " +
               "counselorName VARCHAR(100), " +
               "date VARCHAR(20), " +
               "time VARCHAR(20), " +
               "status VARCHAR(20))";
    }

    private String getCounselorsTableSQL() {
        return "CREATE TABLE Counselors (" +
               "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
               "name VARCHAR(100), " +
               "specialization VARCHAR(100), " +
               "email VARCHAR(100))";
    }

    private String getFeedbackTableSQL() {
        return "CREATE TABLE Feedback (" +
               "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
               "studentName VARCHAR(100), " +
               "rating INT, " +
               "comments VARCHAR(255))";
    }

    public Connection getConnection() {
        return this.con;
    }
    public static void main(String[] args) {
    new DBConnection(); // Triggers constructor, connects DB, creates tables
}
}
