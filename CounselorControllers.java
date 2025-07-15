/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystems.controllers;
import LibrarySystems.dao.CounselorDAO;
import LibrarySystems.models.Counselor;
import java.util.List;



public class CounselorControllers {
    private final CounselorDAO counselorDAO;

    // Constructor to initialize DAO
    public CounselorControllers) {
        counselorDAO = new CounselorDAO();
    }

    // Add a new counselor
    public void addCounselor(String name, String department, String email) {
        Counselor counselor = new Counselor(name, department, email);
        counselorDAO.addCounselor(counselor);
    }

    // Get all counselors from database
    public List<Counselor> getAllCounselors() {
        return counselorDAO.getAllCounselors();
    }

    // Update a counselor by ID
    public void updateCounselor(int id, String name, String department, String email) {
        Counselor counselor = new Counselor(id, name, department, email);
        counselorDAO.updateCounselor(counselor);
    }

    // Delete a counselor by ID
    public void deleteCounselor(int id) {
        counselorDAO.deleteCounselor(id);
    }

    public void addCounselor(String name, String department, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
