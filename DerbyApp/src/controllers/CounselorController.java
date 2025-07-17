package controllers;

import dao.CounselorDAO;
import models.Counselor;
import database.DBConnection;
import java.util.List;

public class CounselorController {

    private final CounselorDAO counselorDAO;

    public CounselorController(DBConnection db) {
        this.counselorDAO = new CounselorDAO(db);
    }

    public void addCounselor(String name, String specialization, String email) {
        Counselor counselor = new Counselor(name, specialization, email);
        counselorDAO.addCounselor(counselor);
    }

    public List<Counselor> getAllCounselors() {
        return counselorDAO.getAllCounselors();
    }

    public void updateCounselor(int id, String name, String specialization, String email) {
        Counselor counselor = new Counselor(id, name, specialization, email);
        counselorDAO.updateCounselor(counselor);
    }

    public void deleteCounselor(int id) {
        counselorDAO.deleteCounselor(id);
    }
}
