/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author Snehalreet
 */
public class frameworkConfiguration extends javax.swing.JFrame {

    /**
     * Creates new form frameworkConfiguration
     */
    public frameworkConfiguration() {
        initComponents();
        
        vanResponseDelayTextField.setText(String.valueOf(landing.vanResponseDelay));                //displaying in minutes
        dustbinStatusDelayTextField.setText(String.valueOf(landing.dustbinStatusDelay));            //displaying in minutes
        
        this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //System.out.println("WindowClosingDemo.windowClosing");
                    landing.dashboard.setVisible(true);
                    //landing.fg.setVisible(false);
                    dispose();
                    }
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        dustbinStatusDelayTextField = new javax.swing.JTextField();
        vanResponseDelayTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        notificationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);

        jPanel2.setBackground(new java.awt.Color(17, 138, 178));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 92));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(7, 59, 76));
        jTextField1.setText("Dustbin Status Delay:");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(7, 59, 76));
        jTextField2.setText("Van Response Delay:");
        jTextField2.setBorder(null);

        jTextField3.setEditable(false);
        jTextField3.setBackground(java.awt.Color.white);
        jTextField3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(7, 59, 76));
        jTextField3.setText("Framework Configuration");
        jTextField3.setBorder(null);

        dustbinStatusDelayTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        vanResponseDelayTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        vanResponseDelayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vanResponseDelayTextFieldActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(26, 83, 92));
        cancelButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(249, 251, 242));
        cancelButton.setText("CANCEL");
        cancelButton.setBorder(null);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.setFocusPainted(false);
        cancelButton.setOpaque(true);
        cancelButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cancelButtonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cancelButtonFocusLost(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(26, 83, 92));
        saveButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(249, 251, 242));
        saveButton.setText("SAVE CHANGES");
        saveButton.setBorder(null);
        saveButton.setContentAreaFilled(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setFocusPainted(false);
        saveButton.setOpaque(true);
        saveButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                saveButtonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                saveButtonFocusLost(evt);
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 57, 70));

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(230, 57, 70));

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(230, 57, 70));

        notificationLabel.setBackground(java.awt.Color.white);
        notificationLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        notificationLabel.setForeground(new java.awt.Color(0, 221, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(363, 363, 363))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(283, 283, 283))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(vanResponseDelayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(dustbinStatusDelayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(notificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vanResponseDelayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dustbinStatusDelayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(notificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vanResponseDelayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanResponseDelayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vanResponseDelayTextFieldActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        vanResponseDelayTextField.setText("");
        dustbinStatusDelayTextField.setText("");
        jLabel5.setText(" ");
        jLabel3.setText(" ");
        jLabel4.setText(" ");
        notificationLabel.setText(" ");
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        int num1,num2;
        boolean responseDelayValid = false, statusDelayValid = false;
        jLabel5.setText(" ");
        notificationLabel.setText(" ");
        jLabel3.setText(" ");
        jLabel4.setText(" ");

        try {
        num1 = Integer.parseInt(vanResponseDelayTextField.getText());           //accepting in minutes
        if(num1 > 40)
        jLabel3.setText("Van response delay cannot be greater than 40");
        else if(num1 < 0)
        jLabel3.setText("Van response delay cannot be negative");
        else{
           jLabel3.setText(" ");
           responseDelayValid = true;
        }

    } catch (NumberFormatException e) {
        jLabel5.setText("Response Delay must be an integer");
        jLabel3.setText(" ");
        responseDelayValid = false;

    }
        
        try {
        num2 = Integer.parseInt(dustbinStatusDelayTextField.getText());         //accepting in minutes
        if(num2 > 40)
        jLabel4.setText("Dustbin response delay cannot be greater than 40");
        else if(num2 < 0)
        jLabel4.setText("Dustbin response delay cannot be negative");
        else{
           jLabel4.setText(" ");
           statusDelayValid = true;
        }

    } catch (NumberFormatException f) {
        jLabel5.setText("Response Delay must be an integer");
        jLabel4.setText(" ");
        statusDelayValid = false;

    }
        
        if(responseDelayValid && statusDelayValid){
            landing.vanResponseDelay = Integer.parseInt(vanResponseDelayTextField.getText());           //stored in minutes
            landing.dustbinStatusDelay = Integer.parseInt(dustbinStatusDelayTextField.getText());       //stored in minutes
            
            notificationLabel.setText("Changes Saved.");
            //System.out.println(landing.vanResponseDelay + " \t " + landing.dustbinStatusDelay);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelButtonFocusGained
        cancelButton.setForeground(new java.awt.Color(230, 57, 70));
    }//GEN-LAST:event_cancelButtonFocusGained

    private void cancelButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelButtonFocusLost
        cancelButton.setForeground(new java.awt.Color(249, 251, 242));
    }//GEN-LAST:event_cancelButtonFocusLost

    private void saveButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saveButtonFocusLost
        saveButton.setForeground(new java.awt.Color(249, 251, 242));
    }//GEN-LAST:event_saveButtonFocusLost

    private void saveButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saveButtonFocusGained
        saveButton.setForeground(new java.awt.Color(230, 57, 70));
    }//GEN-LAST:event_saveButtonFocusGained

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
            java.util.logging.Logger.getLogger(frameworkConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameworkConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameworkConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameworkConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frameworkConfiguration o =new frameworkConfiguration();
                o.setVisible(true);
                o.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dustbinStatusDelayTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField vanResponseDelayTextField;
    // End of variables declaration//GEN-END:variables
}
