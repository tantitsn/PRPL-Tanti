/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class FungsiDatabase {

     public Connection koneksi;

    public FungsiDatabase(Connection konek){
        this.koneksi = konek;
    }

    public ResultSet fQuery(String SQL_String) {
        ResultSet record;
        System.out.println(SQL_String);
        try {
            Statement st = koneksi.createStatement();
            record =  st.executeQuery(SQL_String);
      
            return record;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean fExecute(String SQL_String)
    {
        try {
           Statement st = koneksi.createStatement();
           boolean a =  st.execute(SQL_String);
           st.close();
           System.out.println("Query Leres");
           return true;
        } catch (Exception ex) {
            System.out.println("Query Lepat");
            ex.printStackTrace();
            return false;
        }
     }


    public boolean delete(String tabel, String where){
        String hapus = "Delete from "+tabel+" where "+where+"";
        return fExecute(hapus);
    }

     public boolean  deleteAll(String tabel){
        String hapus2="DELETE FROM "+tabel+"";
        return  fExecute(hapus2);
    }

    public boolean insert(String tabel, String fields, String isi){
        String sql = "INSERT INTO "+tabel+"("+fields+") VALUES("+isi+")";
        System.out.println(sql);
        boolean berhasil = fExecute(sql);
        return berhasil;
    }
    
    public boolean update(String tabel, String set, String where){
        String sql = "UPDATE "+tabel+" SET "+set+" WHERE "+where;
        System.out.println(sql);
        boolean berhasil = fExecute(sql);
        if(berhasil){
            return true;
        }else{
            return false;
        }
    }

    public void tampilToCombo(String sql, JComboBox combo){
        ResultSet rs;
        rs = fQuery(sql);
        combo.removeAllItems();
        try{
            while(rs.next()){
            combo.addItem(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public String tampilOneRecord(String sql){
        System.out.println(sql);
        String id = "";
        ResultSet rs;
        rs = fQuery(sql);
        try {
            if(rs != null){
               if(rs.first()){
                   id = rs.getString(1);
               }else{
                   id = null;
               }
            }else{
                id = null;
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }

        return id;
    }

    public String tampilLastRecord(String sql, String def){
        System.out.println(sql);
        String id = "";
        ResultSet rs;
        rs = fQuery(sql);
        try {
            if(rs != null){
                if(rs.last()){
                    id = rs.getString(1);
                }else{
                    id = def;
                }
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }

        return id;
    }

    public int tampilJumlahRec(String sql){
     return Integer.parseInt(tampilOneRecord(sql));

    }

    public boolean cekPass(String[] data){
        String sql = "SELECT pass FROM login WHERE username = '"+data[0]+"' "
                + "AND pass = '"+data[1]+"' AND kat = '"+data[2]+"'";
        ResultSet rs = fQuery(sql);
        boolean status = false;
        try{
            if(rs != null){
                if(rs.first()){
                    status = true;
                    System.out.println(status);
                }else{
                    status = false;
                }
            }else{
                status = false;
            }
        }catch(SQLException s){

        }
        return status;
    }
}
