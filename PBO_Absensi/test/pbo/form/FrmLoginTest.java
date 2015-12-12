/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.form;

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
public class FrmLoginTest {
    
    public FrmLoginTest() {
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
     * Test of openConnection method, of class FrmLogin.
     */
    @Test
    public void testOpenConnection() {
        System.out.println("openConnection");
        FrmLogin instance = new FrmLogin();
        instance.openConnection();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class FrmLogin.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrmLogin.main(args);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
