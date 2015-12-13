/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SplashPBO.java
 *
 * 
 */

package pbo.form;

import pbo.util.ConectionDB;
import pbo.util.FungsiLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JProgressBar;
import javax.swing.Timer;



/**
 *
 * @author ElHakim
 */
public class FrmSplash extends javax.swing.JDialog {
    ConectionDB dbKon;
    Connection konek;
    private Timer timer;
    int i = 0;
    JProgressBar Loading;
    /** Creates new form SplashSITi */
    public FrmSplash(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Loading = new JProgressBar();
        
        initComponents();
        this.add(Loading);
        dbKon = new ConectionDB();
        dbKon.openConnection();
        
        Loading.setVisible(false);
        setTimerSplash(50);
    }

    private void setTimerSplash(int second){
        
        timer = new Timer(second,new ActionListener() {
                    public void actionPerformed(ActionEvent o) {
			//nambahin i
			i++;
			//mengatur nilai loadingnya
			Loading.setValue(i);
                        System.out.println(i);
			double persen = Loading.getPercentComplete();
			
			mulai();
		}
		});
        timer.start();
        Loading.setVisible(false);
    }

      public void mulai() {
	try {

            if (Loading.getPercentComplete() == 1.0) {
		timer.stop();
                this.dispose();
                FrmLogin login = new FrmLogin();
                FungsiLayout.setToCenter(login);
             //   FungsiLayout.setMaximize(login);
                login.setVisible(true);
            }
	}
    catch(Exception e) {
         System.out.println("Error cek : "+e.getMessage());
	 e.printStackTrace();
	}
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbl_ruangan1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setUndecorated(true);
        setResizable(false);

        lbl_ruangan1.setBackground(new java.awt.Color(0, 0, 0));
        lbl_ruangan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/splashgif.gif"))); // NOI18N
        lbl_ruangan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ruangan1.setOpaque(true);
        lbl_ruangan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ruangan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ruangan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_ruangan1MouseExited(evt);
            }
        });
        jLayeredPane1.add(lbl_ruangan1);
        lbl_ruangan1.setBounds(50, 60, 230, 129);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/splashfix.png"))); // NOI18N
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(0, 0, 708, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ruangan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
       
    }//GEN-LAST:event_lbl_ruangan1MouseClicked

    private void lbl_ruangan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseEntered
      
}//GEN-LAST:event_lbl_ruangan1MouseEntered

    private void lbl_ruangan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseExited
      
}//GEN-LAST:event_lbl_ruangan1MouseExited

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FungsiLayout.lookAndFeel();
                FrmSplash dialog = new FrmSplash(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                FungsiLayout.setToCenter(dialog);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lbl_ruangan1;
    // End of variables declaration//GEN-END:variables

}