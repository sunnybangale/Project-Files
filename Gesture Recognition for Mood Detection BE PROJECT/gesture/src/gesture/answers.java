/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gesture;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Owner
 */
public class answers extends javax.swing.JFrame {

  static int sumanswer;  
  
  static int nq;
  static int dq;

  static int nv;
  static int dv;

   static int N ;
   static int D;
        
  
  DefaultTableModel tm =null;

  
  
  ///////////////////////////////////////////////////
  
  private static int FILE_FOUND=0;
  
  
  
  
  
  
    /**
     * Creates new form answers
     */
    public answers() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AnswersTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 550));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("<html> Hamilton Rating Scale for Depression: <br> <br> 1-7: Normal  <br><br> 8-13: Mild depression <br><br> 14-17: Moderate depression <br> <br>  >17: Severe depression </html> ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 90, 290, 210);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Question Number", "Option Chosen "
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(440, 80, 289, 366);

        jLabel2.setFont(new java.awt.Font("Homoarakhn", 1, 30)); // NOI18N
        jLabel2.setText("Answers of Questionnaire");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(137, 11, 730, 45);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Total score:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 290, 90, 32);

        AnswersTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AnswersTotal.setText("0");
        getContentPane().add(AnswersTotal);
        AnswersTotal.setBounds(190, 290, 65, 32);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Google-Analytics-icon-300x300.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 330, 140, 140);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gesture/Free-Download-Blue-Background-Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 910, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        
     sumanswer= question1.q1+ question2.q2+ question3.q3+ question4.q4+ question5.q5+
                question6.q6+ question7.q7+ question8.q8+ question9.q9+ question10.q10+
                question11.q11+ question12.q12+ question13.q13+ question14.q14+ question15.q15+
                question16.q16+ question17.q17+ question18.q18+ question19.q19+ question20.q20;
     
     AnswersTotal.setText(sumanswer+"");

/////////////////////extra ordinary stuff :D ///////////////////////

String abc;

     for(int i=1;i<=20;i++)
     {
     abc="Object a"+i+"[]={"+i+",question"+i+".q"+i+"};\n tm.addRow(a"+i+");\n";
     System.out.println(abc);
     }
/////////////////////////////////////////////////////////     
     
     tm=(DefaultTableModel)jTable1.getModel();
 
     
     Object a1[]={1,question1.q1};
 tm.addRow(a1);

Object a2[]={2,question2.q2};
 tm.addRow(a2);

Object a3[]={3,question3.q3};
 tm.addRow(a3);

Object a4[]={4,question4.q4};
 tm.addRow(a4);

Object a5[]={5,question5.q5};
 tm.addRow(a5);

Object a6[]={6,question6.q6};
 tm.addRow(a6);

Object a7[]={7,question7.q7};
 tm.addRow(a7);

Object a8[]={8,question8.q8};
 tm.addRow(a8);

Object a9[]={9,question9.q9};
 tm.addRow(a9);

Object a10[]={10,question10.q10};
 tm.addRow(a10);

Object a11[]={11,question11.q11};
 tm.addRow(a11);

Object a12[]={12,question12.q12};
 tm.addRow(a12);

Object a13[]={13,question13.q13};
 tm.addRow(a13);

Object a14[]={14,question14.q14};
 tm.addRow(a14);

Object a15[]={15,question15.q15};
 tm.addRow(a15);

Object a16[]={16,question16.q16};
 tm.addRow(a16);

Object a17[]={17,question17.q17};
 tm.addRow(a17);

Object a18[]={18,question18.q18};
 tm.addRow(a18);

Object a19[]={19,question19.q19};
 tm.addRow(a19);

Object a20[]={20,question20.q20};
 tm.addRow(a20);

////////////////////////////////////////////////////
     
        int calc=0;
        
        if(sumanswer>=0 && sumanswer<=7)
        {
        calc=(sumanswer*100/64);
        }
        else  if(sumanswer>=8 && sumanswer<=13)
        {
        calc=(sumanswer*100/64);
        }
        else  if(sumanswer>=14 && sumanswer<=17)
        {
        calc=(sumanswer*100/64);
        }
        else  if(sumanswer>17)
        {
        calc=(sumanswer*100/64);
        }
 
        dq=calc;
        nq=100-dq;
        System.out.print(dq);
        
 // ..........video result.............
    //    nv=analysis.N/(analysis.N+analysis.D);
      //  dv=analysis.D/(analysis.N+analysis.D);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        analysis.flag=1;

  /////////////////////////////////////////////...........................................
        
        
        	while(true)
		{
								
		Scanner scanner;
	     
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
										
                                                                                int na= Integer.valueOf(N);
                                                                                int nb= Integer.valueOf(D);
                                                                                
                                                                                nv= (na*100)/ (na+nb);
                                                                                dv= (nb*100)/ (na+nb);
                                                                                System.out.println("\n percentage of N "+  nv);
                                                                                
                                                                                /*nv=((N*100)/(N+D));
                                                                                System.out.println("\n percentage of N "+  nv);
                                                                                 dv=((D*100)/(N+D));
                                                                                 System.out.println("\n percentage of D "+  dv);
                                                                                */

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
				
		
                //nv=69;
                //dv=31;        
                        
/////////////////////////////////////////////////.....................................			 		 
   
        
       
        
        
        
        analysis a=new analysis();
        a.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(answers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(answers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(answers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(answers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new answers().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnswersTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}