package controllers;

import dao.CounselorDAO;
import models.Counselor;
import java.util.List;

public class CounselorController {

    private final CounselorDAO counselorDAO;

    public CounselorController() {
        counselorDAO = new CounselorDAO();
    }

    public void addCounselor(String name, String department, String email) {
        Counselor counselor = new Counselor(name, department, email);
        counselorDAO.addCounselor(counselor);
    }

    public List<Counselor> getAllCounselors() {
        return counselorDAO.getAllCounselors();
    }

    public void updateCounselor(int id, String name, String department, String email) {
        Counselor counselor = new Counselor(id, name, department, email);
        counselorDAO.updateCounselor(counselor);
    }

    public void deleteCounselor(int id) {
        counselorDAO.deleteCounselor(id);
    }
}
