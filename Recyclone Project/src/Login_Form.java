import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.Timer;
import javax.swing.JOptionPane;

/*
 * Login_Form.java
 *
 * Created on 26-Jun-2010, 19:17:45
 */

/**
 *
 * @author Kishor
 */
public class Login_Form extends javax.swing.JFrame {
static int count = 0;
    public static String a;
Statement stmt;
Connection con=null;
ResultSet rs=null;
int r;
int j1,i;
Timer t=new Timer(100,new ActionListener(){
public void actionPerformed(ActionEvent e){

    int r=p1.getValue();
p1.setValue(r+1);
 ++i;
 if(i%10==0){
        
   lbl.setVisible(true);
 }
 else {
     lbl.setVisible(false);

 }

 } } );

    /** Creates new form Login_Form */
    public Login_Form() {
        initComponents();


  


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        p1 = new javax.swing.JProgressBar();
        jdlbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        submit_btn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        pass2 = new javax.swing.JPasswordField();
        signup = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        login_ID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setAlwaysOnTop(true);
        jDialog1.setBackground(new java.awt.Color(255, 51, 51));
        jDialog1.setBounds(new java.awt.Rectangle(400, 0, 0, 0));
        jDialog1.setForeground(new java.awt.Color(255, 51, 51));
        jDialog1.setIconImage(null);
        jDialog1.setMinimumSize(new java.awt.Dimension(560, 120));
        jDialog1.setModal(true);
        jDialog1.setUndecorated(true);
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jDialog1WindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jDialog1WindowOpened(evt);
            }
        });
        jDialog1.getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("%");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 80, 20, 20);

        p1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                p1StateChanged(evt);
            }
        });
        jPanel1.add(p1);
        p1.setBounds(100, 90, 379, 10);

        jdlbl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jdlbl);
        jdlbl.setBounds(40, 80, 20, 30);

        jLabel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel3FocusGained(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 20, 78, 40);

        lbl.setFont(new java.awt.Font("Arial Black", 1, 24));
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("LOADING...");
        jPanel1.add(lbl);
        lbl.setBounds(90, 20, 249, 35);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loading.JPG"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 574, 122);

        jDialog1.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 573, 120);

        jFrame1.setBounds(new java.awt.Rectangle(400, 300, 0, 0));
        jFrame1.setMinimumSize(new java.awt.Dimension(500, 500));

        submit_btn.setText("SUBMIT");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });

        jLabel8.setText("PASSWORD");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(submit_btn)
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel8)
                        .addGap(69, 69, 69)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                .addGap(106, 106, 106))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(submit_btn)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jDialog2.setMinimumSize(new java.awt.Dimension(1000, 1000));
        jDialog2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDialog2MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 48));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ACCESS DENIED");

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");
        setBounds(new java.awt.Rectangle(400, 300, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("LOGIN ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(46, 84, 88, 29);

        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(46, 133, 107, 23);

        submit.setText("SUBMIT");
        submit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                submitItemStateChanged(evt);
            }
        });
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(46, 194, 110, 23);

        pass2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));
        getContentPane().add(pass2);
        pass2.setBounds(205, 131, 200, 25);

        signup.setText("SIGN UP");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(204, 192, 126, 23);

        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Return to Home");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(353, 239, 196, 14);
        getContentPane().add(login_ID);
        login_ID.setBounds(205, 88, 200, 20);

        jLabel5.setBackground(new java.awt.Color(255, 255, 51));
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("ADMINISTRATOR");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(413, 11, 124, 35);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
try{

    boolean ans=false;
 String aa = login_ID.getText();
 String  str=new String(pass2.getPassword());
 String ss= "select * from user_record;";
 stmt=con.createStatement();
rs = stmt.executeQuery(ss);
 while (rs.next()){
     String id=rs.getString(8);
     String password = rs.getString(9);
     if ((aa.equals(id))&&(str.equals(password))){
         ans=true;
         break;
     }

 }
if(ans ==true){

    jDialog1.setVisible(true);
}
else
    JOptionPane.showMessageDialog(null,"please check your password and userid");

}
catch(Exception e){
JOptionPane.showMessageDialog(null,"error in finding "+e.getMessage());
}
 a=login_ID.getText();
//Login_Form q = new Login_Form();
//q.dispose();
// TODO add your handling code here:
}//GEN-LAST:event_submitActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
homepage p =new homepage();
p.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
registerationform p = new registerationform();
p.setVisible(true);
dispose();

// TODO add your handling code here:
}//GEN-LAST:event_signupActionPerformed

    private void p1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_p1StateChanged
Login_Form p = new Login_Form();
if(p1.getValue()==100){
    t.stop();
this.dispose();
 p.setVisible(false);}
 if (p1.getValue()==100){
        workspace a= new workspace();
        a.setVisible(true);
        jDialog1.setVisible(false);
        dispose();

    }
   jdlbl.setText(""+p1.getValue());
        // TODO add your handling code here:
    }//GEN-LAST:event_p1StateChanged

    private void jDialog1WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowActivated

        t.start();
      // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1WindowActivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
 
        try {
    Class.forName("java.sql.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localHost/ip_project12","root","");
    System.out.println("connectivity done");



 }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "error:"+e.getMessage());
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed
String pass= new String(jPasswordField1.getPassword());



if (count == 0&&pass.equals("qwerty")==false){
    count++;
    jLabel9.setText("2 Attempts left");
}
 else if (count==1&&pass.equals("qwerty")==false){
    count++;
    jLabel9.setText("1 Attempt left");
}
else if (count == 2&&pass.equals("qwerty")==false){
 
      jDialog2.setVisible(true);
      jFrame1.setVisible(false);
}
else{
    jFrame1.setVisible(false);
    dispose();
    administrator m = new administrator ();
    m.setVisible(true);
    
}
        // TODO add your handling code here:
}//GEN-LAST:event_submit_btnActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        jFrame1.setVisible(true);
        Login_Form z = new Login_Form();
       z.setVisible(false);
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void submitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_submitItemStateChanged
        // TODO add your handling code here:
}//GEN-LAST:event_submitItemStateChanged

    private void jDialog2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialog2MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog2MouseClicked

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
     // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void jLabel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel3FocusGained
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3FocusGained

    private void jDialog1WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowOpened
        Login_Form ww = new Login_Form();
ww.setVisible(false);
ww.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1WindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel jdlbl;
    private javax.swing.JLabel lbl;
    private javax.swing.JTextField login_ID;
    private javax.swing.JProgressBar p1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JButton signup;
    private javax.swing.JButton submit;
    private javax.swing.JButton submit_btn;
    // End of variables declaration//GEN-END:variables

}
