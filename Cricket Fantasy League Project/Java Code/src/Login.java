/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.sql.* ;
import javax.swing.* ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class Login extends javax.swing.JFrame {
static String user;


   

/**
     * Creates new form Login
     */
  
    public Login() {
        initComponents();
    //    conn = javaconnect.ConnecrDb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(99, 59, 67, 28);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(99, 139, 67, 29);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(213, 63, 110, 20);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(213, 143, 110, 20);

        jButton1.setText("login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(128, 230, 91, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:                                        
   try{

               
        if(jTextField1.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else if(jPasswordField1.getPassword().length==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else{
       user = jTextField1.getText();   // Collecting the input
       char[] pass = jPasswordField1.getPassword(); // Collecting the input
       String pwd = String.copyValueOf(pass);  // converting from array to string

       //if(validate_login(user,pwd))
       
       if(user.equals("Admin") && pwd.equals("qwerty"))
       {
           JOptionPane.showMessageDialog(null, "Correct Login Credentials");
           System.out.println(user);
           
             
             Rankings r=new Rankings();
             r.setVisible(true);
    
           
       }
       else
          JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
   }  
   
   this.dispose();
   
   }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

   
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    private boolean validate_login(String username,String password) {
   try{          
       
       
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfl?" + "user=root&password=1234");    
       PreparedStatement pst = conn.prepareStatement("Select userid,password from ownerinfo where userid=? and password=?");
       pst.setString(1, username);
       pst.setString(2, password);
       ResultSet rs = pst.executeQuery();                        
       if(rs.next())            
           return true;    
       else
           return false;
       
       
   }
   catch(Exception e){
       e.printStackTrace();
       return false;
   }      
}

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}