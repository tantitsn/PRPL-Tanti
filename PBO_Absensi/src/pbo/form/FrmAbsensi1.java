/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmAbsensi.java
 *
 * Created on May 8, 2015, 6:33:31 PM
 */

package pbo.form;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pbo.util.ConectionDB;
import pbo.util.FungsiDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javazoom.jl.player.Player;
/**
 *
 * @author Dell
 */
public class FrmAbsensi1 extends javax.swing.JFrame {
FungsiDatabase fDB;
Statement stmt;
ResultSet rs;
Connection con;
 DefaultTableModel datasource = new DefaultTableModel(
            new String [][]{{null},{null}},
            new String [] {"NIM","Nama"}
            );
  DefaultTableModel datasource2 = new DefaultTableModel(
            new String [][]{{null},{null},{null}},
            new String [] {"NIM","Nama","Jam Datang"}
            );
    /** Creates new form FrmAbsensi */
    public FrmAbsensi1(String ruang,String jam,String hari,String tgl) {
      initComponents();

      lbl_jam.setVisible(false);
      lbl_kodeJadwal.setVisible(false);
       lbl_kontrakKode.setVisible(false);
       lbl_tanggal.setVisible(false);
        lbl_tanggal1.setVisible(false);
         lbl_jam1.setVisible(false);
         lbl_jumlahAbsensi.setVisible(false);
         lbl_NIP.setVisible(false);
         //lbl_ruangan1.setEnabled(false);


     openConnection();
    
         
      lbl_ruangan.setText(ruang);
      lbl_jam.setText(jam);
      lbl_hari.setText(hari);
      lbl_tanggal1.setText(tgl);
     
       Header(ruang,jam,hari);
       cek_dosenudahHadir(tgl);
 Timer timer = new Timer(1000, new ActionListener() {
	public void actionPerformed(ActionEvent e) {

                String strJam = new SimpleDateFormat("H:mm:ss").format(new Date());
		lbl_jam.setText(strJam);
                String strtgl = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		lbl_tanggal.setText(strtgl);
                opentable();
                opentableabsen();
	}
} );
timer.start();
     
        
    }
     private void refresh(){
     datasource.getDataVector().removeAllElements();
     tbl_data.setModel(datasource);
 }
      private void refresh2(){
     datasource2.getDataVector().removeAllElements();
     tbl_data1.setModel(datasource2);
 }
      public void cektimedosen()
      {
 String waktu1,waktu2;
     waktu1= lbl_jamMasuk.getText();
     waktu2= "12:41:00";

     String waktu [] = waktu1.split(":");
     String jam = waktu[0];
     String menit = waktu[1];
     String detik = waktu[2];

     String waktuu [] = waktu2.split(":");
     String jam1 = waktuu[0];
     String menit1 = waktuu[1];
     String detik1 = waktuu[2];

     int detik11 = Integer.parseInt(detik);
     int detik111 = Integer.parseInt(detik1);

     int menit11 = Integer.parseInt(menit);
     int menit111 = Integer.parseInt(menit1);

     int jam11 = Integer.parseInt(jam);
     int jam111 = Integer.parseInt(jam1);

     int de,me,ja,hasil1,de1,me1,ja1,hasil2,hasil;

    de=detik11;
     me = menit11*60;
     ja = jam11*3600;

     hasil1 = de+me+ja;

     de1=detik111;
     me1 = menit111*60;
     ja1 = jam111*3600;

     hasil2 = de1+me1+ja1;

        System.out.println(""+jam11);
        System.out.println(""+jam111);
        System.out.println(""+hasil1);
        System.out.println(""+hasil2);
     if (hasil1 >=  hasil2)
     {
        System.out.print("masuk");
        String keterangan="Disiplin";
        absenDosen(keterangan);
       
     }else
     {
       
        String keterangan="Terlambat";
       absenDosen(keterangan);
     
     }

      }
      public void cektime()
      {
 String waktu1,waktu2;
     waktu1= lbl_jamMasuk.getText();
     waktu2= "12:00:00";

     String waktu [] = waktu1.split(":");
     String jam = waktu[0];
     String menit = waktu[1];
     String detik = waktu[2];

     String waktuu [] = waktu2.split(":");
     String jam1 = waktuu[0];
     String menit1 = waktuu[1];
     String detik1 = waktuu[2];

     int detik11 = Integer.parseInt(detik);
     int detik111 = Integer.parseInt(detik1);

     int menit11 = Integer.parseInt(menit);
     int menit111 = Integer.parseInt(menit1);

     int jam11 = Integer.parseInt(jam);
     int jam111 = Integer.parseInt(jam1);

     int de,me,ja,hasil1,de1,me1,ja1,hasil2,hasil;

    de=detik11;
     me = menit11*60;
     ja = jam11*3600;

     hasil1 = de+me+ja+600;

     de1=detik111;
     me1 = menit111*60;
     ja1 = jam111*3600;

     hasil2 = de1+me1+ja1;

        System.out.println(""+jam11);
        System.out.println(""+jam111);
        System.out.println(""+hasil1);
        System.out.println(""+hasil2);
     if (hasil1 >=  hasil2)
     {
        System.out.print("masuk");
        absen();
        opentableabsen();
     }else
     {
       JOptionPane.showMessageDialog(null, "Anda Udah Telat Mending Pulang Aja");
     }

      }
     public void absen()
     {
     try{
        stmt = this.con.createStatement(ResultSet.FETCH_FORWARD, ResultSet.TYPE_SCROLL_SENSITIVE);
        stmt.executeUpdate(" insert into tbl_absensi "+
                "VALUES('"+txt_nim.getText()+"',"+
                    "'"+lbl_kodeJadwal.getText()+"',"+
                    "'"+lbl_tanggal.getText()+"',"+
                    "'"+lbl_jam1.getText()+
                    "')" );

                jmlAbsensi();
                cekUas();
        //JOptionPane.showMessageDialog(this, "Silahkan Masuk");
        }catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, "Salah di Insert");
            se.printStackTrace();
        }


     }
     public void absenDosen(String keterangan)
     {
     try{
        stmt = this.con.createStatement(ResultSet.FETCH_FORWARD, ResultSet.TYPE_SCROLL_SENSITIVE);
        stmt.executeUpdate(" insert into tbl_absensi_dosen "+
                "VALUES('"+txt_nip.getText()+"',"+
                    "'"+lbl_kodeJadwal.getText()+"',"+
                    "'"+lbl_tanggal.getText()+"',"+
                    "'"+lbl_jam1.getText()+"',"+
                    "'"+keterangan+
                    "')" );

        play("silahkan.mp3");
        JOptionPane.showMessageDialog(this, "Silahkan Masuk, Status anda: "+keterangan);
        lbl_StatusDosen.setText("Dosen Hadir");
        jLabel5.setVisible(false);
        txt_nip.setVisible(false);
        lbl_absensi.setVisible(false);
        }catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, "Salah di Insert");
            se.printStackTrace();
        }


     }


     public void cekUas()
     {
         String keterangan = null;
         String absen;
         absen = lbl_jumlahAbsensi.getText();
         int jml = Integer.parseInt(absen);
         if ( jml < 13)
         {
            keterangan = "Tidak Boleh mengikuti UAS";
         }
         else
         {
         keterangan = " Boleh mengikuti UAS";
         }


     try{
       
        stmt.executeUpdate("UPDATE tbl_uas SET jml='"+lbl_jumlahAbsensi.getText()+"',keterangan='"+keterangan+"' WHERE nim='"+txt_nim.getText()+"' and jadwal_kode='"+lbl_kodeJadwal.getText()+"'");
          play("silahkan.mp3");
        JOptionPane.showMessageDialog(this, "Silahkan Masuk ,Sudah Absen: "+jml +" Kali dan "+keterangan);
        }catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, "Update jml salah");
            se.printStackTrace();
        }


     }
    public void opentable()
{
refresh();

 try{

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT a.nim,a.nama FROM tbl_mahasiswa a, tbl_kontrak b, tbl_detailkontrak c, tbl_jadwal d, tbl_ruangan e WHERE a.nim = b.nim AND b.kontrak_kode = c.kontrak_kode AND c.jadwal_kode = d.jadwal_kode AND d.ruangan_kode = e.ruangan_kode AND d.ruangan_kode = '"+lbl_ruangan.getText()+"' and hari='Jumat' and '12:40:00' between jam_masuk and jam_keluar ");

            while(rs.next())
            {
                datasource.addRow(new String[]{rs.getString(1),rs.getString(2)});

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
    public void opentableabsen()
{
refresh2();

    //System.out.println(lbl_tanggal.getText());
 try{

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT a.nim, b.nama , a.jam_datang from tbl_absensi a, tbl_mahasiswa b where a.nim=b.nim and a.jadwal_kode='"+lbl_kodeJadwal.getText()+"' and a.tanggal ='"+lbl_tanggal.getText()+"'");

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

    public void Header(String ruang,String jam,String hari)
{

    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("select a.matkul_nama ,c.hari ,c.jam_masuk,c.jam_keluar,d.dosen_nama, d.nip, c.jadwal_kode from tbl_matkul a, tbl_kelas b, tbl_jadwal c,tbl_dosen d where c.kelas_kode=b.kelas_kode and b.matkul_kode=a.matkul_kode and c.ruangan_kode='"+lbl_ruangan.getText()+"' and c.hari='Jumat' and '12:40:00'between c.jam_masuk and c.jam_keluar and  b.nip=d.nip");

    rs.first();
    String nama = rs.getString("a.matkul_nama");
    String day = rs.getString("c.hari");
    String jammasuk = rs.getString("c.jam_masuk");
    String jamkeluar = rs.getString("c.jam_keluar");
    String dosen = rs.getString("d.dosen_nama");
    String kode  = rs.getString("c.jadwal_kode");
    String nip  = rs.getString("d.nip");
    //String kontrak  = rs.getString("c.kontrak_kode");

    lbl_matkul.setText(nama);
    lbl_hari.setText(hari);
    lbl_dosen.setText(dosen);
    lbl_jamMasuk.setText(jammasuk);
    lbl_jamKeluar.setText(jamkeluar);
    lbl_kodeJadwal.setText(kode);
    lbl_NIP.setText(nip);

    }
    catch(SQLException se)
                {
                     System.out.println("kosong");

                }
}
    public void cek_nim()
{

    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("select * from ( SELECT a.nim FROM tbl_mahasiswa a, tbl_kontrak b, tbl_detailkontrak c, tbl_jadwal d, tbl_ruangan e WHERE a.nim = b.nim AND b.kontrak_kode = c.kontrak_kode AND c.jadwal_kode = d.jadwal_kode AND d.ruangan_kode = e.ruangan_kode AND d.ruangan_kode = '"+lbl_ruangan.getText()+"' AND hari = 'Jumat' AND '12:40:00' BETWEEN jam_masuk AND jam_keluar ) as A  where nim='"+txt_nim.getText()+"' ");

    rs.first();
    String nama = rs.getString("nim");
   
         //JOptionPane.showMessageDialog(null, "Selamat Datang :)");
          cek_2kali();
   
    }
    catch(SQLException se)
                {
                       JOptionPane.showMessageDialog(null, "Anda Bukan Kelas ini !");
                       ruang();

                }
    }
    public void  jmlAbsensi()
{

    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT count( nim ) AS jumlah FROM tbl_absensi WHERE jadwal_kode = '"+lbl_kodeJadwal.getText()+"' AND nim = '"+txt_nim.getText()+"'");

    rs.first();
    String jml = rs.getString("jumlah");

        lbl_jumlahAbsensi.setText(jml);

    }
    catch(SQLException se)
                {
                       JOptionPane.showMessageDialog(null, "Anda Bukan Kelas ini !");
                       ruang();

                }
}
    public void cek_2kali()
{

    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("select nim from tbl_absensi where tanggal ='"+lbl_tanggal.getText()+"' and jadwal_kode = '"+lbl_kodeJadwal.getText()+"' and nim='"+txt_nim.getText()+"'");

    rs.first();
    String nama = rs.getString("nim");


         JOptionPane.showMessageDialog(null, "Anda Sudah Absen");

    }
    catch(SQLException se)
                {
                       cektime();

                }
}
    public void ruang()
    {
    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT a.ruangan_kode from tbl_jadwal a , tbl_detailkontrak b ,tbl_kontrak c where a.jadwal_kode=b.jadwal_kode and b.kontrak_kode=c.kontrak_kode and c.nim='"+txt_nim.getText()+"' and hari='Jumat'and '12:40:00' Between jam_masuk and jam_keluar");

    rs.first();
    String ruang = rs.getString("a.ruangan_kode");


         JOptionPane.showMessageDialog(null, "Jadwal Anda Ada di Ruangan "+ruang);

    }
    catch(SQLException se)
                {
                        JOptionPane.showMessageDialog(null, "Balik aja ");

                }
    }

    private FrmAbsensi1() {
        throw new UnsupportedOperationException("Not yet implemented");
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
        lbl_ruangan = new javax.swing.JLabel();
        lbl_dosen = new javax.swing.JLabel();
        lbl_matkul = new javax.swing.JLabel();
        lbl_jamMasuk = new javax.swing.JLabel();
        lbl_hari = new javax.swing.JLabel();
        lbl_jamKeluar = new javax.swing.JLabel();
        lbl_jam = new javax.swing.JLabel();
        lbl_jam1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        lbl_tanggal1 = new javax.swing.JLabel();
        lbl_kodeJadwal = new javax.swing.JLabel();
        lbl_Matkul = new javax.swing.JLabel();
        lbl_Matkul1 = new javax.swing.JLabel();
        lbl_Matkul2 = new javax.swing.JLabel();
        lbl_kontrakKode = new javax.swing.JLabel();
        lbl_jumlahAbsensi = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_ruangan1 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        lbl_NIP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nip = new javax.swing.JTextField();
        lbl_absensi = new javax.swing.JLabel();
        lbl_StatusDosen = new javax.swing.JLabel();
        lbl_BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Pengelolaan Absensi Mahasiswa | Absensi");

        lbl_ruangan.setFont(new java.awt.Font("HelveNueThin", 1, 90)); // NOI18N
        lbl_ruangan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ruangan.setText("R401");
        jLayeredPane1.add(lbl_ruangan);
        lbl_ruangan.setBounds(340, 30, 230, 110);

        lbl_dosen.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_dosen.setText("Bapak");
        jLayeredPane1.add(lbl_dosen);
        lbl_dosen.setBounds(930, 90, 350, 23);

        lbl_matkul.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_matkul.setText("Rekayasa Perangkat Lunak");
        jLayeredPane1.add(lbl_matkul);
        lbl_matkul.setBounds(930, 40, 360, 23);

        lbl_jamMasuk.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_jamMasuk.setText("07:00:00");
        jLayeredPane1.add(lbl_jamMasuk);
        lbl_jamMasuk.setBounds(940, 180, 110, 23);

        lbl_hari.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_hari.setText("Jumat");
        jLayeredPane1.add(lbl_hari);
        lbl_hari.setBounds(930, 130, 170, 23);

        lbl_jamKeluar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_jamKeluar.setText("07:00:00");
        jLayeredPane1.add(lbl_jamKeluar);
        lbl_jamKeluar.setBounds(1160, 180, 110, 23);

        lbl_jam.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_jam.setText("Jam dari");
        jLayeredPane1.add(lbl_jam);
        lbl_jam.setBounds(800, 190, 80, 23);

        lbl_jam1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_jam1.setText("jam");
        jLayeredPane1.add(lbl_jam1);
        lbl_jam1.setBounds(660, 170, 50, 23);

        tbl_data.setFont(new java.awt.Font("SansSerif", 0, 14));
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
        jScrollPane1.setBounds(320, 310, 290, 380);

        jLabel1.setFont(new java.awt.Font("HelveNueThin", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daftar Mahasiswa Hadir");
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(660, 270, 270, 30);

        jLabel2.setFont(new java.awt.Font("HelveNueThin", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Daftar Absensi Mahasiswa");
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(320, 270, 290, 30);

        tbl_data1.setFont(new java.awt.Font("SansSerif", 0, 14));
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
        jScrollPane2.setViewportView(tbl_data1);

        jLayeredPane1.add(jScrollPane2);
        jScrollPane2.setBounds(630, 310, 310, 380);

        jLabel3.setFont(new java.awt.Font("HelveNueThin", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Masukan NIM Anda :");
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(980, 270, 240, 30);

        lbl_tanggal.setText("tanggal");
        jLayeredPane1.add(lbl_tanggal);
        lbl_tanggal.setBounds(740, 170, 70, 20);

        lbl_tanggal1.setText("000000");
        jLayeredPane1.add(lbl_tanggal1);
        lbl_tanggal1.setBounds(740, 200, 70, 20);

        lbl_kodeJadwal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_kodeJadwal.setText("kode");
        jLayeredPane1.add(lbl_kodeJadwal);
        lbl_kodeJadwal.setBounds(680, 190, 60, 23);

        lbl_Matkul.setFont(new java.awt.Font("HelveNueThin", 1, 18)); // NOI18N
        lbl_Matkul.setForeground(new java.awt.Color(-1,true));
        lbl_Matkul.setText("Nama Mata Kuliah                    :");
        jLayeredPane1.add(lbl_Matkul);
        lbl_Matkul.setBounds(640, 40, 310, 23);

        lbl_Matkul1.setFont(new java.awt.Font("HelveNueThin", 1, 18)); // NOI18N
        lbl_Matkul1.setForeground(new java.awt.Color(-1,true));
        lbl_Matkul1.setText("Nama Dosen                            :");
        jLayeredPane1.add(lbl_Matkul1);
        lbl_Matkul1.setBounds(640, 90, 300, 23);

        lbl_Matkul2.setFont(new java.awt.Font("HelveNueThin", 1, 18)); // NOI18N
        lbl_Matkul2.setForeground(new java.awt.Color(-1,true));
        lbl_Matkul2.setText("Hari                                        :");
        jLayeredPane1.add(lbl_Matkul2);
        lbl_Matkul2.setBounds(640, 130, 310, 23);

        lbl_kontrakKode.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_kontrakKode.setText("jam");
        jLayeredPane1.add(lbl_kontrakKode);
        lbl_kontrakKode.setBounds(640, 190, 50, 23);

        lbl_jumlahAbsensi.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_jumlahAbsensi.setText("jumlah absensi");
        jLayeredPane1.add(lbl_jumlahAbsensi);
        lbl_jumlahAbsensi.setBounds(800, 170, 110, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/botKeluar.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jLabel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel4KeyPressed(evt);
            }
        });
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(1260, 650, 85, 80);

        lbl_ruangan1.setBackground(new java.awt.Color(0, 0, 0));
        lbl_ruangan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/BTN ABSEN.png"))); // NOI18N
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
        lbl_ruangan1.setBounds(1200, 310, 140, 60);

        txt_nim.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txt_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nimActionPerformed(evt);
            }
        });
        txt_nim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nimKeyTyped(evt);
            }
        });
        jLayeredPane1.add(txt_nim);
        txt_nim.setBounds(980, 310, 200, 60);

        lbl_NIP.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_NIP.setText("jam");
        jLayeredPane1.add(lbl_NIP);
        lbl_NIP.setBounds(770, 130, 120, 23);

        jLabel5.setFont(new java.awt.Font("HelveNueThin", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Masukan NIP Anda :");
        jLayeredPane1.add(jLabel5);
        jLabel5.setBounds(980, 390, 240, 30);

        txt_nip.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txt_nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nipActionPerformed(evt);
            }
        });
        txt_nip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nipKeyTyped(evt);
            }
        });
        jLayeredPane1.add(txt_nip);
        txt_nip.setBounds(980, 430, 200, 60);

        lbl_absensi.setBackground(new java.awt.Color(0, 0, 0));
        lbl_absensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/BTN ABSEN.png"))); // NOI18N
        lbl_absensi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_absensi.setOpaque(true);
        lbl_absensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_absensiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_absensiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_absensiMouseExited(evt);
            }
        });
        jLayeredPane1.add(lbl_absensi);
        lbl_absensi.setBounds(1200, 430, 140, 60);

        lbl_StatusDosen.setFont(new java.awt.Font("HelveNueThin", 1, 24)); // NOI18N
        lbl_StatusDosen.setText("jam");
        jLayeredPane1.add(lbl_StatusDosen);
        lbl_StatusDosen.setBounds(340, 140, 220, 60);

        lbl_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo/gambar/absens.png"))); // NOI18N
        lbl_BG.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lbl_BGAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLayeredPane1.add(lbl_BG);
        lbl_BG.setBounds(0, 0, 1360, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_BGAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbl_BGAncestorAdded
        // TODO add your handling code here:
   //     Header(lbl_ruangan.getText());
    }//GEN-LAST:event_lbl_BGAncestorAdded

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
         FrmMenuRuang fm = new FrmMenuRuang();
        fm.setVisible(true);
        dispose();
}//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4KeyPressed

    private void lbl_ruangan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        lbl_jam1.setText(lbl_jam.getText());
        cek_nim();

        txt_nim.setText("");
        //lbl_ruangan1.setEnabled(false);

    }//GEN-LAST:event_lbl_ruangan1MouseClicked

    private void lbl_ruangan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseEntered
        lbl_ruangan1.setBackground(Color.RED);
}//GEN-LAST:event_lbl_ruangan1MouseEntered

    private void lbl_ruangan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ruangan1MouseExited
        lbl_ruangan1.setBackground(Color.BLACK);
}//GEN-LAST:event_lbl_ruangan1MouseExited

    private void txt_nimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nimKeyTyped
        // TODO add your handling code here:
        
}//GEN-LAST:event_txt_nimKeyTyped

    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed
        // TODO add your handling code here:
        if(txt_nim.getText().equals(""))
        {
        lbl_ruangan1.setEnabled(false);
        }
        lbl_ruangan1.setEnabled(true);
    }//GEN-LAST:event_txt_nimActionPerformed

    private void txt_nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nipActionPerformed

    private void txt_nipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nipKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nipKeyTyped

    private void lbl_absensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_absensiMouseClicked
        // TODO add your handling code here:
        lbl_jam1.setText(lbl_jam.getText());

        cekNIP();
        txt_nip.setText("");
      
    }//GEN-LAST:event_lbl_absensiMouseClicked
