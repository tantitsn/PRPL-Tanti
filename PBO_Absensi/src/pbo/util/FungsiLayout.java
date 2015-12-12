/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.util;


import pbo.modul.AutoSuggest;
import pbo.modul.JButtonEditor;
import pbo.modul.JButtonRenderer;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrintManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author ElHakim
 */
public class  FungsiLayout {

    public static void setToCenter(JFrame form){
        java.awt.Dimension screenRes = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation((screenRes.width/2)-(form.getWidth()/2), (screenRes.height/2)-(form.getHeight()/2));
    }

      public static void setToCenter(JDialog form){
        java.awt.Dimension screenRes = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation((screenRes.width/2)-(form.getWidth()/2), (screenRes.height/2)-(form.getHeight()/2));
    }

    public static void openInternalFrame(JDesktopPane dPane, JInternalFrame iFrame){
        if(!iFrame.isVisible())
        {
            dPane.add(iFrame);
            iFrame.setSize(dPane.getSize());
            iFrame.setLocation(0,0);
            iFrame.setClosable(true);
            iFrame.setMaximizable(true);
            iFrame.setIconifiable(true);
            iFrame.setResizable(true);
            iFrame.setVisible(true);
        }
        else if(iFrame.isIcon())
        {
            try {
                iFrame.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FungsiLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(!iFrame.isSelected())
        {
            try {
                iFrame.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FungsiLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static int messageQuestion(String pesan){
        int pilihan;
        pilihan = JOptionPane.showConfirmDialog(null, pesan, "Konfirmasi", 0);
        return pilihan;
    }

    public static String tglToDMY(String tglAsal){
        SimpleDateFormat frm = new SimpleDateFormat("dd MMMMM yyyy");
        Date dt = Date.valueOf(tglAsal);
        return frm.format(dt);
    }

    public static java.util.List<JButton> setButtonTable(JTable table, int column, JButton[] button){
        TableColumn col = table.getColumnModel().getColumn(column);
        col.setCellRenderer(new JButtonRenderer(button));
        JButtonEditor bEdit = new JButtonEditor(table, button);
        col.setCellEditor(bEdit);

        MouseListener ml = clickMouse(table);

        java.util.List<JButton> buttons = java.util.Arrays.asList(bEdit.getButton());
        for(int i = 0; i<button.length;i++){
            buttons.get(i).addMouseListener(ml);
        }

        return buttons;
    }

    public static MouseListener clickMouse(final JTable table){
       return  new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ButtonModel m = ((JButton)e.getSource()).getModel();
                if(m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    table.setBackground(table.getBackground());
                }
            }
        };
    }

    public static void setMaximize(JFrame f){
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        f.setMaximizedBounds(e.getMaximumWindowBounds());
        f.setExtendedState( f.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void setColumnHidden(JTable table, String col){
        table.getColumn(col).setWidth(0);
        table.getColumn(col).setMinWidth(0);
        table.getColumn(col).setMaxWidth(0);
    }
    public static void setIntFrameMax(JInternalFrame iFrame){
        try {
            iFrame.setMaximum(true);
        } catch (PropertyVetoException ex) {
            //Logger.getLogger(parentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setColumnWidth(JTable tabel, int[] width){
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn[] col = new TableColumn[width.length];
        for(int i=0;i<width.length;i++){
            col[i] = tabel.getColumnModel().getColumn(i);
            col[i].setPreferredWidth(width[i]);
        }
    }

    public static void setColumnAligment(JTable tabel, int column, int Aligment){
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(Aligment);
        tabel.getColumnModel().getColumn(column).setCellRenderer(renderer);
    }

     public static String autoID(String idLast, String pattern){
        String lastId = String.valueOf(idLast.substring(3));
        String idFaktur = String.valueOf(Integer.parseInt(lastId)+1);
        String idDepan = "";
        switch(idFaktur.length()){
//            case 0: idDepan = "00000";break;
//            case 1: idDepan = "0000";break;
            case 1: idDepan = "000";break;
            case 2: idDepan = "00";break;
            case 3: idDepan = "0";break;
            case 4: idDepan = "";break;
        }

        return pattern+idDepan+idFaktur;
    }

    public static void setIcon(JFrame frame, String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(frame.getClass().getResource(path));
            System.out.println(img);
        } catch (Exception e) {
        }

        frame.setIconImage(img);
    }

    public static void setIcon(JDialog frame, String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(frame.getClass().getResource(path));
            System.out.println(img);
        } catch (Exception e) {
        }

        frame.setIconImage(img);
    }

    public static void Laporan(Connection konek, Map p, String source, boolean view){
        //Map<String, String> p = new HashMap<String, String>();

//        p.put("no_faktur", param[0]);
//        p.put("id_sales", param[1]);
        try {
            //ClassLoader cl = CustomerOrder.class.getClassLoader();
//            URL ul = getClass().getResource("");
//            File f = new File(ul.toURI());
//            System.out.println(f.getPath());
//            JasperDesign design = JRXmlLoader.load(f.getPath());
//            System.out.println(source);
//            JasperReport report = JasperCompileManager.compileReport(source);
//            JasperPrint print = JasperFillManager.fillReport(report, p, konek);
//            if(view){
//                JasperViewer.viewReport(print, false);
//            }else{
//                JasperPrintManager.printPage(print, 0, false);
//            }

        } catch (Exception ex) {
            FungsiLayout.pesan("REPORT ERROR", "Perhatian");
            ex.printStackTrace();
        }
    }

    public static void setRowHeight(JTable table, int height){
        table.setRowHeight(height);
    }

    public static void pesan(String pesan, String title){
        JOptionPane.showMessageDialog(null, pesan, title,1);

    }

    public static JComboBox setAutoSuggest(String[] data, int[] posisi){
        AutoSuggest txtAuto = new AutoSuggest(data);
        JComboBox combo = txtAuto.getAuto();
        combo.setBounds(posisi[0], posisi[1], posisi[2], posisi[3]);
        combo.setVisible(true);
        return combo;
    }

    public static void lookAndFeel(){
        try {
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(className.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Maaf Class Tidak Ditemukan");
        } catch (InstantiationException ex) {
            //Logger.getLogger(className.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Maaf Instansiaisi Error");
        } catch (IllegalAccessException ex) {
            //Logger.getLogger(className.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Maaf Akses Class  Ilegal");
        } catch (UnsupportedLookAndFeelException ex) {
            //Logger.getLogger(className.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Maaf Class Tidak Support");
        }
   }
}
