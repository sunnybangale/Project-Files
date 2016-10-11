package gesture;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


//+year+"/"+month+"/"+day+,,,,,,,,,,,,,,,+profession+" , "
/**
 *
 * @author Kishor
 */
public class admin_registration extends javax.swing.JFrame {
Statement stmt =null;
Connection con =null;
ResultSet rs = null;

int id;

//   private Object Calender;
   
    /** Creates new form registerationform */
    public admin_registration() {
        initComponents();
    }

    private void Display(String name) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

   
 



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        lbl1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name_tf = new javax.swing.JTextField();
        address_tf = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        prof_CBX = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        user_tf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        input_pwd = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        confirm_pwd = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        phone_no_tf = new javax.swing.JTextField();
        email_tf = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        namecons = new javax.swing.JLabel();
        addcons = new javax.swing.JLabel();
        usercons = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        confirmcons = new javax.swing.JLabel();
        emailcons = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jDialog1.setMinimumSize(new java.awt.Dimension(500, 500));
        jDialog1.getContentPane().setLayout(null);
        jDialog1.getContentPane().add(lbl1);
        lbl1.setBounds(82, 11, 246, 327);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton1);
        jButton1.setBounds(82, 344, 225, 23);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Registration");
        setMinimumSize(new java.awt.Dimension(1000, 740));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel1.setText("NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 90, 130, 30);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel2.setText("ADDRESS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 230, 140, 29);

        jLabel6.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel6.setText("PROFESSION");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 170, 140, 30);

        name_tf.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        name_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_tfActionPerformed(evt);
            }
        });
        name_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_tfFocusLost(evt);
            }
        });
        getContentPane().add(name_tf);
        name_tf.setBounds(330, 90, 270, 30);

        address_tf.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        address_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                address_tfFocusLost(evt);
            }
        });
        getContentPane().add(address_tf);
        address_tf.setBounds(330, 230, 270, 30);

        submitBtn.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/submit-btn.png"))); // NOI18N
        submitBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        submitBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                submitBtnFocusLost(evt);
            }
        });
        getContentPane().add(submitBtn);
        submitBtn.setBounds(760, 530, 110, 30);

        prof_CBX.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        prof_CBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DOCTOR", "TEACHER", "CIVIL SERVICES", "HOUSEWIFE", "STUDENT", "MENTOR", "EMPLOYEE", "SELF EMPLOYED", "OTHERS", " ", " ", " ", " ", " " }));
        prof_CBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prof_CBXActionPerformed(evt);
            }
        });
        getContentPane().add(prof_CBX);
        prof_CBX.setBounds(330, 170, 270, 30);

        jLabel8.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel8.setText("USER ID ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(120, 320, 100, 26);

        user_tf.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        user_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_tfActionPerformed(evt);
            }
        });
        user_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_tfFocusLost(evt);
            }
        });
        getContentPane().add(user_tf);
        user_tf.setBounds(330, 320, 270, 30);

        jLabel9.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel9.setText("PASSWORD");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(120, 350, 130, 40);

        input_pwd.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        getContentPane().add(input_pwd);
        input_pwd.setBounds(330, 360, 270, 30);

        jLabel10.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel10.setText("CONFIRM PASSWORD");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(120, 400, 170, 30);

        confirm_pwd.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        confirm_pwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirm_pwdFocusLost(evt);
            }
        });
        getContentPane().add(confirm_pwd);
        confirm_pwd.setBounds(330, 400, 270, 30);

        jLabel11.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel11.setText("EMAIL ID");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(120, 440, 70, 30);

        jLabel12.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel12.setText("CONTACT NUMBER");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 270, 170, 30);

        phone_no_tf.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        phone_no_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone_no_tfFocusLost(evt);
            }
        });
        getContentPane().add(phone_no_tf);
        phone_no_tf.setBounds(330, 270, 270, 30);

        email_tf.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        email_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                email_tfFocusLost(evt);
            }
        });
        getContentPane().add(email_tf);
        email_tf.setBounds(330, 440, 270, 30);

        jLabel15.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel15.setText("Return to home");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15);
        jLabel15.setBounds(760, 590, 240, 20);

        jLabel16.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel16.setText("+91");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(300, 270, 30, 30);

        namecons.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        getContentPane().add(namecons);
        namecons.setBounds(610, 90, 230, 30);

        addcons.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        getContentPane().add(addcons);
        addcons.setBounds(610, 230, 230, 30);

        usercons.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        getContentPane().add(usercons);
        usercons.setBounds(610, 320, 290, 30);

        jLabel14.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jLabel14.setText("(Minimum 7 characters required)");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(610, 360, 210, 40);

        confirmcons.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        getContentPane().add(confirmcons);
        confirmcons.setBounds(610, 400, 260, 30);

        emailcons.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        getContentPane().add(emailcons);
        emailcons.setBounds(610, 440, 270, 30);

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 10)); // NOI18N
        jLabel3.setText("PATIENT ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 130, 130, 30);

        pid.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        pid.setText("0");
        pid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pidFocusLost(evt);
            }
        });
        getContentPane().add(pid);
        pid.setBounds(330, 130, 270, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/circlemetal-1024.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 990, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
jLabel1.requestFocus();
try{
    Class.forName("java.sql.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
    System.out.println("connectivity done");
  
}
catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
}
   // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
try{
String name = name_tf.getText();
String address = address_tf.getText();
String gender=new String();
String patientid=pid.getText();




Object a =prof_CBX.getSelectedItem();
String profession = a.toString();

String pwd =new String (input_pwd.getPassword());
String confirmpwd = new String(confirm_pwd.getPassword());

String userID = user_tf.getText();
String phone = phone_no_tf.getText();
String email=email_tf.getText();

lbl1.setText("<html>"+"NAME: " +name+"<br><br>"+"PATIENT ID: " +patientid+"<br><br>"+"ADDRESS: "+address+"<br><br>"+"PHONE NUMBER: "+phone+"<br><br>"+"USERID: "+userID+"<br><br>"+"PASSWORD: "+pwd+"<br><br>"+"EMAILID: "+email+"<br><br>"+"PROFESSION: " + profession + "</html>");



    stmt=con.createStatement();
System.out.println("ok");

String q = "select curdate()+0 from dual;";
          stmt=con.createStatement();
          rs=stmt.executeQuery(q);
       
          rs.first();
          int curdate = rs.getInt(1);

String aa=input_pwd.getText();
int count=aa.length();
     if ((input_pwd.getText().equals(confirm_pwd.getText()))&&(count >=7)){
confirmcons.setText("Passwords match");
     }
     else
     { JOptionPane.showMessageDialog(null,"Passwords donot match or they are too short!" );
     int asasa= Integer.parseInt("s");
     }

      ////////////////////////////
     String qq = "select max(admin_id) from admin_table;";
     ResultSet rr = stmt.executeQuery(qq);
     
      if(rr.first()==false)
     id=1;
     
     else
     {    
     rr.first();
     id=rr.getInt(1);
     }
    //////////////////////////      
          
     id++;
if(patientid!="0")
{    
String query= "insert into admin_table values("+id+","+patientid+","+'\"'+name+'\"'+","+'\"'+profession+'\"'+","+'\"'+address+ '\"'+","+phone+","+'\"'+userID+'\"'+","+'\"'+pwd+'\"'+");";
stmt.executeUpdate(query);
System.out.println("\nInserted record successfully");
}
else
    JOptionPane.showMessageDialog(null,"Patient ID cannot be 0.." );
    
     

rs.close();
con.close();
stmt.close();

admin_registration clo =new admin_registration();
clo.setVisible(false);
this.dispose();
jDialog1.setVisible(true);
        }
catch(Exception u){
            JOptionPane.showMessageDialog(null,"YOur Info is insufficient.PLease Enter aLL Fields./ Kindly check the patient id (One patient-One mentor policy)");
        }



    }//GEN-LAST:event_submitBtnActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
