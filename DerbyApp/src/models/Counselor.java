package models;

public class Counselor {
    private int id;
    private String name;
    private String specialization;
    private String email;

    // Constructor with ID
    public Counselor(int id, String name, String specialization, String email) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
    }

    // Constructor without ID
    public Counselor(String name, String specialization, String email) {
        this.name = name;
        this.specialization = specialization;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getEmail() { return email; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setEmail(String email) { this.email = email; }
}
