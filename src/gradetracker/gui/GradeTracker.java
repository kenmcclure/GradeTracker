package gradetracker.gui;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import gradetracker.logic.*;
import java.awt.Dialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kenmcclure
 */
public class GradeTracker extends javax.swing.JFrame {

//Constructors
    public GradeTracker() {
        //Centre window and set up default close operation
        initComponents();
        setLocationRelativeTo(null);  //this will move my form to the middle
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // load the student's subjects into the list
        Global.loadFromFile();
        updateListOfSubjects();


    }

    private void updateListOfSubjects() {
        // Add the subjects I have loaded from file into the table on form 

        tblSubjects.removeAll();  //empty the table

        //Get a reference to the data in the table
        DefaultTableModel subjectTableData
                = (DefaultTableModel) tblSubjects.getModel();

        //make sure the tabel size is 0 rows before I start to fill it.
        subjectTableData.setRowCount(0);

        //go through my subjects and add them to the table
        for (int i = 0; i < Global.me.getSubjects().size(); i++) {

            //for a table you have to add each row as an array of Objects,
            //ie each column is an object
            subjectTableData.addRow(new Object[]{
                Global.me.getSubjects().get(i).getName(),
                Global.me.getSubjects().get(i).getTeacher(),
                Global.me.getSubjects().get(i).getCurrentLevel()});

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddSubject = new javax.swing.JButton();
        btnDeleteSubject = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSubjects = new javax.swing.JTable();
        btnEditSubject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddSubject.setText("Add");
        btnAddSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 80, -1));

        btnDeleteSubject.setText("Delete");
        btnDeleteSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 79, -1));

        tblSubjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Teacher", "Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubjects.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSubjects.setShowGrid(true);
        tblSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubjectsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSubjects);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 180));

        btnEditSubject.setText("Edit");
        btnEditSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSubjectActionPerformed
        // If the user wants to add a subject
        //then call the subject form passing in null
        DlgSubject DS = new DlgSubject(this, true, null);
        DS.setVisible(true);
        //now update the screen one the subject form is closed and control
        //is returned back to this form. To reflect any changes
        updateListOfSubjects();
    }//GEN-LAST:event_btnAddSubjectActionPerformed

    private void btnDeleteSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSubjectActionPerformed

        //Remove the selected row (if one is selected)  
        // Note: I have named my table "tblSubjects"
        //Only do something if a row of the table is selected (ie. it's not -1)
        int row = tblSubjects.getSelectedRow();
        if (row > -1) {

            //Get the Data Model from the Table to change it
            DefaultTableModel subjectTableData = (DefaultTableModel) tblSubjects.getModel();

            //remove it from our data structure in memory
            String subjectName = (String) subjectTableData.getValueAt(row, 0);
            Global.me.removeSubject(subjectName);
            Global.saveToFile(); //make changes permanent on file

            //now remove it from table that's displayed on the screen
            subjectTableData.removeRow(row);
        } else {
            //Adding new one
            //Message saying you need to select one first 
            JOptionPane.showMessageDialog(null, "Please select a subject to delete", "Delete Subject", JOptionPane.INFORMATION_MESSAGE);
        }
        //

    }//GEN-LAST:event_btnDeleteSubjectActionPerformed

    private void tblSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubjectsMouseClicked
        // If someone clicks on the table with a double click
        //then open the subject form and pass in a reference to the subject
        //they clicked on for editing

        if (evt.getClickCount() == 2) {
            //the user double clicked
            Subject selectedSubject = Global.me.getSubjects().get(tblSubjects.getSelectedRow());
            DlgSubject DS = new DlgSubject(this, true, selectedSubject);
            DS.setVisible(true);
            this.updateListOfSubjects();
        } else {
            //just a normal selection - make sure delete button is enabled
            btnDeleteSubject.setEnabled(true);
        }

    }//GEN-LAST:event_tblSubjectsMouseClicked

    private void btnEditSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSubjectActionPerformed
        //Open the subject form passing in the subject to be edited
        if (tblSubjects.getSelectedRow() > -1) {
            //only allow editing if they have selected a subject)
            Subject selectedSubject = Global.me.getSubjects().get(tblSubjects.getSelectedRow());
            DlgSubject subjectForm = new DlgSubject(this, true, selectedSubject);
            subjectForm.setVisible(true);
            //Nowupdate the data on this form one the subject form has been closed
            //and the program returns here
            this.updateListOfSubjects();
        } else {
            //Adding new one
            //Message saying you need to select one first 
            JOptionPane.showMessageDialog(null, "Please select a subject to edit", "Edit Subject", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditSubjectActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GradeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSubject;
    private javax.swing.JButton btnDeleteSubject;
    private javax.swing.JButton btnEditSubject;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSubjects;
    // End of variables declaration//GEN-END:variables
}