homepage p = new homepage();
p.setVisible(true);
dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void prof_CBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prof_CBXActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_prof_CBXActionPerformed

    private void user_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_tfFocusLost
if(user_tf.getText()==null||user_tf.getText().equals("")){
usercons.setText("Please enter your preffered User ID");
//user_tf.requestFocus();
   }
    else
usercons.setText("");

    
if(user_tf.getText()!=null){

    try{
stmt=con.createStatement();
System.out.println("ok");

String uenter=user_tf.getText();

     String qq = "select userid from admin_table where userid='"+uenter+"';";
     ResultSet rr = stmt.executeQuery(qq);

     while(rr.next())
     { 
     String u=rr.getString(1);
            if(u!=null)
            {
             System.out.println(u);
             JOptionPane.showMessageDialog(null,"Please enter another User ID as it already exists!!");        
             user_tf.setText("");
            }
           
    }
     
     
    }
catch(Exception u){
            JOptionPane.showMessageDialog(null,"Please enter another User ID as it already exists!!");        
}
    
    
}

                // TODO add your handling code here:
    }//GEN-LAST:event_user_tfFocusLost

    private void submitBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_submitBtnFocusLost
// TODO add your handling code here:
    }//GEN-LAST:event_submitBtnFocusLost

    private void phone_no_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone_no_tfFocusLost
       String phone = phone_no_tf.getText().toString();
        int i= phone.length();
          
