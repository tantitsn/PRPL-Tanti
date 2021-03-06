/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmJadwalKuliah.java
 *
 * Created on May 22, 2015, 6:15:56 PM
 */

package pbo.form;

import java.awt.Color;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pbo.util.ConectionDB;
import pbo.util.FungsiLayout;

/**
 *
 * @author Dell
 */
public class FrmJadwalKuliah extends javax.swing.JFrame {
Connection con;
ResultSet rs;
Statement stmt ;
DefaultTableModel datasource = new DefaultTableModel(
            new String [][]{{null},{null},{null},{null},{null}},
            new String [] {"Matakuliah     ","Ruangan","Hari","Jam Masuk","Jam Keluar"}
            );

    /** Creates new form FrmJadwalKuliah */
    public FrmJadwalKuliah() {
        initComponents();
        openConnection();
    }
     private void refresh(){
     datasource.getDataVector().removeAllElements();
     tbl_data.setModel(datasource);
 }
 public void opentable()
{
refresh();

 try{

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT e.matkul_nama , c.ruangan_kode , c.hari,c.jam_masuk,c.jam_keluar from tbl_detailkontrak a, tbl_kontrak b , tbl_jadwal c, tbl_kelas d, tbl_matkul e where a.kontrak_kode=b.kontrak_kode and b.nim='"+txt_nim.getText()+"' and a.jadwal_kode=c.jadwal_kode and c.kelas_kode=d.kelas_kode and d.matkul_kode=e.matkul_kode");

            while(rs.next())
            {
                datasource.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});

            }

         }catch(SQLException ex)
        {

            ex.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrmAbsensi1.class.getName()).log(Level.SEVERE, null, ex);
        }

}
public void nama()
{
    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("Select nama from tbl_mahasiswa where nim='"+txt_nim.getText()+"'");

    rs.first();
    String nama = rs.getString("nama");

    txt_nama.setText(nama);




    }
    catch(SQLException se)
                {
                        JOptionPane.showMessageDialog(null, "NIM yang anda masukan tidak terdaftar ");

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
        jLabel1 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbl_ruangan1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbl_BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Pengelolaan Absensi Mahasiswa | Jadwal Kuliah");

        jLabel1.setText("NIM");
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(240, 60, 70, 30);

        txt_nim.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txt_nim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nimKeyTyped(evt);
            }
        });
        jLayeredPane1.add(txt_nim);
        txt_nim.setBounds(340, 180, 190, 50);

        jLabel2.setText("Nama");
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(240, 110, 70, 30);

        txt_nama.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txt_nama.setEnabled(false);
        jLayeredPane1.add(txt_nama);
        txt_nama.setBounds(340, 240, 340, 40);

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_data);

        jLayeredPane1.add(jScrollPane1);
        jScrollPane1.setBounds(340, 290, 910, 400);

        jLabel4.setFont(new java.awt.Font("HelveNueThin", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jadwal Matakuliah ");
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(590, 40, 510, 70);

        lbl_ruangan1.setBackground(new java.awt.Color(0, 0, 0));
        lbl_ruangan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/BTN CARI_1.png"))); // NOI18N
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
        lbl_ruangan1.setBounds(540, 180, 140, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/botKeluar.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel3KeyPressed(evt);
            }
        });
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(1260, 640, 85, 80);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton1);
        jButton1.setBounds(690, 240, 100, 40);

        lbl_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/JADWAL.png"))); // NOI18N
        jLayeredPane1.add(lbl_BG);
        lbl_BG.setBounds(0, 0, 1366, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1367, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nimKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nimKeyTyped

    private void lbl_ruangan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        nama();
        opentable();
        lbl_ruangan1.setText("");
        txt_nim.setText("");
    }//GEN-LAST:event_lbl_ruangan1MouseClicked

    private void lbl_ruangan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseEntered
        lbl_ruangan1.setBackground(Color.RED);
}//GEN-LAST:event_lbl_ruangan1MouseEntered

    private void lbl_ruangan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseExited
        lbl_ruangan1.setBackground(Color.black);
}//GEN-LAST:event_lbl_ruangan1MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        FrmMenuUtama fu = new FrmMenuUtama();
        FungsiLayout.setToCenter(fu);
        FungsiLayout.setMaximize(fu);
        fu.setVisible(true);
        dispose();
}//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel3KeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_jLabel3KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        laporan();
    }//GEN-LAST:event_jButton1ActionPerformed
public void laporan()
{
         Map<String,String> param = new HashMap<String,String>();
         param.put("nim", txt_nim.getText());
         System.out.println(param);
      
        //menetapkan judul report
        try{
             ClassLoader cl = FrmKelas.class.getClassLoader();
             URL ul = cl.getResource("Rpt_DaftarMatakuliahPerMahasiswa.jrxml");
             File f = new File(ul.toURI());
             System.out.println(f.getPath());
             JasperDesign design = JRXmlLoader.load(f.getPath());
             JasperReport report = JasperCompileManager.compileReport(design);
             JasperPrint print = JasperFillManager.fillReport(report, param,con);
             JasperViewer.viewReport(print);
        } catch (Exception ex )
            { ex.printStackTrace(); }
  }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJadwalKuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_BG;
    private javax.swing.JLabel lbl_ruangan1;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nim;
    // End of variables declaration//GEN-END:variables
public void openConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://" +
                    "localhost:3306/db_pbo","root","");
            System.out.println("koneksi berhasil");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch(SQLException sqle){
            sqle.printStackTrace();

        }
}
}
