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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Owner
 */


public class Patient_info extends javax.swing.JFrame {
Connection con=null;

Statement stmt=null;
Statement stmt1=null;


ResultSet rs=null;
ResultSet rsr=null;
DefaultTableModel tm =null;

    /**
     * Creates new form Patient_info
     */
    public Patient_info() {
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
        jLabel3 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        past_history = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        n = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jDialog1.setTitle("Add new patient");
        jDialog1.setBounds(new java.awt.Rectangle(500, 250, 0, 0));
        jDialog1.setMinimumSize(new java.awt.Dimension(300, 300));
        jDialog1.getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel3.setText("Enter Patient ID");
        jDialog1.getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 74, 210, 30);

        pid.setText("0");
        jDialog1.getContentPane().add(pid);
        pid.setBounds(60, 120, 190, 30);

        jButton5.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Add-Male-User-icon.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton5);
        jButton5.setBounds(70, 180, 170, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Free-Download-Blue-Background-Wallpaper.jpg"))); // NOI18N
        jDialog1.getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 400, 300);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1290, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane1.setAutoscrolls(true);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Uid", "Name", "Gender", "Address", "Date of Birth", "Age", "Phone Number", "User ID", "Password", "Sessions", "Primary Date", "Type of Patient"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 105, 1200, 210);

        jLabel1.setFont(new java.awt.Font("Homoarakhn", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patient Information Workspace");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 30, 810, 20);

        jButton1.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/remove_male_user_256.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(740, 550, 170, 60);

        past_history.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(past_history);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 420, 570, 230);

        jButton2.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Google-Analytics-icon-300x300.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(980, 470, 147, 140);

        jButton3.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/logout.jpg"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1100, 20, 170, 50);

        n.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        n.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(n);
        n.setBounds(20, 20, 170, 40);

        jButton4.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Add-Male-User-icon.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(740, 470, 171, 60);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient Details: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 350, 210, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Free-Download-Blue-Background-Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1280, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       try
       {

           
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
        System.out.println("connectivity done");
        con.createStatement();
        
       tm=(DefaultTableModel)jTable1.getModel();
 
       int row= jTable1.getSelectedRow();
       int col=jTable1.getSelectedColumn();
       
       String abc= jTable1.getModel().getValueAt(row,col).toString();
       
       String query = "delete from user_table where name='"+abc+ "';";
       stmt.executeUpdate(query);
       JOptionPane.showMessageDialog(null, "Patient: "+abc+" removed from database");
       tm.removeRow(row);
       
       String q = "delete from past_table where name='"+abc+ "';";
       stmt.executeUpdate(q);
       
       
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Select the patient name to remove.....");
        }

       
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        try{

        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
        System.out.println("connectivity done");

        n.setText("ADMIN: "+homepage.aname);
        
        tm=(DefaultTableModel)jTable1.getModel();
        stmt=con.createStatement();
        stmt1=con.createStatement();

/////////////////        
        
       int rows=tm.getRowCount();
       for(int i=rows-1;i>=0;i--)
       tm.removeRow(i);
       

////////////////
        
        String adminid=homepage.aid;

      int i,count;
        
      String qy= "Select count(*) from admin_table where admin_id='"+adminid+"';";
        ResultSet rqw= stmt.executeQuery(qy);
        rqw.first();
        count=rqw.getInt(1);
        
// for(i=1;i<=count;i++)
 {
     
 //////////////////////
 
         String query= "Select u_id from admin_table where admin_id='"+adminid+"';";
        ResultSet rs= stmt.executeQuery(query);
        System.out.println("hotay");    
          
        
        while(rs.next())
        {
           
         String uid =rs.getString(1);
        System.out.println(uid);
        
    
     String q1= "Select u_id,name,gender,address ,dob,age ,phone_no,userid ,password,no_of_sessions_attended, primary_session_date, type_of_patient from user_table where u_id='"+uid+"';";
       rsr= stmt1.executeQuery(q1);
       
       while(rsr.next())
        {
            Object a[]={rsr.getString(1),rsr.getString(2),rsr.getString(3),rsr.getString(4),rsr.getString(5),rsr.getInt(6),rsr.getInt(7),rsr.getString(8),rsr.getString(9),rsr.getInt(10),rsr.getString(11),rsr.getString(12)};
            tm.addRow(a);
        }
        
       }  
        
//////////////////
 }

        

        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        

        
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        homepage a = new homepage();
        a.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try{
past_history.setText(null);
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
        System.out.println("connectivity done");

        tm=(DefaultTableModel)jTable1.getModel();
        stmt=con.createStatement();
        
       int row= jTable1.getSelectedRow();
       int col=jTable1.getSelectedColumn();
     
        String name= jTable1.getModel().getValueAt(row,col).toString();
        
        String query="select * from past_table where name='"+name+"';";
        ResultSet rs=stmt.executeQuery(query);
        
        String append = "";
        
        while(rs.next())
        {
        String past = rs.getString(3);
        int q = rs.getInt(4);
        int v = rs.getInt(5);
        int a = rs.getInt(6);
        
        
        append=append+"\n \n Patient: "+name+ " Date: "+rs.getDate(7)+ "\n \n Past History: \n"+ past + "\n \n Result: "+ "\n Questionnaire: "+ q +  " % \n Video: "+ v + " % \n Overall: "+ a + " % \n" ;
        
        past_history.setText(append);        
        }

        if( past_history.getText()=="")
    JOptionPane.showMessageDialog(null, "No past history of patient!!");

        
        }
       
    
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select name of patient!!");
        }
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//JOptionPane.showInputDialog(rootPane, evt, null, WIDTH)
        
        jDialog1.setVisible(true);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try
{
        String p=pid.getText();

        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
        System.out.println("connectivity done");

       stmt=con.createStatement();
 String q1="select count(*) from admin_table where u_id='"+p+"';";
        ResultSet rs=stmt.executeQuery(q1);
        
        int flag;
        
        int ucount;
        String prof,add,phone,userid,pass;
      
  rs.first();
      ucount= rs.getInt(1);
      flag=0;

//////////////......invalid id........///////////////      
      int notfound=0;
      int ucnt=0;
             stmt=con.createStatement();
 String qz="select u_id, count(u_id) from user_table where u_id='"+p+"';";
         rs=stmt.executeQuery(qz);
         
         rs.first();
         
         ucnt=rs.getInt(2);
        
        
/////////////////////////////      
        if(ucount!=0 || ucnt==0)
            {
                 JOptionPane.showMessageDialog(null, "Patient already mentored. Enter valid ID of patient!!");
                 pid.setText("");
                 flag=1;
            }
        else
        {
                  

         String q="select profession,address,phone_no,userid,password from admin_table where admin_id='"+homepage.aid+"';";

         rs=stmt.executeQuery(q);
        rs.first();

        prof=rs.getString(1);
         add=rs.getString(2);
         phone=rs.getString(3);
         userid=rs.getString(4);
         pass=rs.getString(5);
         System.out.println("\nRecord retrieved successfully");            
         
///////////////////////////////////////////         
     String qq = "select count(*) from user_table where u_id='"+p+"';";
     ResultSet rr = stmt.executeQuery(qq);

     while(rr.next())
     { 
     int uc=rr.getInt(1);
            if(uc==0)
            {
             JOptionPane.showMessageDialog(null,"Please enter valid User ID!!");        
             pid.setText("");

            }
           
    }
////////////////////////////         
         
         String query= "insert into admin_table values("+homepage.aid+","+p+","+'\"'+homepage.aname+'\"'+","+'\"'+prof+'\"'+","+'\"'+add+ '\"'+","+phone+","+'\"'+userid+'\"'+","+'\"'+pass+'\"'+");";
         stmt.executeUpdate(query);
         System.out.println("\nInserted record successfully");
         jDialog1.setVisible(false);
             
        }  
}
catch(Exception e)
{
        
            JOptionPane.showMessageDialog(null, e);
        
}
        

        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Patient_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient_info().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel n;
    private javax.swing.JTextPane past_history;
    private javax.swing.JTextField pid;
    // End of variables declaration//GEN-END:variables
}