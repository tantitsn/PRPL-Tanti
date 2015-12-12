/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.modul;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ElHakim
 */
class JButtonPanel extends JPanel {
    
    public JButtonPanel(final JButton[] buttons) {
        super();

        java.util.List<JButton> button = java.util.Arrays.asList(setNewButton(buttons));
        setOpaque(true);
        for(JButton b: button) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
        }
    }

    private JButton[] setNewButton(JButton[] buttons){
        int jml = buttons.length;
        String[] nama = new String[jml];
        for(int i=0;i<jml;i++){
            nama[i] = buttons[i].getText();
            buttons[i] = new JButton(nama[i]);
        }
       return buttons;
    }

}
