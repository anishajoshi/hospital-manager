package hospitalmanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class ChangeData extends javax.swing.JFrame {

    static MainPage parent;
    static Connection conn;
    
    static ArrayList<String> data_new_patients;
    static ArrayList<String> data_new_doctors;
    static ArrayList<String> data_input;
    
    static boolean ifEdit = false;
    
    public ChangeData(MainPage mp, Connection conn) throws SQLException {
        initComponents();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.parent = mp;
        this.conn = conn;
        
        setup();
    }
    
    public ChangeData(MainPage mp, Connection conn, ArrayList<String> data) throws SQLException {
        initComponents();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.parent = mp;
        this.conn = conn;
        this.data_input = data;
        
        setup();
        
        Statement state = conn.createStatement();
        ArrayList<String> data_patients = (ArrayList<String>) RSToArray(state.executeQuery("SELECT * FROM patients WHERE patient_id = " + data.get(1))).get(0);
        int x = data_new_patients.indexOf(data_patients.get(0) + ", " + data_patients.get(1));
        combo1.setSelectedIndex(x);
        
        state = conn.createStatement();
        data_patients = (ArrayList<String>) RSToArray(state.executeQuery("SELECT * FROM doctors WHERE doctor_id = " + data.get(2))).get(0);
        x = data_new_doctors.indexOf(data_patients.get(0) + ", " + data_patients.get(1));
        combo2.setSelectedIndex(x);
        
        datePanel.setText(data.get(3));
        
        ifEdit = true;
    }
    
    private void setup() throws SQLException {
        Statement state = conn.createStatement();
        ArrayList<ArrayList> data = RSToArray(state.executeQuery("SELECT * FROM patients"));
        data_new_patients = new ArrayList<String>();
        
        for (ArrayList<String> d: data) {
            data_new_patients.add(d.get(0) + ", " + d.get(1));
        }
        
        combo1.setModel(new DefaultComboBoxModel<String>(data_new_patients.toArray(new String[0])));
        
        state = conn.createStatement();
        data = RSToArray(state.executeQuery("SELECT * FROM doctors"));
        data_new_doctors = new ArrayList<String>();
        
        for (ArrayList<String> d: data) {
            data_new_doctors.add(d.get(0) + ", " + d.get(1));
        }
        
        combo2.setModel(new DefaultComboBoxModel<String>(data_new_doctors.toArray(new String[0])));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        combo2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        datePanel = new javax.swing.JTextPane();
        saveButton = new javax.swing.JButton();
        editButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel3.setText("jLabel3");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Save");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Data");

        jLabel4.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel4.setText("Patient");

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel5.setText("Doctor");

        combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel6.setText("Date");

        jScrollPane2.setViewportView(datePanel);

        saveButton.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        editButton1.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        editButton1.setText("Cancel");
        editButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(saveButton)
                .addGap(18, 18, 18)
                .addComponent(editButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editButton1, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(editButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_editButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!ifEdit) {
            int index = combo1.getSelectedIndex();
            int index2 = combo2.getSelectedIndex();

            try {
                Statement state = conn.createStatement();
                ArrayList<ArrayList> data = RSToArray(state.executeQuery("SELECT * FROM patients"));

                Integer patient_id = Integer.valueOf((String) data.get(index).get(0));

                state = conn.createStatement();
                data = RSToArray(state.executeQuery("SELECT * FROM doctors"));

                Integer doctor_id = Integer.valueOf((String) data.get(index2).get(0));

                String date = datePanel.getText();

                state = conn.createStatement();

                state.executeUpdate("INSERT INTO appointments (patient_id, doctor_id, date) VALUES (" + patient_id + ", " + doctor_id + ", '" + date + "');");

                parent.setup();
                this.dispose();

            } catch (SQLException ex) {
                Logger.getLogger(ChangeData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            int index = combo1.getSelectedIndex();
            int index2 = combo2.getSelectedIndex();

            try {
                Statement state = conn.createStatement();
                ArrayList<ArrayList> data = RSToArray(state.executeQuery("SELECT * FROM patients"));

                Integer patient_id = Integer.valueOf((String) data.get(index).get(0));

                state = conn.createStatement();
                data = RSToArray(state.executeQuery("SELECT * FROM doctors"));

                Integer doctor_id = Integer.valueOf((String) data.get(index2).get(0));

                String date = datePanel.getText();

                state = conn.createStatement();

                state.executeUpdate("UPDATE appointments SET patient_id = " + patient_id + ", doctor_id = " + doctor_id + ", date = '" + date + "' WHERE appointment_id = " + data_input.get(0));

                parent.setup();
                this.dispose();

            } catch (SQLException ex) {
                Logger.getLogger(ChangeData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JTextPane datePanel;
    private javax.swing.JButton editButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
