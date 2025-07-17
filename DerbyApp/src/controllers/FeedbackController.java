package controllers;

import dao.FeedbackDAO;
import models.Feedback;
import database.DBConnection;
import java.util.List;

public class FeedbackController {

    private final FeedbackDAO feedbackDAO;

    public FeedbackController(DBConnection db) {
        this.feedbackDAO = new FeedbackDAO(db);
    }

    public void addFeedback(String studentName, int rating, String comments) {
        Feedback feedback = new Feedback(studentName, rating, comments);
        feedbackDAO.addFeedback(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackDAO.getAllFeedback();
    }

    public void updateFeedback(int id, String studentName, int rating, String comments) {
        Feedback feedback = new Feedback(id, studentName, rating, comments);
        feedbackDAO.updateFeedback(feedback);
    }

    public void deleteFeedback(int id) {
        feedbackDAO.deleteFeedback(id);
    }
}
