package models;

public class Counselor {
    private int id;
    private String name;
    private String department;
    private String email;

    // Constructor with ID (for updates, selects)
    public Counselor(int id, String name, String department, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Constructor without ID (for new inserts)
    public Counselor(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setEmail(String email) { this.email = email; }
}
