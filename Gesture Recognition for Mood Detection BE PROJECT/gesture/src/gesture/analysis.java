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


//.................import of integration...................

import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket; 
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.GrayFilter;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;




/**
 *
 * @author Owner
 */
public class analysis extends javax.swing.JFrame {

Connection con=null;
Statement stmt=null;
ResultSet rs=null;
    
 static int N =0;
 static int D = 0;  

    static int navg;
    static int davg;
    
    static int flag;
    
////////////////////////////////////////////////////////
    
    private static MatlabProxy proxy;
	private static int FILE_FOUND=0;

        private static void initMatlabControls() {
		// TODO Auto-generated method stub
		
	    	MatlabProxyFactoryOptions options =
	 	           new MatlabProxyFactoryOptions.Builder()
	 				   .setMatlabLocation("C:\\Program Files\\MATLAB\\R2011b\\bin\\matlab.exe")
	 	               .setUsePreviouslyControlledSession(true)
	 	               .build();
	 	       MatlabProxyFactory factory = new MatlabProxyFactory(options);
	 	      try
	 	      {
	 	    	  proxy = factory.getProxy();
	 	      }
	 	     catch(Exception e)
	 		{
	 		
		
	 		} finally {
				}
	    
	    
	}

    
    
    /**
     * Creates new form analysis
     */
    public analysis() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        qpro = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vpro = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        nquest = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dquest = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nvideo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dvideo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        apro = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        nall = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dall = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        n = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analysis");
        setMinimumSize(new java.awt.Dimension(980, 710));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/photo-1-11.jpg"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 350, 200, 60);

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel1.setText("Result of QUESTIONNAIRE Analysis");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 140, 440, 58);
        getContentPane().add(qpro);
        qpro.setBounds(20, 210, 450, 14);

        jLabel2.setFont(new java.awt.Font("Homoarakhn", 1, 30)); // NOI18N
        jLabel2.setText("Analysis of Patient");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 30, 630, 43);

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel3.setText("Result of VIDEO Analysis");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(480, 140, 295, 58);
        getContentPane().add(vpro);
        vpro.setBounds(480, 210, 470, 14);

        jLabel4.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jLabel4.setText("NORMAL / HAPPY Percentage");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 250, 233, 26);

        nquest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nquest.setText("0");
        getContentPane().add(nquest);
        nquest.setBounds(270, 250, 44, 26);

        jLabel6.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jLabel6.setText("DEPRESSED Percentage");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 280, 233, 22);

        dquest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dquest.setText("0");
        getContentPane().add(dquest);
        dquest.setBounds(270, 280, 44, 22);

        jLabel5.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jLabel5.setText("NORMAL / HAPPY Percentage");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(480, 250, 230, 26);

        nvideo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nvideo.setText("0");
        getContentPane().add(nvideo);
        nvideo.setBounds(730, 250, 47, 26);

        jLabel8.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jLabel8.setText("DEPRESSED Percentage");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(480, 280, 230, 19);

        dvideo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dvideo.setText("0");
        getContentPane().add(dvideo);
        dvideo.setBounds(730, 280, 47, 19);

        jLabel7.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel7.setText("OVERALL Analysis");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 470, 187, 45);
        getContentPane().add(apro);
        apro.setBounds(20, 520, 460, 14);

        jLabel9.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jLabel9.setText("NORMAL / HAPPY Percentage");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 550, 231, 27);

        nall.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nall.setText("0");
        getContentPane().add(nall);
        nall.setBounds(270, 550, 36, 27);

        jLabel10.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jLabel10.setText("DEPRESSED Percentage");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 590, 231, 22);

        dall.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dall.setText("0");
        getContentPane().add(dall);
        dall.setBounds(270, 590, 36, 22);

        jButton2.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/logout.jpg"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(790, 20, 170, 50);

        n.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        getContentPane().add(n);
        n.setBounds(20, 30, 159, 43);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/business-concept-financial-performance-ppt-backgrounds.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 980, 674);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try
{
    flag=0;
    
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
        System.out.println("connectivity done");
        stmt=con.createStatement();

        
        String qw="update user_table set no_of_sessions_attended=no_of_sessions_attended + 1 where u_id="+ '\"' +homepage.uid+ '\"' +";";
        stmt.executeUpdate(qw);

        
        question1 a = new question1();
        a.setVisible(true);
       
                
        
//....................................integration................................................       
        
        
	
	 
		
		initMatlabControls();
		
		try {
				proxy.eval("addpath('C:\\Users\\Owner\\Documents\\NetBeansProjects\\gesture')");
				proxy.feval("DepthGui1");
			
		} catch (MatlabInvocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
	
/*		
		
		while(true)
		{
								
		Scanner scanner;
//	        int N = 0;
//	       int D = 0;
	      int MatlabCount=0;
		                    
		
							File ABC=new File("MATLAB_RESULT.txt");
							if(ABC.exists()) 
							{	
								try {
										scanner = new Scanner(ABC);
										while(scanner.hasNextInt())
										{
											if(MatlabCount==0)
											{
												N = scanner.nextInt();
												System.out.println("I Got N="+ N);
												MatlabCount=MatlabCount+1;
											}
											else
											{
												D = scanner.nextInt();
												System.out.println("I Got D="+ D);
											}
											
											FILE_FOUND=1;
										}
										
										ABC.delete();
								    } 
									catch (FileNotFoundException e) 
									{
								    	// TODO Auto-generated catch block
								    	e.printStackTrace();
								    }
								
							}
						
							else
							{
								System.out.println("File Does Not Exist");
							}
							
		
		if(FILE_FOUND==1)
			
			break;			
					    
		}			
				
*/ 
        
        
        
        
        
        
        
        
 //.............................................................................      

       // analysis b = new analysis();
       // b.setVisible(false);
       

}
catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);

}

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