public void cekNIP()
{
    if(txt_nip.getText().equals(lbl_NIP.getText()))
    {
            cek_2kaliNIP(txt_nip.getText());
              lbl_absensi.setEnabled(false);
    }
    else
    {
        JOptionPane.showMessageDialog(rootPane, "NIP Yang Anda Masukan Salah");
    }

}
public void cek_2kaliNIP(String nip)
{

    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("select nip from tbl_absensi_dosen where tanggal ='"+lbl_tanggal1.getText()+"' and jadwal_kode = '"+lbl_kodeJadwal.getText()+"' and nip='"+lbl_NIP.getText()+"'");

    rs.first();
    String nipp = rs.getString("nip");

        lbl_StatusDosen.setText("Dosen Hadir");
         JOptionPane.showMessageDialog(null, "Anda Sudah Absen");

    }
    catch(SQLException se)
                {
                      System.out.println("masuk ke catch"); 
            cektimedosen();

                }
}
public void cek_dosenudahHadir(String nip)
{

    try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("select nip from tbl_absensi_dosen where tanggal ='"+lbl_tanggal1.getText()+"' and jadwal_kode = '"+lbl_kodeJadwal.getText()+"' and nip='"+lbl_NIP.getText()+"'");

    rs.first();
    String nipp = rs.getString("nip");

        lbl_StatusDosen.setText("Dosen Hadir");
        jLabel5.setVisible(false);
        txt_nip.setVisible(false);
        lbl_absensi.setVisible(false);

    }
    catch(SQLException se)
                {
                       lbl_StatusDosen.setText("Dosen Belum Hadir");
                        jLabel5.setVisible(true);
                        txt_nip.setVisible(true);
                        lbl_absensi.setVisible(true);

                }
}

    private void lbl_absensiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_absensiMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_absensiMouseEntered

    private void lbl_absensiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_absensiMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_absensiMouseExited

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAbsensi1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_BG;
    private javax.swing.JLabel lbl_Matkul;
    private javax.swing.JLabel lbl_Matkul1;
    private javax.swing.JLabel lbl_Matkul2;
    private javax.swing.JLabel lbl_NIP;
    private javax.swing.JLabel lbl_StatusDosen;
    private javax.swing.JLabel lbl_absensi;
    private javax.swing.JLabel lbl_dosen;
    private javax.swing.JLabel lbl_hari;
    private javax.swing.JLabel lbl_jam;
    private javax.swing.JLabel lbl_jam1;
    private javax.swing.JLabel lbl_jamKeluar;
    private javax.swing.JLabel lbl_jamMasuk;
    private javax.swing.JLabel lbl_jumlahAbsensi;
    private javax.swing.JLabel lbl_kodeJadwal;
    private javax.swing.JLabel lbl_kontrakKode;
    private javax.swing.JLabel lbl_matkul;
    private javax.swing.JLabel lbl_ruangan;
    private javax.swing.JLabel lbl_ruangan1;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_tanggal1;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTable tbl_data1;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_nip;
    // End of variables declaration//GEN-END:variables

private static String filename;
private static Player player;

public static void play(String musik) {



    try {
            FileInputStream fis     = new FileInputStream("src/"+musik);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();
                }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();

    }

    public void close()
       {
           player.close();
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
}
