/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class ConectionDB {
Connection con;
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
