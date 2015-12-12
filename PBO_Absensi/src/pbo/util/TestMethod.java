/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tanti
 */
public class TestMethod {
    public static String tglToDMY(String tglAsal){
        SimpleDateFormat frm = new SimpleDateFormat("dd MMMMM yyyy");
        Date dt = Date.valueOf(tglAsal);
        return frm.format(dt);
    }
    public static void setToCenter(JFrame form){
        java.awt.Dimension screenRes = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation((screenRes.width/2)-(form.getWidth()/2), (screenRes.height/2)-(form.getHeight()/2));
    }
     public static void setToCenter(JDialog form){
        java.awt.Dimension screenRes = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation((screenRes.width/2)-(form.getWidth()/2), (screenRes.height/2)-(form.getHeight()/2));
    }
     public static int messageQuestion(String pesan){
        int pilihan;
        pilihan = JOptionPane.showConfirmDialog(null, pesan, "Konfirmasi", 0);
        return pilihan;
    }
     public static void pesan(String pesan, String title){
        JOptionPane.showMessageDialog(null, pesan, title,1);

    }
}
