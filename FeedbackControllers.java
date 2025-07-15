/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystems.controllers;
import LibrarySystems.dao.FeedbackDAO;
import LibrarySystems.models.Feedback;
import java.util.List;


public class FeedbackControllers {
    private final FeedbackDAO feedbackDAO;

    public FeedbackControllers() {
        feedbackDAO = new FeedbackDAO();
    }

    public void addFeedback(String studentName, String message) {
        Feedback feedback = new Feedback(studentName, message);
        feedbackDAO.addFeedback(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackDAO.getAllFeedback();
    }

    //Update feedback
    public void updateFeedback(int id, String name, String message) {
        Feedback feedback = new Feedback(id, name, message);
        feedbackDAO.updateFeedback(feedback);
    }

    //Delete feedback
    public void deleteFeedback(int id) {
        feedbackDAO.deleteFeedback(id);
    }
}
