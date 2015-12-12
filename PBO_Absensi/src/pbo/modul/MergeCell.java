/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.modul;

/**
 *
 * @author Yakuza Ayame
 */
import pbo.util.FungsiDatabase;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.*;
import javax.swing.*;

public class MergeCell extends JFrame{
    Object[][] data = null;
    String[] columns = {"Mata Pelajaran","SK"};
    JTable jTableData;
    AbstractTableModel modelo;
    FungsiDatabase fdb;
    String mpl;
    
    public MergeCell(JTable table, String Mapel){
        jTableData = table;
        mpl = Mapel;
        getDataModel();
        //jTableData = new JTable();
        


        modelo = new AbstractTableModel() {
            @Override
            public String getColumnName(int col) {
                return columns[col].toString();
            }

            @Override
            public Class getColumnClass(int col) {
                if(getRowCount() <1)return null;
                return data[0][col].getClass();
            }

            public int getRowCount() { 
                return data.length;
            }

            public int getColumnCount() {
                return columns.length;
            }

            public Object getValueAt(int row, int col) {
                return data[row][col];
            }

            @Override
            public boolean isCellEditable(int row, int col){ 
                return true;
            }

            @Override
            public void setValueAt(Object value, int row, int col) {
                data[row][col] = value;
                fireTableCellUpdated(row, col);
            }};

            /* We apply the model to the main jTable */
            jTableData.setModel(modelo);

    /* We create a cell Renderer to display the data of the multivalue
    fields*/
    TableCellRenderer jTableCellRenderer = new TableCellRenderer() {
        /* These are necessary variables to store the row’s height */
        private int minHeight = -1;
        private int currHeight = -1;

        /* Magic Happens */
        public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {

        /* If what we’re displaying isn’t an array of values we
        return the normal renderer*/
            if(!value.getClass().isArray()){
                return table.getDefaultRenderer(
                value.getClass()).getTableCellRendererComponent(
                table, value, isSelected, hasFocus,row, column);
            }else{
                final Object[] passed = (Object[])value;
                /* We calculate the row’s height to display data
                * THis is not complete and has some bugs that
                * will be analyzed in further articles */
                if(minHeight == -1){
                    minHeight = table.getRowHeight();
                }
                if(currHeight != passed.length*minHeight){
                    currHeight = passed.length * minHeight;
                    table.setRowHeight(row,currHeight);
                }
                /* We create the table that will hold the multivalue
                *fields and that will be embedded in the main table */
                return new JTable(
                new AbstractTableModel() {
                    public int getColumnCount() {
                        return 1;
                    }

                    public int getRowCount() {
                        return passed.length;
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return passed[rowIndex];
                    }

                        @Override
                    public boolean isCellEditable(int row, int col){ return true; }
                });
            }
        }
    };
    /* Finally we apply the new cellRenderer to the whole table */
    TableColumnModel tcm = jTableData.getColumnModel();
    for(int it = 0; it < tcm.getColumnCount(); it++){
        tcm.getColumn(it).setCellRenderer(jTableCellRenderer);
    }
    /*Note: if we need to edit the values inside the embedded jtable
    * we will need to create a TableCellEditor too. */
//    add (jTableData);
//    setSize(400,400);

    }

    public AbstractTableModel getModel(){
        return modelo;
    }
//    public static void main(String a[])
//    {
//        new MergeCell().setVisible(true);
//    }

    public void getDataModel() {
        ResultSet rs,rs2,rs3,rs4,rs5;
        data = new Object[1][columns.length];
        data[0][0] = mpl;
        String[] sk = new String[100];
        int i = 0;
        rs = fdb.fQuery("SELECT t_skp.SKP_NMSKP " +
                "FROM t_mpl " +
                "LEFT JOIN t_skp ON t_mpl.MPL_IDMPL = t_skp.MPL_IDMPL " +
                "WHERE t_mpl.MPL_NMMPL = '"+ mpl +"' ");
        try {
            while(rs.next()){
                sk[i] = rs.getString(1);
                i++;
            }
            data[0][1] = sk;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        rs2 = fdb.fQuery("");

        for (int j = 0; j < sk.length; j++) {
            System.out.println(sk[j]);
        } 
        
            
        }
//        data[0][0] = "Peter";
//        String[] sk = {"1. Mecoba","2. Merasa"};
//        data[0][1] = sk;
//        //data[0][1] = "tes";
//        String[] phones = {"555 35 25 65" , "555 35 24 63", "555 34 34 12"};
//        data[0][2] = phones;
//        data[0][3] = new Date();
        
    
}