/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gesture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class homepage extends javax.swing.JFrame {

    Connection con=null;
Statement stmt=null;
ResultSet rs=null;

    
    static String aid,uid,uname,aname;

    int count=0;

    
    /**
     * Creates new form homepage
     */
    public homepage() {
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

        jDialog1 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        userpassword = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        adminid = new javax.swing.JTextField();
        adminpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jDialog1.setMinimumSize(new java.awt.Dimension(1100, 600));
        jDialog1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDialog1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        jLabel4.setText("<html> <center>UNAUTHORIZED USER <br> ACCESS DENIED </center> </html>");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Homepage");
        setMinimumSize(new java.awt.Dimension(1240, 635));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Homoarakhn", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MOOD INDEGO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 30, 380, 58);

        exit.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/EXiT.png"))); // NOI18N
        exit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(1123, 520, 87, 60);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User  Login");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 10, 124, 24);

        userid.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        userid.setText("sunnyb");
        userid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridActionPerformed(evt);
            }
        });
        getContentPane().add(userid);
        userid.setBounds(10, 40, 110, 24);

        userpassword.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        userpassword.setText("qwertyuiop");
        userpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(userpassword);
        userpassword.setBounds(130, 40, 110, 24);

        jButton2.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Purple_login_button.jpg"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 80, 110, 20);

        jButton3.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/RegisterHere Button.jpg"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(130, 80, 110, 20);

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrator  Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1010, 10, 169, 24);

        adminid.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        adminid.setText("rastogi");
        adminid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminidActionPerformed(evt);
            }
        });
        getContentPane().add(adminid);
        adminid.setBounds(990, 40, 110, 24);

        adminpassword.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        adminpassword.setText("qwertyuiop");
        getContentPane().add(adminpassword);
        adminpassword.setBounds(1110, 40, 110, 24);

        jButton1.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Purple_login_button.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(990, 80, 110, 20);

        jButton4.setFont(new java.awt.Font("Papyrus", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/RegisterHere Button.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(1110, 80, 110, 20);

        ad.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        ad.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ad);
        ad.setBounds(1090, 110, 130, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Home Button.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 510, 100, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/bai2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1230, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
try{

    
    boolean ans=false;
 String aa = adminid.getText();
 String  str=new String(adminpassword.getPassword());
 String ss= "select * from admin_table;";
 stmt=con.createStatement();
rs = stmt.executeQuery(ss);

String id="";
String password="";

while (rs.next()){
      id=rs.getString(7);
      password = rs.getString(8);
     if ((aa.equals(id))&&(str.equals(password))){
         ans=true;
         break;
     }

 }




if(ans ==true)
{
    
String q="select admin_id,name from admin_table where userid='"+id+"';";    
ResultSet rr=stmt.executeQuery(q);
rr.next();
aid=rr.getString(1);
aname=rr.getString(2);
System.out.println(aid+" "+aname);

Patient_info p= new Patient_info();
  p.setVisible(true);
this.dispose();
}
else
{
    
/////////////////////////////////    
    
if (count == 0 && (aa.equals(id))==false &&(str.equals(password)==false)){
    count++;
    ad.setText("2 Attempts left");
    JOptionPane.showMessageDialog(null,"please check your Password and User ID");

}
else if (count==1 && (aa.equals(id))==false && (str.equals(password)==false)){
    count++;
    ad.setText("1 Attempt left");
    JOptionPane.showMessageDialog(null,"Please check your Password and User ID!!");

}
else if (count == 2 && (aa.equals(id))==false && (str.equals(password)==false)){
 
      jDialog1.setVisible(true);
      
//////////////////////////////////////////      
}

    adminid.setText("");
    adminpassword.setText("");
}

}
catch(Exception e){
JOptionPane.showMessageDialog(null,"error in finding "+e.getMessage());
}
       
        
        
        
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void adminidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminidActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        admin_registration z= new admin_registration();
        z.setVisible(true);
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
     
        
                try{

        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
        System.out.println("connectivity done");
                }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
   
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked

        System.exit(0);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseClicked

    private void jDialog1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialog1MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        user_registration p = new user_registration();
        p.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try{
            boolean ans=false;
            String aa = userid.getText();
            String  str=new String(userpassword.getPassword());
            String ss= "select * from user_table;";
            stmt=con.createStatement();
            rs = stmt.executeQuery(ss);

            String id="";
            String password;

            while (rs.next()){
                id=rs.getString(8);
                password = rs.getString(9);
                if ((aa.equals(id))&&(str.equals(password))){
                    ans=true;
                    break;
                }

            }
            if(ans==true)
            {

                /////////////////////////
                String q="select u_id,name from user_table where userid='"+id+"';";
                ResultSet rr=stmt.executeQuery(q);
                rr.next();
                uid=rr.getString(1);
                uname=rr.getString(2);
                System.out.println(uid+" "+uname);
                ///////////////////////

                analysis ab= new analysis();
                ab.setVisible(true);
                this.dispose();

            }
            else
            {
                userid.setText("");
                userpassword.setText("");
                JOptionPane.showMessageDialog(null,"Please check your Password and User ID!!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void useridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridActionPerformed

    private void userpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homepage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ad;
    private javax.swing.JTextField adminid;
    private javax.swing.JPasswordField adminpassword;
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField userid;
    private javax.swing.JPasswordField userpassword;
    // End of variables declaration//GEN-END:variables
}
