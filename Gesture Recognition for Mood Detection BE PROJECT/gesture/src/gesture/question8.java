/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gesture;

import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class question8 extends javax.swing.JFrame {

    static int q8;
    
    /**
     * Creates new form question1
     */
    public question8() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        a0 = new javax.swing.JRadioButton();
        a1 = new javax.swing.JRadioButton();
        a2 = new javax.swing.JRadioButton();
        a3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        a4 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(695, 580));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Question 8");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(228, 18, 184, 77);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Do you have a feeling of AGITATION inside you?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(27, 106, 481, 56);

        buttonGroup1.add(a0);
        a0.setText("None");
        a0.setOpaque(false);
        getContentPane().add(a0);
        a0.setBounds(27, 164, 280, 23);

        buttonGroup1.add(a1);
        a1.setText("Fidgetiness");
        a1.setOpaque(false);
        getContentPane().add(a1);
        a1.setBounds(27, 205, 260, 23);

        buttonGroup1.add(a2);
        a2.setText("Playing with hands, hair, etc.");
        a2.setOpaque(false);
        getContentPane().add(a2);
        a2.setBounds(27, 246, 300, 23);

        buttonGroup1.add(a3);
        a3.setText("Moving about, can’t sit still");
        a3.setOpaque(false);
        getContentPane().add(a3);
        a3.setBounds(27, 287, 440, 23);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Next-Button.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 440, 190, 60);

        buttonGroup1.add(a4);
        a4.setText("Hand wringing, nail biting, hair-pulling, biting of lips ");
        a4.setOpaque(false);
        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });
        getContentPane().add(a4);
        a4.setBounds(27, 328, 470, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/ques bk.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 760, 547);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

try
{
    

int ans=0;
  
if (a0.isSelected()){
  ans=0;
}
else if (a1.isSelected()){
 ans=1;
}
else if (a2.isSelected()){
 ans=2;
}
else if (a3.isSelected()){
 ans=3;
}
else if (a4.isSelected()){
 ans=4;
}

q8=ans;

question9 a = new question9();
a.setVisible(true);
this.dispose();

}
catch(Exception e)
{
           JOptionPane.showMessageDialog(null,"Answer the question by selecting an option please.");        

}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a4ActionPerformed

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
            java.util.logging.Logger.getLogger(question8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(question8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(question8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(question8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new question8().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton a0;
    private javax.swing.JRadioButton a1;
    private javax.swing.JRadioButton a2;
    private javax.swing.JRadioButton a3;
    private javax.swing.JRadioButton a4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
