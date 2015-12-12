/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.modul;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractButton;
import javax.swing.JTable;

/**
 *
 * @author ElHakim
 */
public class MyItemListener implements ItemListener{
    JTable table;
    int col;
    public MyItemListener(JTable tbl, int col){
        table = tbl;
        this.col = col;
    }
    public void itemStateChanged(ItemEvent e) {
      Object source = e.getSource();
      if (source instanceof AbstractButton == false) return;
      boolean checked = e.getStateChange() == ItemEvent.SELECTED;
      for(int x = 0, y = table.getRowCount(); x < y; x++)
      {
        table.setValueAt(new Boolean(checked),x, col);
      }
    }
  }
