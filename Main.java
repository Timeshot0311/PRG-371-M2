/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibrarySystems;

import LibrarySystems.controllers.CounselorControllers;
import LibrarySystems.models.Appointment;
import LibrarySystems.models.Feedback;
import LibrarySystems.models.Counselor;

import java.util.List;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        // Initialize controllers
        try (Scanner scanner = new Scanner(System.in)) {
            // Initialize controllers
            AppointmentController appointmentController = new AppointmentController();
            FeedbackController feedbackController = new FeedbackController();
            CounselorControllers counselorController = new CounselorControllers();
            
            boolean running = true;
            
            while (running) {
                System.out.println("\n=== Main Menu ===");
                System.out.println("1. Manage Appointments");
                System.out.println("2. Manage Feedback");
                System.out.println("3. Manage Counselors");
                System.out.println("4. Exit");
                
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1 -> appointmentMenu(scanner, appointmentController);
                    case 2 -> feedbackMenu(scanner, feedbackController);
                    case 3 -> counselorMenu(scanner, counselorController);
                    case 4 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            }
            
            System.out.println("Thank you for using the Student Wellness System!");
        }
    }

    // === Appointment Menu ===
    public static void appointmentMenu(Scanner scanner, AppointmentController controller) {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Appointments Menu ---");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("5. Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time (HH:MM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    controller.addAppointment(date, time, studentName);
                }
                case 2 -> {
                    List<Appointment> appointments = controller.getAllAppointments();
                    for (Appointment a : appointments) {
                        System.out.println("ID: " + a.getId() + ", Date: " + a.getDate() +
                                ", Time: " + a.getTime() + ", Student: " + a.getStudentName());
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter new date: ");
                    String newDate = scanner.nextLine();
                    System.out.print("Enter new time: ");
                    String newTime = scanner.nextLine();
                    System.out.print("Enter new student name: ");
                    String newStudentName = scanner.nextLine();
                    controller.updateAppointment(updateId, newDate, newTime, newStudentName);
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt(); scanner.nextLine();
                    controller.deleteAppointment(deleteId);
                }
                case 5 -> loop = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // === Feedback Menu ===
    public static void feedbackMenu(Scanner scanner, FeedbackController controller) {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Feedback Menu ---");
            System.out.println("1. Submit Feedback");
            System.out.println("2. View Feedback");
            System.out.println("3. Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter feedback message: ");
                    String message = scanner.nextLine();
                    controller.addFeedback(name, message);
                }
                case 2 -> {
                    List<Feedback> feedbackList = controller.getAllFeedback();
                    for (Feedback f : feedbackList) {
                        System.out.println("ID: " + f.getId() + ", Student: " + f.getStudentName() +
                                ", Message: " + f.getMessage());
                    }
                }
                case 3 -> loop = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // === Counselors Menu ===
    public static void counselorMenu(Scanner scanner, CounselorControllers controller) {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Counselors Menu ---");
            System.out.println("1. Add Counselor");
            System.out.println("2. View All Counselors");
            System.out.println("3. Update Counselor");
            System.out.println("4. Delete Counselor");
            System.out.println("5. Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    controller.addCounselor(name, department, email);
                }
                case 2 -> {
                    List<Counselor> counselors = controller.getAllCounselors();
                    for (Counselor c : counselors) {
                        System.out.println("ID: " + c.getId() + ", Name: " + c.getName() +
                                ", Dept: " + c.getDepartment() + ", Email: " + c.getEmail());
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new department: ");
                    String newDept = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    controller.updateCounselor(updateId, newName, newDept, newEmail);
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt(); scanner.nextLine();
                    controller.deleteCounselor(deleteId);
                }
                case 5 -> loop = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
