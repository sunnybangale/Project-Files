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
public class registerationform extends javax.swing.JFrame {
Statement stmt =null;
Connection con =null;
ResultSet rs = null;
 //   private Object Calender;
   
    /** Creates new form registerationform */
    public registerationform() {
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
        jLabel6 = new javax.swing.JLabel();
        name_tf = new javax.swing.JTextField();
        address_tf = new javax.swing.JTextField();
        mth_CBX = new javax.swing.JComboBox();
        dt_CBX = new javax.swing.JComboBox();
        yr_CBX = new javax.swing.JComboBox();
        submitBtn = new javax.swing.JButton();
        prof_CBX = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        uid_tf = new javax.swing.JTextField();
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
        uidcons = new javax.swing.JLabel();
        usercons = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        confirmcons = new javax.swing.JLabel();
        emailcons = new javax.swing.JLabel();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("NAME");

        jLabel2.setText("ADDRESS");

        jLabel3.setText("DATE OF BIRTH ");

        jLabel4.setText("AGE ");

        jLabel5.setText("GENDER");

        jLabel6.setText("PROFESSION");

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

        address_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                address_tfFocusLost(evt);
            }
        });

        mth_CBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MONTH", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        mth_CBX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mth_CBXFocusLost(evt);
            }
        });

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

        yr_CBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YEAR", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", " " }));
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

        prof_CBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELF EMPLOYED", "TEACHER", "CIVILSERVICES", "HOUSEWIFE", "OTHERS", " ", " ", " ", " ", " " }));
        prof_CBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prof_CBXActionPerformed(evt);
            }
        });

        jLabel7.setText("U.I.D/P.A.N");

        uid_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uid_tfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                uid_tfFocusLost(evt);
            }
        });

        jLabel8.setText("USER ID ");

        user_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_tfFocusLost(evt);
            }
        });

        jLabel9.setText("PASSWORD");

        jLabel10.setText("CONFIRM PASSWORD");

        confirm_pwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirm_pwdFocusLost(evt);
            }
        });

        jLabel11.setText("EMAIL ID");

        jLabel12.setText("PHONE NUMBER");

        phone_no_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone_no_tfFocusLost(evt);
            }
        });

        email_tf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                email_tfFocusLost(evt);
            }
        });

        lbl_age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_ageFocusLost(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Return to home");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

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
                .addComponent(mRBtn)
                .addGap(18, 18, 18)
                .addComponent(fRBtn)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mRBtn)
                    .addComponent(fRBtn)))
        );

        jLabel16.setText("+91");

        namecons.setForeground(new java.awt.Color(255, 51, 51));

        addcons.setForeground(new java.awt.Color(255, 51, 51));

        yrcons.setForeground(new java.awt.Color(255, 51, 51));

        gendercons.setForeground(new java.awt.Color(255, 51, 51));

        uidcons.setForeground(new java.awt.Color(255, 51, 51));

        usercons.setForeground(new java.awt.Color(255, 51, 51));

        jLabel14.setText("(Minimum 7 characters required)");

        confirmcons.setForeground(new java.awt.Color(0, 204, 0));

        emailcons.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namecons, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(uid_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                            .addComponent(prof_CBX, 0, 288, Short.MAX_VALUE)
                                                            .addComponent(user_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                            .addComponent(input_pwd, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(104, 104, 104)
                                                                .addComponent(lbl_age, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addComponent(confirm_pwd, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                    .addComponent(email_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                    .addComponent(phone_no_tf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(341, 341, 341))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(361, 361, 361))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dt_CBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(address_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                        .addComponent(mth_CBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(yr_CBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(374, 374, 374)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(372, 372, 372)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(usercons, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel14)
                                        .addComponent(addcons, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(yrcons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(gendercons, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(uidcons, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(113, 113, 113))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(emailcons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmcons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(548, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(541, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(namecons, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addcons, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yrcons, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yr_CBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mth_CBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dt_CBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_age, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prof_CBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(gendercons, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uid_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uidcons, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usercons, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(confirmcons, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailcons, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone_no_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addComponent(submitBtn)
                .addGap(27, 27, 27)
                .addComponent(jLabel15)
                .addContainerGap(57, Short.MAX_VALUE))
        );

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
    con = DriverManager.getConnection("jdbc:mysql://localHost/ip_project12","root","");
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
Object a =prof_CBX.getSelectedItem();
String profession = a.toString();
Object date =dt_CBX.getSelectedItem();
String dt =date.toString();
Object month = mth_CBX.getSelectedItem();
String mth = month.toString();
Object year= yr_CBX.getSelectedItem();
String yr = year.toString();
String  uid = uid_tf.getText();
String pwd =new String (input_pwd.getPassword());
String confirmpwd = new String(confirm_pwd.getPassword());
String userID = user_tf.getText();
String phone = phone_no_tf.getText();
String email=email_tf.getText();

lbl1.setText("<html>"+"NAME: " +name+"<br>"+"ADDRESS: "+address+"<br>"+"PROFESSION: "+profession+"<br>"+"UID/PAN: "+uid+"<br>"+"USERID: "+userID+"<br>"+"PASSWORD: "+pwd+"<br>"+"EMAILID: "+email+"<br>"+"PHONE NUMBER: "+phone+"</html>");

int age = Integer.parseInt(lbl_age.getText());


    stmt=con.createStatement();
System.out.println("ok");



String query= "insert into user_record values("+'\"'+name+'\"'+"," +'\"'+address+ '\"'+","+'\"'+yr+"-"+mth+"-"+dt+'\"'+","+'\"'+age+'\"'+","+'\"'+gender+'\"'+","+'\"'+profession+'\"'+" , "+'\"'+uid+'\"'+" , "+'\"'+userID+'\"'+" , "+'\"'+pwd+'\"'+" , "+'\"'+email+'\"'+" , "+phone+");";
stmt.executeUpdate(query);
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

registerationform clo =new registerationform();
clo.setVisible(false);
this.dispose();
jDialog1.setVisible(true);
        }
catch(Exception u){
            JOptionPane.showMessageDialog(null,"YOur Info is insufficient.PLease Enter aLL Fields.");
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
    Login_Form j = new Login_Form();
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
address_tf.requestFocus();


    }
    else
addcons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_address_tfFocusLost

    private void lbl_ageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_ageFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_ageFocusLost

    private void uid_tfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uid_tfFocusGained
if(mRBtn.isSelected()==false&&fRBtn.isSelected()==false){
gendercons.setText("Please enter your gender");
    }
    else
gendercons.setText("");

 String ans=yr_CBX.getSelectedItem().toString();
       if(ans.equals("YEAR"))
          yrcons.setText("Please select Year");

    else
yrcons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_uid_tfFocusGained

    private void uid_tfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uid_tfFocusLost
if(uid_tf.getText()==null||uid_tf.getText().equals("")){
uidcons.setText("Please enter your UID / PAN number");
uid_tf.requestFocus();


    }
    else
uidcons.setText("");
                // TODO add your handling code here:
    }//GEN-LAST:event_uid_tfFocusLost

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

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerationform().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl_age;
    private javax.swing.JRadioButton mRBtn;
    private javax.swing.JComboBox mth_CBX;
    private javax.swing.JTextField name_tf;
    private javax.swing.JLabel namecons;
    private javax.swing.JTextField phone_no_tf;
    private javax.swing.JComboBox prof_CBX;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField uid_tf;
    private javax.swing.JLabel uidcons;
    private javax.swing.JTextField user_tf;
    private javax.swing.JLabel usercons;
    private javax.swing.JComboBox yr_CBX;
    private javax.swing.JLabel yrcons;
    // End of variables declaration//GEN-END:variables

}
