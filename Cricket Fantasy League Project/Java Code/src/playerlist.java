/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Owner
 */
public class playerlist extends javax.swing.JFrame {

Connection con=null;
Statement stmt=null;
ResultSet rs=null;
DefaultTableModel tm =null;

static String globalplayer; 
static int globalid=0;

int listcnt=0;
int playercnt=0;
    /**
     * Creates new form playerlist
     */
    public playerlist() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID ", "NAME", "COUNTRY", "TYPE", "OWNER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 78, 660, 310);

        jButton1.setText("Add Player to Team");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 400, 180, 23);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("TEAM SELECTION");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 10, 370, 40);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID", "NAME", "TYPE"
            }
        ));
        jTable2.setName("jTable2"); // NOI18N
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 460, 452, 190);

        jButton2.setText("Remove from Team");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(510, 440, 160, 23);

        status.setText("0");
        getContentPane().add(status);
        status.setBounds(480, 630, 230, 20);

        jButton3.setText("Submit Team");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(510, 520, 160, 23);

        jButton4.setText("Calculate Points");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(510, 480, 160, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

try{

        Class.forName("java.sql.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localHost/cfl","root","1234");
        System.out.println("connection established");

        tm=(DefaultTableModel)jTable1.getModel();
        
        stmt=con.createStatement();
        int i;
        int rowcount=tm.getRowCount();
        
        //String n="sunny";
        
        Rankings r = new Rankings();
        String n=r.globaluser;
        
        
        for(i=1;i<=90;i++)
        {
        String query= "Select * from players where id="+i+" and owner_name='"+n+"';";
        ResultSet rs= stmt.executeQuery(query);
        
        if(listcnt!=9999)
        {    
       
        while(rs.next())
        {
        Object a[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
        tm.addRow(a);
        listcnt++;
        }
        
        }
        
        }


}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try
        {
   
        Class.forName("java.sql.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localHost/cfl","root","1234");
        System.out.println("connection established");

       stmt=con.createStatement();
       
       tm=(DefaultTableModel)jTable2.getModel();
       
       int row= jTable1.getSelectedRow();
       int col=jTable1.getSelectedColumn();
       
   ////////////////////////////////////////
String name= jTable1.getModel().getValueAt(row,col).toString();
       
   ////////////////////////////////////////////////// 
        String query= "Select * from players where name='"+name+"';";
        ResultSet rs= stmt.executeQuery(query);
        
        rs.first();
        
        Object a[]={rs.getString(1),rs.getString(2),rs.getString(4)};
        
        if(playercnt<=11)
        {
            tm.addRow(a);
            playercnt++;
            status.setText(playercnt+" players selected!!");
       
        }
               
        else
            status.setText("Only 11 players allowed!!");
       
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select player name!! ");
            listcnt=9999;
               
        }
        

        
        
        
        
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try
        {
        int row;
        
        tm=(DefaultTableModel)jTable2.getModel();
        
       row=jTable2.getSelectedRow();
       tm.removeRow(row);
        
       playercnt--;
            status.setText(playercnt +" players selected!!");
        }
            
        catch(Exception e)
        {
            System.out.println("Select a player to remove...");
        }
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   try
   {
        tm=(DefaultTableModel)jTable2.getModel();
 
int bowlcnt=0,allcnt=0,wkcnt=0;
int i=1;
int rowcount=tm.getRowCount();


for(i=1;i<=rowcount-1;i++)
{
    if(jTable2.getModel().getValueAt(i,2).toString().equals("BOWL"))
    {
    bowlcnt++;
    System.out.println("bowlcount"+bowlcnt);
    }
    if(jTable2.getModel().getValueAt(i,2).toString().equals("ALL"))
    {
    allcnt++;
    System.out.println("allcount"+allcnt);
    }
    if(jTable2.getModel().getValueAt(i,2).toString().equals("WK-BAT"))
    {
    wkcnt++;
    System.out.println("wkcount"+wkcnt);
    }
}

/*
if(wkcnt==0)
        JOptionPane.showMessageDialog(null, "Must have a wicket keeper...");
if(bowlcnt<3)
            JOptionPane.showMessageDialog(null, "Must have minimum 3 bowlers...");
if(bowlcnt==3 && allcnt!=2)
            JOptionPane.showMessageDialog(null, "Must have minimum 3 bowlers and 2 all rounders...");
*/

if(rowcount==12)
{
    
    if(bowlcnt>=4 && wkcnt>=1)
    {
    JOptionPane.showMessageDialog(null, "Team Submited!!");
    Rankings r = new Rankings();
    r.setVisible(true);
    this.dispose();
    }
    else
    JOptionPane.showMessageDialog(null, "Team must have minimum 4 bowlers and 1 wicket keeper!!");
        
}
else
    JOptionPane.showMessageDialog(null, "Team must have 11 Players!!");
    
   }
    
        catch(Exception e)
        {
            System.out.println(e);
        }
    


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

try{        
       
        Class.forName("java.sql.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localHost/cfl","root","1234");
        System.out.println("connection established");

       stmt=con.createStatement();
       
       tm=(DefaultTableModel)jTable2.getModel();
       
       int row= jTable2.getSelectedRow();
       int col=jTable2.getSelectedColumn();
       
   ////////////////////////////////////////
        String abc= jTable2.getModel().getValueAt(row,col).toString();
        String query= "Select * from players where name='"+abc+"';";
        ResultSet rs= stmt.executeQuery(query);
        rs.first();
        
        int wantedid= rs.getInt(1);        
        String wantedplayer = rs.getString(2);
          
                
        /////////////////////////
        globalplayer=wantedplayer;
        globalid=wantedid;;
        /////////////////////////////
        
        points_calculation pc=new points_calculation();
        pc.setVisible(true);
        
    }
catch(Exception e)
{
         JOptionPane.showMessageDialog(null, "First select a player!!");
       
}


    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(playerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playerlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playerlist().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
