/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.form;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tanti
 */
public class FrmMenuUtamaTest {
    
    public FrmMenuUtamaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of openConnection method, of class FrmMenuUtama.
     */
    @Test
    public void testOpenConnection() {
        System.out.println("openConnection");
        FrmMenuUtama instance = new FrmMenuUtama();
        instance.openConnection();
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of fQuery method, of class FrmMenuUtama.
     */
    @Test
    public void testFQuery() {
        System.out.println("fQuery");
        String SQL_String = "";
        FrmMenuUtama instance = new FrmMenuUtama();
        ResultSet expResult = null;
        ResultSet result = instance.fQuery(SQL_String);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of main method, of class FrmMenuUtama.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrmMenuUtama.main(args);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
