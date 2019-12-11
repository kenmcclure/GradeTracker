package gradetracker.gui;


import gradetracker.logic.Assessment;
import gradetracker.logic.Subject;
import javax.swing.JDialog;
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
public class DlgSubject extends javax.swing.JDialog {

    
    Subject subject;
    
    /**
     * Creates new form EditSubject
     */
    public DlgSubject(java.awt.Frame parent, boolean modal, Subject selectedSubject) {
        super(parent, modal);
        this.subject=selectedSubject;
        initComponents();
        setLocationRelativeTo(null);  //this will move my form to the middle
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
        if (selectedSubject!=null){
            //then we are editing
            this.txtSubject.setText(subject.name);
            this.txtTeacher.setText(subject.teacher);
            this.cmbLevel.setSelectedIndex(Math.max(subject.currentLevel-1,0));
            this.chkHL.setSelected(subject.HLorNot);
            
        } else {
            //Inserting new Subject
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblGraph = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservations = new javax.swing.JTextArea();
        lblObservations = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblSubject = new javax.swing.JLabel();
        lblTeacher = new javax.swing.JLabel();
        txtSubject = new javax.swing.JTextField();
        txtTeacher = new javax.swing.JTextField();
        lblAssessmentsTitle = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAssessments = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAssessments = new javax.swing.JTable();
        lblLevel = new javax.swing.JLabel();
        chkHL = new javax.swing.JCheckBox();
        cmbLevel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGraph.setText("(The graph will go here)");
        lblGraph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 270, 180));

        txtObservations.setColumns(20);
        txtObservations.setRows(5);
        jScrollPane1.setViewportView(txtObservations);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 610, 100));

        lblObservations.setText("Observations:");
        getContentPane().add(lblObservations, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        lblSubject.setText("Subject:");
        getContentPane().add(lblSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        lblTeacher.setText("Teacher:");
        getContentPane().add(lblTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        txtSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(txtSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 330, -1));
        getContentPane().add(txtTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 330, -1));

        lblAssessmentsTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblAssessmentsTitle.setText("Subject and Assessments");
        getContentPane().add(lblAssessmentsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 530, 40));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, -1, -1));

        btnAssessments.setText("Assessments");
        btnAssessments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssessmentsActionPerformed(evt);
            }
        });
        getContentPane().add(btnAssessments, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        tblAssessments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Type", "Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblAssessments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAssessmentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAssessments);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 320, 180));

        lblLevel.setText("Current Level:");
        getContentPane().add(lblLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        chkHL.setText("HL");
        getContentPane().add(chkHL, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        cmbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        getContentPane().add(cmbLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (subject==null){
            //inserting new subject
            String name=txtSubject.getText();
            String teacher=txtTeacher.getText();
            boolean hl=chkHL.isSelected();
            int level=cmbLevel.getSelectedIndex()+1;
            Subject toInsert=new Subject(name,teacher,hl,level);       
        } else {
           //Editing existing subject
            subject.name=txtSubject.getText();
            subject.teacher=txtTeacher.getText();
            subject.HLorNot=chkHL.isSelected();
            subject.currentLevel=cmbLevel.getSelectedIndex()+1;    
        }
        Global.saveToFile();
        JOptionPane.showMessageDialog(null, "Your changes have been saved", "Save Subject", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubjectActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAssessmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssessmentsActionPerformed
        // TODO add your handling code here:
        if (tblAssessments.getSelectedRow()>=0){
        //editing existing assessment
        Assessment selectedAssessment=subject.assessments.get(tblAssessments.getSelectedRow());
        DlgAssessment DA= new DlgAssessment((JFrame)this.getParent(),true,selectedAssessment);
        DA.setVisible(true);
        } else {
        //Adding new one
        DlgAssessment DA= new DlgAssessment((JFrame)this.getParent(),true,null);
        DA.setVisible(true);  
        }
    }//GEN-LAST:event_btnAssessmentsActionPerformed

    private void tblAssessmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAssessmentsMouseClicked
        // TODO add your handling code here:
               // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            //the user double clicked
            Assessment selectedAssessment=subject.assessments.get(tblAssessments.getSelectedRow());
            DlgAssessment DA = new DlgAssessment((JFrame)this.getParent(),true,selectedAssessment);
            DA.setVisible(true);
        } else {
            //just a normal selection - make sure delete button is enabled
            btnAssessments.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_tblAssessmentsMouseClicked

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
            java.util.logging.Logger.getLogger(DlgSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgSubject dialog = new DlgSubject(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssessments;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkHL;
    private javax.swing.JComboBox<String> cmbLevel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAssessmentsTitle;
    private javax.swing.JLabel lblGraph;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblObservations;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTeacher;
    private javax.swing.JTable tblAssessments;
    private javax.swing.JTextArea txtObservations;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTeacher;
    // End of variables declaration//GEN-END:variables
}
