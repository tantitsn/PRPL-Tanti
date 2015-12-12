/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.modul;

import javax.swing.JComboBox;
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
public class AutoSuggestTest {
     private final JComboBox combo = new JComboBox();
    public AutoSuggestTest() {
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
     * Test of getAuto method, of class AutoSuggest.
     */
    @Test
      
     
    public void testGetAuto() {
        System.out.println("getAuto");
        AutoSuggest instance = null;
        JComboBox expResult = null;
        JComboBox result = instance.getAuto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
