package controllers;

import dao.AppointmentDAO;
import models.Appointment;
import database.DBConnection;
import java.util.List;

public class AppointmentController {

    private final AppointmentDAO appointmentDAO;

    public AppointmentController(DBConnection db) {
        this.appointmentDAO = new AppointmentDAO(db);
    }

    public void addAppointment(String studentName, String counselorName, String date, String time, String status) {
        Appointment newAppointment = new Appointment(studentName, counselorName, date, time, status);
        appointmentDAO.addAppointment(newAppointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    public void updateAppointment(int id, String studentName, String counselorName, String date, String time, String status) {
        Appointment updatedAppointment = new Appointment(id, studentName, counselorName, date, time, status);
        appointmentDAO.updateAppointment(updatedAppointment);
    }

    public void deleteAppointment(int id) {
        appointmentDAO.deleteAppointment(id);
    }
}
