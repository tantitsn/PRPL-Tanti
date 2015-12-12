/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.modul;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ElHakim
 */
public class JButtonRenderer extends JButtonPanel implements TableCellRenderer {
    
    public JButtonRenderer(JButton[] buttons) {
        super(buttons);
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected?table.getSelectionBackground():Color.WHITE);
        //this.setBackground();
        return this;
    }
}