try
{
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localHost/gesture","root","1234");
        System.out.println("connectivity done");
        stmt=con.createStatement();
    
n.setText("USER: "+homepage.uname);
        
//question analysis//////
        
        nquest.setText(answers.nq+"");
        dquest.setText(answers.dq+"");
       
qpro.setValue(0);        
int r=qpro.getValue();
qpro.setValue(r+answers.dq);

//////////////////////video analysis///////////////////////////////

        nvideo.setText(answers.nv+"");
        dvideo.setText(answers.dv+"");

vpro.setValue(0);        
int s=vpro.getValue();
vpro.setValue(s+answers.dv);


//overall analysis//////

         navg=(answers.nq+answers.nv)/2;
         davg=(answers.dq+answers.dv)/2;
        
        nall.setText(navg+"");
        dall.setText(davg+"");

apro.setValue(0);        
int q=apro.getValue();
apro.setValue(q+davg);
        
       String qq = "select curdate()+0 from dual;";
       ResultSet rs=stmt.executeQuery(qq);
       rs.next();
       int curdate = rs.getInt(1);



String q1="update past_table set result_q="+answers.dq+" where u_id="+'\"' + homepage.uid + '\"' + " and session_date="+ '\"' +curdate + '\"' +" ;";
stmt.executeUpdate(q1);

String q2="update past_table set result_v="+answers.dv+" where u_id="+'\"' + homepage.uid + '\"' + " and session_date="+ '\"' +curdate + '\"' +" ;";
stmt.executeUpdate(q2);

String q3="update past_table set result_a="+davg+" where u_id="+'\"' + homepage.uid + '\"' + " and session_date="+ '\"' +curdate + '\"' +" ;";
stmt.executeUpdate(q3);


if(flag==1)
{
    if(davg < 25)
   JOptionPane.showMessageDialog(null,"<html>If being in command of your emotional state sounds good, take charge of your life with these 5 easy tips.<br><br>1. Stop Chasing and Start Living.<br>2. Assume Responsibility.<br>3. Stop Seeking Stimulation.<br>4. Take Action.<br>5. Expect Nothing.<br><br>At the end of the day, bad things will happen to you. <br>You will have highs, lows and lots of mediums in your life.<br> You’re only human, just like everybody else.<br>But follow the 5 tips and you’ll be well on your way to staying happy – no matter what happens. :) </html>");
    else
    {
        JOptionPane.showMessageDialog(null,"<html>10 natural depression treatment steps to follow <br><br> 1. Get in a routine.<br>2. Set goals and avoid people who are toxic.<br>3. Exercise.<br>4. Eat healthy.<br>5. Get enough sleep.<br>6. Take on responsibilities.<br>7. Challenge negative thoughts.<br>8. Check with your doctor before using supplements.<br>9. Do something new.<br>10. Try to have fun and stay connected with others.<br><br>If You Are Feeling Suicidal...<br>When you’re feeling extremely depressed or suicidal,<br> your problems don’t seem temporary—they seem overwhelming and permanent.<br> But with time, you will feel better, especially if you reach out for help.<br> If you are feeling suicidal, know that there are many people who want to support you during this difficult time,<br> so please reach out for help!<br><br>Some useful links you may want to visit: <br> International Suicide Hotline<br>http://www.suicide.org/international-suicide-hotlines.html <br> <br>Indian helplines:<br>http://www.suicide.org/hotlines/international/india-suicide-hotlines.html<br><br> Follow the link for more help...<br> http://www.clinical-depression.co.uk/depression-learning-path/</html>");
      }
     flag=0;
}

}
catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);

}

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        homepage a = new homepage();
        a.setVisible(true);
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analysis().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar apro;
    private javax.swing.JLabel dall;
    private javax.swing.JLabel dquest;
    private javax.swing.JLabel dvideo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel n;
    private javax.swing.JLabel nall;
    private javax.swing.JLabel nquest;
    private javax.swing.JLabel nvideo;
    private javax.swing.JProgressBar qpro;
    private javax.swing.JProgressBar vpro;
    // End of variables declaration//GEN-END:variables
}