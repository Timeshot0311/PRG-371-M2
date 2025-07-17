/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package derbyapp;

import controllers.AppointmentController;
import controllers.CounselorController;
import controllers.FeedbackController;
import dao.AppointmentDAO;
import dao.CounselorDAO;
import dao.FeedbackDAO;
import database.DBConnection;
import models.Appointment;
import models.Counselor;
import models.Feedback;

import java.awt.CardLayout;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DoggyDigital
 */
public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    
    private final DBConnection db;
private final AppointmentController appointmentController;
private final CounselorController counselorController;
private final FeedbackController feedbackController;

private void loadAppointmentsTable() {
    List<Appointment> appointments = appointmentController.getAllAppointments();
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // clear table
    for (Appointment appt : appointments) {
        model.addRow(new Object[]{
            appt.getId(),
            appt.getStudentName(),
            appt.getCounselorName(),
            appt.getDate(),
            appt.getTime(),
            appt.getStatus()
        });
    }
}

private void loadFeedbackTable() {
    List<Feedback> feedbackList = feedbackController.getAllFeedback();
    DefaultTableModel model = (DefaultTableModel) tableFeedback.getModel();
    model.setRowCount(0); // clear table

    for (Feedback f : feedbackList) {
        model.addRow(new Object[]{
            f.getId(),
            f.getStudentName(),
            f.getRating(),
            f.getComments()
        });
    }
}

private void clearFeedbackFields() {
    txtStudentFeedback.setText("");
    comboRating.setSelectedIndex(0);
    txtComments.setText("");
}

private boolean validateFeedbackForm() {
    if (txtStudentFeedback.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Student name is required.");
        return false;
    }
    if (comboRating.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(this, "Please select a rating.");
        return false;
    }
    if (txtComments.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Comments are required.");
        return false;
    }
    return true;
}



private void clearAppointmentFields() {
    txtStudentName.setText("");
    comboCounselor.setSelectedIndex(0);
    txtDate.setText("");
    txtTime.setText("");
    comboStatus.setSelectedIndex(0);
}

private boolean validateAppointmentForm() {
    if (txtStudentName.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Student name is required.");
        return false;
    }
    if (comboCounselor.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(this, "Please select a counselor.");
        return false;
    }
    if (txtDate.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Date is required.");
        return false;
    }
    if (txtTime.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Time is required.");
        return false;
    }
    if (comboStatus.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(this, "Please select a status.");
        return false;
    }
    return true;
}


private void clearCounselorFields() {
    txtCounselorName.setText("");
    txtSpecialization.setText("");
    comboAvailability.setSelectedIndex(0);
    txtEmail.setText("");
}

private boolean validateCounselorForm() {
    if (txtCounselorName.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Counselor name is required.");
        return false;
    }
    if (txtSpecialization.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Specialization is required.");
        return false;
    }
    if (txtEmail.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Email is required.");
        return false;
    }
    // Basic email validation (optional)
    
    return true;
}


