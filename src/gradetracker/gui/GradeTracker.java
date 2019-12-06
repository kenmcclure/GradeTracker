package gradetracker.gui;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import gradetracker.logic.*;
import java.awt.Dialog;
import javax.swing.JFrame;

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

    //List subjectsTOBIND=Global.me.getSubject("Comp Sci").assessments;
    /**
     * Creates new form GradeTracker
     */


    

    public GradeTracker() {
        initComponents();

        setLocationRelativeTo(null);  //this will move my form to the middle
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // load the student's subjects into the list
        Global.loadFromFile();
        updateListOfSubjects();

        //disable delete button as no subject is selected
        btnRemoveSubject.setEnabled(false);

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
        for (int i = 0; i < Global.me.subjects.size(); i++) {

            //for a table you have to add each row as an array of Objects,
            //ie each column is an object
            subjectTableData.addRow(new Object[]{Global.me.subjects.get(i).name,Global.me.subjects.get(i).teacher,Global.me.subjects.get(i).currentLevel});

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
        btnRemoveSubject = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSubjects = new javax.swing.JTable();
        lblWS = new javax.swing.JLabel();
        lblOL1 = new javax.swing.JLabel();
        lblBS = new javax.swing.JLabel();
        lblBest = new javax.swing.JLabel();
        lblWorst1 = new javax.swing.JLabel();
        lblOverall = new javax.swing.JLabel();
        Details = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddSubject.setText("Add");
        btnAddSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        btnRemoveSubject.setText("Remove");
        btnRemoveSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 79, -1));

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
        tblSubjects.setShowGrid(true);
        tblSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubjectsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSubjects);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 417));

        lblWS.setText("Worst Subject:");
        getContentPane().add(lblWS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        lblOL1.setText("Overall Level:");
        getContentPane().add(lblOL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        lblBS.setText("Best Subject:");
        getContentPane().add(lblBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        lblBest.setText("_______________");
        getContentPane().add(lblBest, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        lblWorst1.setText("_______________");
        getContentPane().add(lblWorst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        lblOverall.setText("_______________");
        getContentPane().add(lblOverall, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        Details.setText("Open...");
        Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailsActionPerformed(evt);
            }
        });
        getContentPane().add(Details, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSubjectActionPerformed
        // TODO add your handling code here:
        AddSubject as = new AddSubject();
        as.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        as.setVisible(true);

        //update the screen
        updateListOfSubjects();
        Global.debug("I finished adding");


    }//GEN-LAST:event_btnAddSubjectActionPerformed

    private void btnRemoveSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSubjectActionPerformed

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

        }
        //

    }//GEN-LAST:event_btnRemoveSubjectActionPerformed

    private void tblSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubjectsMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            SubjectForm sf = new SubjectForm();
            sf.setVisible(true);
        } else {
            //just a normal selection - make sure delete button is enabled
            btnRemoveSubject.setEnabled(true);
        }

    }//GEN-LAST:event_tblSubjectsMouseClicked

    private void DetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailsActionPerformed
        // TODO add your handling code here:
        //SubjectForm sf = new SubjectForm();
        //sf.setVisible(true);
        //EditSubject
        EditSubject es = new EditSubject(this,true);
        es.setVisible(true);
    }//GEN-LAST:event_DetailsActionPerformed

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
    private javax.swing.JButton Details;
    private javax.swing.JButton btnAddSubject;
    private javax.swing.JButton btnRemoveSubject;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBS;
    private javax.swing.JLabel lblBest;
    private javax.swing.JLabel lblOL1;
    private javax.swing.JLabel lblOverall;
    private javax.swing.JLabel lblWS;
    private javax.swing.JLabel lblWorst1;
    private javax.swing.JTable tblSubjects;
    // End of variables declaration//GEN-END:variables
}
