

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
public class registeration extends javax.swing.JFrame {
Statement stmt =null;
Connection con =null;
ResultSet rs = null;
int id;
 //   private Object Calender;
   
    /** Creates new form registerationform */
    public registeration() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name_tf = new javax.swing.JTextField();
        address_tf = new javax.swing.JTextField();
        mth_CBX = new javax.swing.JComboBox();
        dt_CBX = new javax.swing.JComboBox();
        yr_CBX = new javax.swing.JComboBox();
        submitBtn = new javax.swing.JButton();
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
        lbl_age = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mRBtn = new javax.swing.JRadioButton();
        fRBtn = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        namecons = new javax.swing.JLabel();
        addcons = new javax.swing.JLabel();
        yrcons = new javax.swing.JLabel();
        gendercons = new javax.swing.JLabel();
        usercons = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        confirmcons = new javax.swing.JLabel();
        emailcons = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jDialog1.setMinimumSize(new java.awt.Dimension(600, 600));

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Registeration");
        setMinimumSize(new java.awt.Dimension(750, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(41, 11, 110, 40);

        jLabel2.setText("ADDRESS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 120, 120, 29);

        jLabel3.setText("DATE OF BIRTH ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 160, 120, 40);

        jLabel4.setText("AGE ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 200, 120, 40);

        jLabel5.setText("GENDER");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 50, 120, 40);

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
        name_tf.setBounds(210, 10, 230, 30);

        address_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                address_tfFocusLost(evt);
            }
        });
        getContentPane().add(address_tf);
        address_tf.setBounds(210, 120, 290, 30);

        mth_CBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MONTH", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        mth_CBX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mth_CBXFocusLost(evt);
            }
        });
        getContentPane().add(mth_CBX);
        mth_CBX.setBounds(320, 170, 90, 20);

        dt_CBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DATE", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " ", " " }));
        dt_CBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dt_CBXActionPerformed(evt);
            }
        });
        dt_CBX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dt_CBXFocusLost(evt);
            }
        });
        getContentPane().add(dt_CBX);
        dt_CBX.setBounds(210, 170, 70, 20);

        yr_CBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YEAR", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014" }));
        yr_CBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yr_CBXActionPerformed(evt);
            }
        });
        yr_CBX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                yr_CBXFocusLost(evt);
            }
        });
        getContentPane().add(yr_CBX);
        yr_CBX.setBounds(430, 170, 80, 20);

        submitBtn.setText("SUBMIT");
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
        submitBtn.setBounds(280, 570, 116, 23);

        jLabel8.setText("USER ID ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 300, 91, 26);

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
        user_tf.setBounds(230, 300, 270, 30);

        jLabel9.setText("PASSWORD");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 340, 110, 27);
        getContentPane().add(input_pwd);
        input_pwd.setBounds(230, 340, 270, 30);

        jLabel10.setText("CONFIRM PASSWORD");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 390, 160, 20);

        confirm_pwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirm_pwdFocusLost(evt);
            }
        });
        getContentPane().add(confirm_pwd);
        confirm_pwd.setBounds(230, 380, 270, 30);

        jLabel11.setText("EMAIL ID");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 430, 100, 20);

        jLabel12.setText("CONTACT NUMBER");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 260, 130, 24);

        phone_no_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone_no_tfFocusLost(evt);
            }
        });
        getContentPane().add(phone_no_tf);
        phone_no_tf.setBounds(230, 250, 270, 30);

        email_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                email_tfFocusLost(evt);
            }
        });
        getContentPane().add(email_tf);
        email_tf.setBounds(230, 420, 270, 30);

        lbl_age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_ageFocusLost(evt);
            }
        });
        getContentPane().add(lbl_age);
        lbl_age.setBounds(210, 210, 117, 28);

        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Return to home");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15);
        jLabel15.setBounds(548, 608, 231, 14);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("select category"));

        buttonGroup1.add(mRBtn);
        mRBtn.setText("MALE");

        buttonGroup1.add(fRBtn);
        fRBtn.setText("FEMALE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(mRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(fRBtn)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mRBtn)
                    .addComponent(fRBtn))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(210, 50, 267, 53);

        jLabel16.setText("+91");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(190, 260, 30, 14);

        namecons.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(namecons);
        namecons.setBounds(428, 11, 141, 20);

        addcons.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(addcons);
        addcons.setBounds(510, 120, 171, 29);

        yrcons.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(yrcons);
        yrcons.setBounds(520, 160, 300, 33);

        gendercons.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(gendercons);
        gendercons.setBounds(520, 70, 188, 34);

        usercons.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(usercons);
        usercons.setBounds(510, 310, 295, 20);

        jLabel14.setText("(Minimum 7 characters Required)");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(510, 344, 190, 30);

        confirmcons.setForeground(new java.awt.Color(0, 204, 0));
        getContentPane().add(confirmcons);
        confirmcons.setBounds(510, 380, 168, 17);

        emailcons.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(emailcons);
        emailcons.setBounds(510, 420, 168, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(40, 30, 0, 2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dt_CBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dt_CBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dt_CBXActionPerformed

    private void yr_CBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yr_CBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yr_CBXActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
jLabel1.requestFocus();
try{
    Class.forName("java.sql.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localHost/cfl","root","1234");
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

if (mRBtn.isSelected()){
  gender=mRBtn.getText();
}
else if (fRBtn.isSelected()){
 gender=fRBtn.getText();
}

//Object a =prof_CBX.getSelectedItem();
//String profession = a.toString();
Object date =dt_CBX.getSelectedItem();
String dt =date.toString();
Object month = mth_CBX.getSelectedItem();
String mth = month.toString();
Object year= yr_CBX.getSelectedItem();
String yr = year.toString();

String pwd =new String (input_pwd.getPassword());
String confirmpwd = new String(confirm_pwd.getPassword());

String userID = user_tf.getText();
String phone = phone_no_tf.getText();
String email=email_tf.getText();

//int sessions = Integer.parseInt(sessions_tf.getText());

lbl1.setText("<html>"+"NAME: " +name+"<br>"+"GENDER: " +gender+"<br>"+"ADDRESS: "+address+"<br>"+"DOB: "+yr+"-"+mth+"-"+dt+"<br>"+"PHONE NUMBER: "+phone+"<br>"+"USERID: "+userID+"<br>"+"PASSWORD: "+pwd+"<br>"+"EMAILID: "+email+"</html>");

int age = Integer.parseInt(lbl_age.getText());


    stmt=con.createStatement();
System.out.println("ok");

String q = "select curdate()+0 from dual;";
          stmt=con.createStatement();
          rs=stmt.executeQuery(q);
       
          rs.first();
          int curdate = rs.getInt(1);
         id++; 

String query= "insert into ownerinfo values("+id+","+'\"'+name+'\"'+","+'\"'+gender+'\"'+","+'\"'+address+ '\"'+","+'\"'+yr+"-"+mth+"-"+dt+'\"'+","+age+","+phone+","+'\"'+userID+'\"'+","+'\"'+pwd+'\"'+");";
stmt.executeUpdate(query);
System.out.println("\nInserted record successfully");



String aa=input_pwd.getText();
int count=aa.length();
     if ((input_pwd.getText().equals(confirm_pwd.getText()))&&(count >=7)){
confirmcons.setText("Passwords match");
     }
     else
     { JOptionPane.showMessageDialog(null,"Passwords donot match or they are too short!" );
     int asasa= Integer.parseInt("s");
     }

     

rs.close();
con.close();
stmt.close();

registeration clo =new registeration();
clo.setVisible(false);
this.dispose();
Login l=new Login();
l.setVisible(true);
        }
catch(Exception u){
            JOptionPane.showMessageDialog(null,"YOur Info is insufficient.PLease Enter aLL Fields.");
        }



    }//GEN-LAST:event_submitBtnActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
Login p = new Login();
p.setVisible(true);
dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void user_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_tfFocusLost
if(user_tf.getText()==null||user_tf.getText().equals("")){
usercons.setText("Please enter your preffered User ID");
user_tf.requestFocus();


    }
    else
usercons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_user_tfFocusLost

    private void yr_CBXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yr_CBXFocusLost
       try  {
          String query = "select curdate()+0 from dual;";
          stmt=con.createStatement();
          rs=stmt.executeQuery(query);
       
          rs.first();
          int da = rs.getInt(1);
          Object a=yr_CBX.getSelectedItem();
         String sa=a.toString();
         String ne = sa.substring(0,4);
         Object gg=da;

         int la=Integer.parseInt(ne);
           String saa=gg.toString();
         String neo = saa.substring(0,4);

         int yta=Integer.parseInt(neo);
         int ages=yta-la;
         lbl_age.setText(""+ages);
         yrcons.setVisible(false);
        }
        catch(Exception e){
           yrcons.setVisible(true);
yr_CBX.requestFocus();

        }
      

        // TODO add your handling code here:
    }//GEN-LAST:event_yr_CBXFocusLost

    private void submitBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_submitBtnFocusLost