private void loadCounselorsTable() {
    List<Counselor> counselors = counselorController.getAllCounselors();
    DefaultTableModel model = (DefaultTableModel) tableCounselors.getModel();
    model.setRowCount(0); // Clear
    for (Counselor c : counselors) {
        model.addRow(new Object[]{
            c.getId(),
            c.getName(),
            c.getSpecialization(),
            
            c.getEmail()
        });
    }
}




    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        
        setIconImage(new ImageIcon(getClass().getResource("/resources/bc_logo2.png")).getImage());
        
        // DB + Controller setup
    db = new DBConnection();
    appointmentController = new AppointmentController(db);
    counselorController = new CounselorController(db);
    feedbackController = new FeedbackController(db);

        
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
contentPanel.add(DashboardPanel, "dashboard");
contentPanel.add(AppointmentsPanel, "appointments");
contentPanel.add(CounselorPanel, "counselors");
contentPanel.add(FeedbackPanel, "feedback");

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnAppointments = new javax.swing.JButton();
        btnCounselors = new javax.swing.JButton();
        btnFeedback = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        AppointmentsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        comboCounselor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnViewAllAppointments = new javax.swing.JButton();
        CounselorPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCounselorName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSpecialization = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboAvailability = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCounselors = new javax.swing.JTable();
        btnAdd2 = new javax.swing.JButton();
        btnUpdate2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnViewCounselors = new javax.swing.JButton();
        FeedbackPanel = new javax.swing.JPanel();
        txtStudentFeedback = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboRating = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComments = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFeedback = new javax.swing.JTable();
        txtAdd3 = new javax.swing.JButton();
        txtUpdate3 = new javax.swing.JButton();
        txtDelete3 = new javax.swing.JButton();
        btnViewFeedback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));

        panelSidebar.setBackground(new java.awt.Color(0, 204, 204));
        panelSidebar.setPreferredSize(new java.awt.Dimension(200, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/download__3_-removebg-preview.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        btnDashboard.setText("Welcome");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnAppointments.setText("Appointments");
        btnAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentsActionPerformed(evt);
            }
        });

        btnCounselors.setText("Counselors");
        btnCounselors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCounselorsActionPerformed(evt);
            }
        });

        btnFeedback.setText("Feedback");
        btnFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedbackActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExit)
                            .addComponent(btnFeedback)
                            .addComponent(btnCounselors)
                            .addComponent(btnAppointments)
                            .addComponent(btnDashboard)))
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDashboard)
                .addGap(18, 18, 18)
                .addComponent(btnAppointments)
                .addGap(18, 18, 18)
                .addComponent(btnCounselors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFeedback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addGap(0, 3513, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(0, 204, 204));
        contentPanel.setPreferredSize(new java.awt.Dimension(924, 750));
        contentPanel.setLayout(new java.awt.CardLayout());

        DashboardPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("WELCOME TO BC STUDENT WELLNESS ");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/download__3_-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.add(DashboardPanel, "card2");

        AppointmentsPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setText("Student Name");

        jLabel4.setText("Counselor");

        comboCounselor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alisha", "Themba", "Suhil", "Duan" }));

        jLabel5.setText("Date");

        jLabel6.setText("Time");

        jLabel7.setText("Status");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Booked", "Rescheduled", "Cancelled", "Completed" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student", "Counselor", "Date", "Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnViewAllAppointments.setText("View All Appointments");
        btnViewAllAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllAppointmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AppointmentsPanelLayout = new javax.swing.GroupLayout(AppointmentsPanel);
        AppointmentsPanel.setLayout(AppointmentsPanelLayout);
        AppointmentsPanelLayout.setHorizontalGroup(
            AppointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentsPanelLayout.createSequentialGroup()
                .addGroup(AppointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AppointmentsPanelLayout.createSequentialGroup()
                        .addGroup(AppointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AppointmentsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(AppointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AppointmentsPanelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewAllAppointments)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        AppointmentsPanelLayout.setVerticalGroup(
            AppointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AppointmentsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AppointmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnViewAllAppointments))
                .addGap(0, 3288, Short.MAX_VALUE))
        );

        contentPanel.add(AppointmentsPanel, "card3");

        CounselorPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel8.setText("Name");

        jLabel9.setText("Specialization");

        jLabel10.setText("Availability");

        comboAvailability.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailble" }));

        tableCounselors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Specialization", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCounselors);

        btnAdd2.setText("Add");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnUpdate2.setText("Update");
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });

        btnDelete2.setText("Delete");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        jLabel15.setText("Availability");

        btnViewCounselors.setText("View All Counselors");
        btnViewCounselors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCounselorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CounselorPanelLayout = new javax.swing.GroupLayout(CounselorPanel);
        CounselorPanel.setLayout(CounselorPanelLayout);
        CounselorPanelLayout.setHorizontalGroup(
            CounselorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CounselorPanelLayout.createSequentialGroup()
                .addGroup(CounselorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CounselorPanelLayout.createSequentialGroup()
                        .addGroup(CounselorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CounselorPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(CounselorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCounselorName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)))
                            .addComponent(comboAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CounselorPanelLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnAdd2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewCounselors)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        CounselorPanelLayout.setVerticalGroup(
            CounselorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CounselorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CounselorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CounselorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCounselorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CounselorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd2)
                    .addComponent(btnUpdate2)
                    .addComponent(btnDelete2)
                    .addComponent(btnViewCounselors))
                .addContainerGap(3288, Short.MAX_VALUE))
        );

        contentPanel.add(CounselorPanel, "card4");

        FeedbackPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel11.setText("Student Name");

        jLabel12.setText("Rating");

        comboRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));

        jLabel13.setText("Comments");

        txtComments.setColumns(20);
        txtComments.setRows(5);
        jScrollPane3.setViewportView(txtComments);

        tableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Student ", "Rating", "Comments"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFeedbackMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableFeedback);

        txtAdd3.setText("Submit");
        txtAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdd3ActionPerformed(evt);
            }
        });

        txtUpdate3.setText("Update");
        txtUpdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdate3ActionPerformed(evt);
            }
        });

        txtDelete3.setText("Delete");
        txtDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDelete3ActionPerformed(evt);
            }
        });

        btnViewFeedback.setText("View Feedback");
        btnViewFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FeedbackPanelLayout = new javax.swing.GroupLayout(FeedbackPanel);
        FeedbackPanel.setLayout(FeedbackPanelLayout);
        FeedbackPanelLayout.setHorizontalGroup(
            FeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(FeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FeedbackPanelLayout.createSequentialGroup()
                        .addComponent(txtAdd3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUpdate3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDelete3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewFeedback)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE))
                .addContainerGap())
        );
        FeedbackPanelLayout.setVerticalGroup(
            FeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FeedbackPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStudentFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdd3)
                    .addComponent(txtUpdate3)
                    .addComponent(txtDelete3)
                    .addComponent(btnViewFeedback))
                .addContainerGap(3288, Short.MAX_VALUE))
        );

        contentPanel.add(FeedbackPanel, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 3836, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGap(92, 92, 92))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
    cardLayout.show(contentPanel, "dashboard");
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentsActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
    cardLayout.show(contentPanel, "appointments");
    }//GEN-LAST:event_btnAppointmentsActionPerformed

    private void btnCounselorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCounselorsActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
    cardLayout.show(contentPanel, "counselors");
    }//GEN-LAST:event_btnCounselorsActionPerformed

    private void btnFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedbackActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
    cardLayout.show(contentPanel, "feedback");
    }//GEN-LAST:event_btnFeedbackActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (!validateAppointmentForm()) return;
        String studentName = txtStudentName.getText().trim();
    String counselor = (String) comboCounselor.getSelectedItem();
    String date = txtDate.getText().trim();
    String time = txtTime.getText().trim();
    String status = (String) comboStatus.getSelectedItem();

    if (studentName.isEmpty() || counselor == null || date.isEmpty() || time.isEmpty() || status == null) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    appointmentController.addAppointment(studentName, counselor, date, time, status);
    JOptionPane.showMessageDialog(this, "Appointment added successfully.");
    loadAppointmentsTable();
    clearAppointmentFields();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         if (!validateAppointmentForm()) return;
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select an appointment to update.");
        return;
    }

    int id = (int) jTable1.getValueAt(selectedRow, 0);
    
    String studentName = txtStudentName.getText().trim();
    String counselor = (String) comboCounselor.getSelectedItem();
    String date = txtDate.getText().trim();
    String time = txtTime.getText().trim();
    String status = (String) comboStatus.getSelectedItem();

    

    appointmentController.updateAppointment(id, studentName, counselor, date, time, status);
    JOptionPane.showMessageDialog(this, "Appointment updated successfully.");
    loadAppointmentsTable();
    clearAppointmentFields();
   

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select an appointment to delete.");
        return;
    }

    int id = (int) jTable1.getValueAt(selectedRow, 0);

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this appointment?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        appointmentController.deleteAppointment(id);
        JOptionPane.showMessageDialog(this, "Appointment deleted.");
        loadAppointmentsTable();
        clearAppointmentFields();
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
        if (!validateCounselorForm()) return;
        String name = txtCounselorName.getText().trim();
    String specialization = txtSpecialization.getText().trim();
    String availability = (String) comboAvailability.getSelectedItem();
    String email = txtEmail.getText().trim();

    if (name.isEmpty() || specialization.isEmpty() || availability == null || email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    counselorController.addCounselor(name, specialization, email);
    JOptionPane.showMessageDialog(this, "Counselor added.");
    loadCounselorsTable();
    clearCounselorFields();
    

    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        // TODO add your handling code here:
        if (!validateCounselorForm()) return;
        int selectedRow = tableCounselors.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Select a counselor to update.");
        return;
    }

    int id = (int) tableCounselors.getValueAt(selectedRow, 0);

    String name = txtCounselorName.getText().trim();
    String specialization = txtSpecialization.getText().trim();
    String availability = (String) comboAvailability.getSelectedItem();
    String email = txtEmail.getText().trim();

    if (name.isEmpty() || specialization.isEmpty() || availability == null || email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    counselorController.updateCounselor(id, name, specialization, email);
    JOptionPane.showMessageDialog(this, "Counselor updated.");
    loadCounselorsTable();
    clearCounselorFields();
    

    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableCounselors.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Select a counselor to delete.");
        return;
    }

    int id = (int) tableCounselors.getValueAt(selectedRow, 0);

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        counselorController.deleteCounselor(id);
        JOptionPane.showMessageDialog(this, "Counselor deleted.");
        loadCounselorsTable();
        clearCounselorFields();
    }

    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void txtAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdd3ActionPerformed
        // TODO add your handling code here:
        if (!validateFeedbackForm()) return;
        String studentName = txtStudentFeedback.getText().trim();
    int rating = Integer.parseInt((String) comboRating.getSelectedItem()); // assume Integer items
    String comments = txtComments.getText().trim();

    if (studentName.isEmpty() || comments.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    feedbackController.addFeedback(studentName, rating, comments);
    JOptionPane.showMessageDialog(this, "Feedback submitted.");
    loadFeedbackTable();
    clearFeedbackFields();
    

    }//GEN-LAST:event_txtAdd3ActionPerformed

    
    
    private void txtUpdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdate3ActionPerformed
        // TODO add your handling code here:
        if (!validateFeedbackForm()) return;
        int selectedRow = tableFeedback.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a feedback entry to update.");
        return;
    }

    int id = (int) tableFeedback.getValueAt(selectedRow, 0);
    String studentName = txtStudentFeedback.getText().trim();
    int rating = Integer.parseInt((String) comboRating.getSelectedItem());
    String comments = txtComments.getText().trim();

    if (studentName.isEmpty() || comments.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    feedbackController.updateFeedback(id, studentName, rating, comments);
    JOptionPane.showMessageDialog(this, "Feedback updated.");
    loadFeedbackTable();
    clearFeedbackFields();
    

    }//GEN-LAST:event_txtUpdate3ActionPerformed

    private void txtDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDelete3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableFeedback.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Select a feedback entry to delete.");
        return;
    }

    int id = (int) tableFeedback.getValueAt(selectedRow, 0);

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this feedback?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        feedbackController.deleteFeedback(id);
        JOptionPane.showMessageDialog(this, "Feedback deleted.");
        loadFeedbackTable();
        clearFeedbackFields();
    }
    }//GEN-LAST:event_txtDelete3ActionPerformed

    private void tableFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFeedbackMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tableFeedbackMouseClicked

    private void btnViewFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFeedbackActionPerformed
        // TODO add your handling code here:
        loadFeedbackTable();

    CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
    cardLayout.show(contentPanel, "feedback");
    }//GEN-LAST:event_btnViewFeedbackActionPerformed

    private void btnViewCounselorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCounselorsActionPerformed
        // TODO add your handling code here:
        loadCounselorsTable();
        

    CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
    cardLayout.show(contentPanel, "counselors");
    }//GEN-LAST:event_btnViewCounselorsActionPerformed

    private void btnViewAllAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllAppointmentsActionPerformed
        // TODO add your handling code here:
        loadAppointmentsTable();

    // If needed, switch to the panel
    CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
    cardLayout.show(contentPanel, "appointments");
    }//GEN-LAST:event_btnViewAllAppointmentsActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppointmentsPanel;
    private javax.swing.JPanel CounselorPanel;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JPanel FeedbackPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAppointments;
    private javax.swing.JButton btnCounselors;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFeedback;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.JButton btnViewAllAppointments;
    private javax.swing.JButton btnViewCounselors;
    private javax.swing.JButton btnViewFeedback;
    private javax.swing.JComboBox<String> comboAvailability;
    private javax.swing.JComboBox<String> comboCounselor;
    private javax.swing.JComboBox<String> comboRating;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JTable tableCounselors;
    private javax.swing.JTable tableFeedback;
    private javax.swing.JButton txtAdd3;
    private javax.swing.JTextArea txtComments;
    private javax.swing.JTextField txtCounselorName;
    private javax.swing.JTextField txtDate;
    private javax.swing.JButton txtDelete3;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSpecialization;
    private javax.swing.JTextField txtStudentFeedback;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JTextField txtTime;
    private javax.swing.JButton txtUpdate3;
    // End of variables declaration//GEN-END:variables
}
