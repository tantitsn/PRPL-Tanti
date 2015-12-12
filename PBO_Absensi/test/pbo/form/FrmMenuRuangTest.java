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
public class FrmMenuRuangTest {
    
    public FrmMenuRuangTest() {
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
     * Test of openConnection method, of class FrmMenuRuang.
     */
    @Test
    public void testOpenConnection() {
        System.out.println("openConnection");
        FrmMenuRuang instance = new FrmMenuRuang();
        instance.openConnection();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of fQuery method, of class FrmMenuRuang.
     */
    @Test
    public void testFQuery() {
        System.out.println("fQuery");
        String SQL_String = "";
        FrmMenuRuang instance = new FrmMenuRuang();
        ResultSet expResult = null;
        ResultSet result = instance.fQuery(SQL_String);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of panggilRuang method, of class FrmMenuRuang.
     */
    @Test
    public void testPanggilRuang() {
        System.out.println("panggilRuang");
        FrmMenuRuang instance = new FrmMenuRuang();
        instance.panggilRuang();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of main method, of class FrmMenuRuang.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrmMenuRuang.main(args);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of play method, of class FrmMenuRuang.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        String musik = "";
        FrmMenuRuang.play(musik);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of close method, of class FrmMenuRuang.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        FrmMenuRuang instance = new FrmMenuRuang();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