// TODO add your handling code here:
    }//GEN-LAST:event_submitBtnFocusLost

    private void phone_no_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone_no_tfFocusLost
       String phone = phone_no_tf.getText().toString();
        int i= phone.length();
          
if(i<10||i>10||i==0){
   JOptionPane.showMessageDialog(null,"invalid phone no");
}




        // TODO add your handling code here:
    }//GEN-LAST:event_phone_no_tfFocusLost

    private void name_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_tfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Login j = new Login();
    j.setVisible(true);
//    jDialog1.setVisible(false);
  //  jDialog1.dispose();

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
address_tf.requestFocus();


    }
    else
addcons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_address_tfFocusLost

    private void lbl_ageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_ageFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_ageFocusLost

    private void email_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email_tfFocusLost
if(email_tf.getText()==null||email_tf.getText().equals("")){
emailcons.setText("Please enter your emailID");
email_tf.requestFocus();


    }
    else
emailcons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_email_tfFocusLost

    private void dt_CBXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dt_CBXFocusLost
Object dtd =dt_CBX.getSelectedIndex();
   if(Integer.parseInt(dtd.toString())==0){
yrcons.setVisible(true);
       yrcons.setText("Please select a date.");

}
   else {
    yrcons.setVisible(false);
   }
    // TODO add your handling code here:
    }//GEN-LAST:event_dt_CBXFocusLost

    private void mth_CBXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mth_CBXFocusLost
   Object dtd =mth_CBX.getSelectedIndex();
   if(Integer.parseInt(dtd.toString())==0){
yrcons.setVisible(true);
       yrcons.setText("Please select a month.");

}
   else {
    yrcons.setVisible(false);
   }     // TODO add your handling code here:
    }//GEN-LAST:event_mth_CBXFocusLost

    private void user_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_tfActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registeration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addcons;
    private javax.swing.JTextField address_tf;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField confirm_pwd;
    private javax.swing.JLabel confirmcons;
    private javax.swing.JComboBox dt_CBX;
    private javax.swing.JTextField email_tf;
    private javax.swing.JLabel emailcons;
    private javax.swing.JRadioButton fRBtn;
    private javax.swing.JLabel gendercons;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl_age;
    private javax.swing.JRadioButton mRBtn;
    private javax.swing.JComboBox mth_CBX;
    private javax.swing.JTextField name_tf;
    private javax.swing.JLabel namecons;
    private javax.swing.JTextField phone_no_tf;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField user_tf;
    private javax.swing.JLabel usercons;
    private javax.swing.JComboBox yr_CBX;
    private javax.swing.JLabel yrcons;
    // End of variables declaration//GEN-END:variables

}
