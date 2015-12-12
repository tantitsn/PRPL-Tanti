/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.modul;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
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
public class CheckBoxHeaderTest {
    
    public CheckBoxHeaderTest() {
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
     * Test of getTableCellRendererComponent method, of class CheckBoxHeader.
     */
    @Test
    public void testGetTableCellRendererComponent() {
        System.out.println("getTableCellRendererComponent");
        JTable table = null;
        Object value = null;
        boolean isSelected = false;
        boolean hasFocus = false;
        int row = 0;
        int column = 0;
        CheckBoxHeader instance = null;
        Component expResult = null;
        Component result = instance.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setColumn method, of class CheckBoxHeader.
     */
    @Test
    public void testSetColumn() {
        System.out.println("setColumn");
        int column = 0;
        CheckBoxHeader instance = null;
        instance.setColumn(column);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getColumn method, of class CheckBoxHeader.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        CheckBoxHeader instance = null;
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of handleClickEvent method, of class CheckBoxHeader.
     */
    @Test
    public void testHandleClickEvent() {
        System.out.println("handleClickEvent");
        MouseEvent e = null;
        CheckBoxHeader instance = null;
        instance.handleClickEvent(e);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of mouseClicked method, of class CheckBoxHeader.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = null;
        CheckBoxHeader instance = null;
        instance.mouseClicked(e);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of mousePressed method, of class CheckBoxHeader.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        CheckBoxHeader instance = null;
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of mouseReleased method, of class CheckBoxHeader.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = null;
        CheckBoxHeader instance = null;
        instance.mouseReleased(e);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of mouseEntered method, of class CheckBoxHeader.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent e = null;
        CheckBoxHeader instance = null;
        instance.mouseEntered(e);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of mouseExited method, of class CheckBoxHeader.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = null;
        CheckBoxHeader instance = null;
        instance.mouseExited(e);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
