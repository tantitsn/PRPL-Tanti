/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmKelas.java
 *
 * Created on May 22, 2015, 6:37:02 PM
 */

package pbo.form;

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
import pbo.util.ConectionDB;
import pbo.util.FungsiLayout;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dell
 */
public class FrmKelas extends javax.swing.JFrame {
Connection con;
ResultSet rs;
Statement stmt;

DefaultTableModel datasource = new DefaultTableModel(
            new String [][]{{null},{null},{null},{null},{null}},
            new String [] {"Kode Jadwal","Matakuliah","Kelas","Ruangan","Nama Dosen"}
            );
  DefaultTableModel datasource2 = new DefaultTableModel(
            new String [][]{{null},{null},{null}},
            new String [] {"NIM","Nama","Jumlah Absensi"}
            );
    /** Creates new form FrmKelas */
    public FrmKelas() {
        initComponents();
        openConnection();
        opentable();
        lbl_jadwalkode.setVisible(false);
        

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
            rs = stmt.executeQuery("select  a.jadwal_kode,c.matkul_nama, b.kelas,a.ruangan_kode ,d.dosen_nama from tbl_jadwal a, tbl_kelas b, tbl_matkul c, tbl_dosen d where a.kelas_kode=b.kelas_kode and b.matkul_kode=c.matkul_kode and b.nip=d.nip ");

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
 private void refresh2(){
     datasource2.getDataVector().removeAllElements();
     tbl_data1.setModel(datasource2);
 }
 public void opentablemahasiswa()
{
refresh2();

 try{

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT a.nim, b.nama, ( SELECT count( nim ) AS jumlah FROM tbl_absensi WHERE jadwal_kode = '"+lbl_jadwalkode.getText()+"' AND nim = a.nim ) AS 'Jumlah Absensi' FROM tbl_absensi a, tbl_mahasiswa b WHERE a.nim = b.nim AND a.jadwal_kode = '"+lbl_jadwalkode.getText()+"' GROUP BY a.nim");

            while(rs.next())
            {
                datasource2.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});

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
  public void opentablecari()
{
refresh();

 try{

            stmt = con.createStatement();
            rs = stmt.executeQuery("select  a.jadwal_kode,c.matkul_nama, b.kelas,a.ruangan_kode ,d.dosen_nama from tbl_jadwal a, tbl_kelas b, tbl_matkul c, tbl_dosen d where a.kelas_kode=b.kelas_kode and b.matkul_kode=c.matkul_kode and b.nip=d.nip and d.dosen_nama like '%"+txt_dosen.getText()+"%'");

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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        txt_dosen = new javax.swing.JTextField();
        lbl_jadwalkode = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbl_jadwalkode1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_jadwalkode2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbl_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Pengelolaan Absensi Mahasiswa | Daftar Kelas");

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
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jLayeredPane1.add(jScrollPane1);
        jScrollPane1.setBounds(340, 220, 450, 390);

        txt_dosen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_dosen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dosenKeyTyped(evt);
            }
        });
        jLayeredPane1.add(txt_dosen);
        txt_dosen.setBounds(340, 170, 190, 40);

        lbl_jadwalkode.setText("jdw11");
        jLayeredPane1.add(lbl_jadwalkode);
        lbl_jadwalkode.setBounds(890, 190, 60, 14);

        tbl_data1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_data1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_data1);

        jLayeredPane1.add(jScrollPane2);
        jScrollPane2.setBounds(890, 220, 410, 380);

        jLabel4.setFont(new java.awt.Font("HelveNueThin", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Daftar Kelas");
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(600, 30, 290, 70);

        lbl_jadwalkode1.setFont(new java.awt.Font("HelveNueThin", 1, 24)); // NOI18N
        lbl_jadwalkode1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jadwalkode1.setText("Nama Dosen :");
        jLayeredPane1.add(lbl_jadwalkode1);
        lbl_jadwalkode1.setBounds(340, 130, 200, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/botKeluar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(1250, 640, 85, 80);

        lbl_jadwalkode2.setFont(new java.awt.Font("HelveNueThin", 1, 24)); // NOI18N
        lbl_jadwalkode2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jadwalkode2.setText("Daftar Mahasiswa");
        jLayeredPane1.add(lbl_jadwalkode2);
        lbl_jadwalkode2.setBounds(990, 160, 200, 40);

        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton1);
        jButton1.setBounds(550, 170, 61, 40);

        lbl_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/JADWAL.png"))); // NOI18N
        lbl_bg.setText("jLabel1");
        jLayeredPane1.add(lbl_bg);
        lbl_bg.setBounds(0, 0, 1360, 740);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dosenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dosenKeyTyped
        // TODO add your handling code here:
        opentablecari();
    }//GEN-LAST:event_txt_dosenKeyTyped

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        // TODO add your handling code here:
    int baris = tbl_data.getSelectedRow();
    System.out.print(baris);
    String kode = tbl_data.getValueAt(baris,0).toString();
    lbl_jadwalkode.setText(kode);

    opentablemahasiswa();
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void tbl_data1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data1MouseClicked
        // TODO add your handling code here:
    int baris = tbl_data1.getSelectedRow();
    System.out.print(baris);
    String jml = tbl_data1.getValueAt(baris,2).toString();

    int absensi = Integer.parseInt(jml);

    if (absensi < 13)
    {
            JOptionPane.showMessageDialog(null, "Nah loh Gabisa ikutan UAS :p");
    }else
    {
     JOptionPane.showMessageDialog(null, "Selamat anda bisa mengikuti UAS");
    }


    }//GEN-LAST:event_tbl_data1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        FrmMenuUtama fu = new FrmMenuUtama();
        FungsiLayout.setToCenter(fu);
        FungsiLayout.setMaximize(fu);
        fu.setVisible(true);
        dispose();
}//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        laporan();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmKelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_bg;
    private javax.swing.JLabel lbl_jadwalkode;
    private javax.swing.JLabel lbl_jadwalkode1;
    private javax.swing.JLabel lbl_jadwalkode2;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTable tbl_data1;
    private javax.swing.JTextField txt_dosen;
    // End of variables declaration//GEN-END:variables
public void laporan()
{
         Map<String,String> param = new HashMap<String,String>();
         param.put("jadwal_kode", lbl_jadwalkode.getText());
         System.out.println(param);
      
        //menetapkan judul report
        try{
             ClassLoader cl = FrmKelas.class.getClassLoader();
             URL ul = cl.getResource("Rpt_RekapAbsenPerkelas.jrxml");
             File f = new File(ul.toURI());
             System.out.println(f.getPath());
             JasperDesign design = JRXmlLoader.load(f.getPath());
             JasperReport report = JasperCompileManager.compileReport(design);
             JasperPrint print = JasperFillManager.fillReport(report, param,con);
             JasperViewer.viewReport(print);
        } catch (Exception ex )
            { ex.printStackTrace(); }
  }
}