if(i<10||i>10||i==0){
   JOptionPane.showMessageDialog(null,"Invalid phone number");
}




        // TODO add your handling code here:
    }//GEN-LAST:event_phone_no_tfFocusLost

    private void name_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_tfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    homepage j = new homepage();
    j.setVisible(true);
  jDialog1.setVisible(false);
    jDialog1.dispose();

    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void confirm_pwdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirm_pwdFocusLost
String aa=input_pwd.getText();
int count=aa.length();
     if ((input_pwd.getText().equals(confirm_pwd.getText()))&&(count >=7)){
confirmcons.setText("Passwords match");

     }
     else{
         JOptionPane.showMessageDialog(null,"Passwords donot match or they are too short!" );
input_pwd.setText("");
confirmcons.setText("");
confirm_pwd.setText("");
     }


 // TODO add your handling code here:
    }//GEN-LAST:event_confirm_pwdFocusLost

    private void name_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_tfFocusLost
        String a=name_tf.getText();
        if(a.equals(""))
           namecons.setText("Please enter your name");


        // TODO add your handling code here:
    }//GEN-LAST:event_name_tfFocusLost

    private void address_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_tfFocusLost
if(address_tf.getText()==null||address_tf.getText().equals("")){
addcons.setText("Please enter your address");
//address_tf.requestFocus();


    }
    else
addcons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_address_tfFocusLost

    private void email_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email_tfFocusLost
if(email_tf.getText()==null||email_tf.getText().equals("")){
emailcons.setText("Please enter your email ID");
//email_tf.requestFocus();


    }
    else
emailcons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_email_tfFocusLost

    private void user_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_tfActionPerformed

    private void pidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pidFocusLost
try{
   Class.forName("java.sql.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
    System.out.println("connectivity done");
    
    stmt=con.createStatement();
  
    String qaz= "select max(u_id) from user_table; ";
        ResultSet rq = stmt.executeQuery(qaz);
        rq.first();
        
        int exist=rq.getInt(1);

        int given=Integer.parseInt(pid.getText());
        
       if(given > exist)
        {
         JOptionPane.showMessageDialog(null,"Patient ID doesn't exist!!" );
          }    
        
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e);

        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_pidFocusLost

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addcons;
    private javax.swing.JTextField address_tf;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField confirm_pwd;
    private javax.swing.JLabel confirmcons;
    private javax.swing.JTextField email_tf;
    private javax.swing.JLabel emailcons;
    private javax.swing.JPasswordField input_pwd;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JTextField name_tf;
    private javax.swing.JLabel namecons;
    private javax.swing.JTextField phone_no_tf;
    private javax.swing.JTextField pid;
    private javax.swing.JComboBox prof_CBX;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField user_tf;
    private javax.swing.JLabel usercons;
    // End of variables declaration//GEN-END:variables

}
