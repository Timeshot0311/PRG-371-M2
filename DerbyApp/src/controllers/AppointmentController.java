/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import dao.AppointmentDAO;
import models.Appointment;
import java.util.List;

/**
 *
 * @author Suhil Jugroop
 */
public class AppointmentController {
    private AppointmentDAO appointmentDAO;

    public AppointmentController() {
        appointmentDAO = new AppointmentDAO();
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
