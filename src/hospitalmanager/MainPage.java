package hospitalmanager;

import com.bulenkov.darcula.DarculaLaf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.table.DefaultTableModel;

public class MainPage extends javax.swing.JFrame {
    
    static Connection conn;

    public MainPage() {
        initComponents();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        mainTable.setRowSelectionAllowed(true);
        mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        getConnection();
        setup();
    }
    
    private void getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/joshi79570/Desktop/IB/CS/SQL/Project1.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setup() {
        DefaultTableModel dtm = (DefaultTableModel) mainTable.getModel();
        dtm.setRowCount(0);
        
        try {
            Statement state = conn.createStatement();
            ResultSet data = state.executeQuery("SELECT * FROM appointments");
            ArrayList<ArrayList> data_new = RSToArray(data);
            
            for (int i = 0; i < data_new.size(); i++) {
                String patient_id = (String) data_new.get(i).get(1);
                state = conn.createStatement();
                ArrayList<ArrayList> patient_data = RSToArray(state.executeQuery("SELECT name FROM patients WHERE patient_id = " + patient_id));
                String patient_name = (String) patient_data.get(0).get(0);
                
                data_new.get(i).set(1, patient_name);
            }
            
            for (int i = 0; i < data_new.size(); i++) {
                String doctor_id = (String) data_new.get(i).get(2);
                state = conn.createStatement();
                ArrayList<ArrayList> doctors_data = RSToArray(state.executeQuery("SELECT name FROM doctors WHERE doctor_id = " + doctor_id));
                String doctors_name = (String) doctors_data.get(0).get(0);
                
                data_new.get(i).set(2, doctors_name);
            }
            
            for (ArrayList a: data_new) {
                dtm.addRow(a.toArray());
            }
            
            mainTable.setModel(dtm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList RSToArray(ResultSet rsData) {
        try {
            ArrayList<ArrayList> AL = new ArrayList<ArrayList>();
            while (rsData.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                for (int i = 1; i <= rsData.getMetaData().getColumnCount(); i++) {
                    temp.add(String.valueOf(rsData.getObject(i)));
                }
                AL.add(temp);
            }
            return AL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        patientsButton = new javax.swing.JButton();
        doctorsButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hospital Manager");

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appotinment ID", "Patient", "Doctor", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mainTable);

        patientsButton.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        patientsButton.setText("Add Patient");
        patientsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientsButtonActionPerformed(evt);
            }
        });

        doctorsButton.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        doctorsButton.setText("Add Doctor");
        doctorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorsButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(patientsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doctorsButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {doctorsButton, patientsButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, deleteButton, editButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientsButton)
                    .addComponent(doctorsButton)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = mainTable.getSelectedRow();
        if (row != -1) {
            try {
                Statement state = conn.createStatement();
                ArrayList<ArrayList> data = RSToArray(state.executeQuery("SELECT * FROM appointments"));
                int id = Integer.valueOf((String) data.get(row).get(0));
                state = conn.createStatement();
                state.executeUpdate("DELETE FROM appointments WHERE appointment_id = " + id);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        else{
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame,
             "Please select an appointmnet to delete",
             "Nothing's Selected!",
        JOptionPane.ERROR_MESSAGE);
        }
        
        setup();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            ChangeData cd = new ChangeData(this, conn);
            cd.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = mainTable.getSelectedRow();
        if (row != -1) {
            try {
                Statement state = conn.createStatement();
                ArrayList<ArrayList> data = RSToArray(state.executeQuery("SELECT * FROM appointments"));
                ArrayList<String> data_new = data.get(row);
                
                ChangeData cd = new ChangeData(this, conn, data_new);
                cd.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame,
             "Please select an appointmnet to edit",
             "Nothing's Selected!",
        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void patientsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientsButtonActionPerformed
        NewPatientDoctor npd = new NewPatientDoctor(this, conn, true);
        npd.setVisible(true);
    }//GEN-LAST:event_patientsButtonActionPerformed

    private void doctorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorsButtonActionPerformed
        NewPatientDoctor npd = new NewPatientDoctor(this, conn, false);
        npd.setVisible(true);
    }//GEN-LAST:event_doctorsButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton doctorsButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mainTable;
    private javax.swing.JButton patientsButton;
    // End of variables declaration//GEN-END:variables
}
