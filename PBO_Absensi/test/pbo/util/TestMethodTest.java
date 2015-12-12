/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.util;

import javax.swing.JDialog;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pbo.form.FrmSplash;
import pbo.form.coba;

/**
 *
 * @author tanti
 */
public class TestMethodTest {
    
    public TestMethodTest() {
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
     * Test of tglToDMY method, of class TestMethod.
     */
    @Test
    public void testTglToDMY() {
        System.out.println("tglToDMY");
        String tglAsal = "2013-09-15";
        String expResult = "15 September 2013";
        String result = TestMethod.tglToDMY(tglAsal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setToCenter method, of class TestMethod.
     */
    @Test
    public void testSetToCenter_JFrame() {
        System.out.println("setToCenter");
        JFrame form = new coba();
        TestMethod.setToCenter(form);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setToCenter method, of class TestMethod.
     */
    @Test
    public void testSetToCenter_JDialog() {
        System.out.println("setToCenter");
        JDialog form = new FrmSplash(null, true);
        TestMethod.setToCenter(form);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of messageQuestion method, of class TestMethod.
     */
    @Test
    public void testMessageQuestion() {
        System.out.println("messageQuestion");
        String pesan = "Apakah anda ingin menghapusnya?";
        int expResult = 0;
        int result = TestMethod.messageQuestion(pesan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of pesan method, of class TestMethod.
     */
    @Test
    public void testPesan() {
        System.out.println("pesan");
        String pesan = "Selamat Datang";
        String title = "Information";
        TestMethod.pesan(pesan, title);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
