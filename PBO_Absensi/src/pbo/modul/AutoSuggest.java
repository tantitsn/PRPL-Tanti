/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.modul;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class AutoSuggest{
    private final JTextField tf;
    private final JComboBox combo = new JComboBox();
    private final Vector<String> v = new Vector<String>();

    public AutoSuggest(String[] data) {
       
        combo.setEditable(true);
        tf = (JTextField) combo.getEditor().getEditorComponent();
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                EventQueue.invokeLater(new Runnable() {
                public void run() {
                    String t = tf.getText();
                    String depan,text="";
                    if(t.length()==0) {
                        combo.hidePopup();
                        setModel(new DefaultComboBoxModel(v), "");
                    }else{
                        depan = String.valueOf(t.charAt(0)).toUpperCase();
                        text = tf.getText();
                        DefaultComboBoxModel m = getSuggestedModel(v, text);
                        if(m.getSize()==0 || hide_flag) {
                            combo.hidePopup();
                            hide_flag = false;
                        }else{
                            setModel(m, text);
                            combo.showPopup();
                        }
                    }
                }
            });
         }
           public void keyPressed(KeyEvent e) {
                String text = tf.getText();
                int code = e.getKeyCode();
                if(code==KeyEvent.VK_ENTER) {
                    if(!v.contains(text)) {
                        v.addElement(text);
                        Collections.sort(v);
                        setModel(getSuggestedModel(v, text), text);
                    }
                    hide_flag = true;
                }else if(code==KeyEvent.VK_ESCAPE) {
                    hide_flag = true;
                }else if(code==KeyEvent.VK_RIGHT) {
                    for(int i=0;i<v.size();i++) {
                        String str = v.elementAt(i);
                        if(str.startsWith(text)) {
                            combo.setSelectedIndex(-1);
                            tf.setText(str);
                            return;
                        }
                    }
                }
                }
          });

      for(int i=0;i<data.length;i++){
              v.addElement(data[i]);
      }
      setModel(new DefaultComboBoxModel(v), "");
//        JPanel p = new JPanel(new BorderLayout());
//        p.setBorder(BorderFactory.createTitledBorder("AutoSuggestion Box"));
//        p.add(combo, BorderLayout.NORTH);
//        add(p);
//        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//        setPreferredSize(new Dimension(300, 150));
    }

    public JComboBox getAuto(){
        return this.combo;
    }
    
    private boolean hide_flag = false;
    private void setModel(DefaultComboBoxModel mdl, String str) {
        combo.setModel(mdl);
        combo.setSelectedIndex(-1);
        tf.setText(str);
    }
    private static DefaultComboBoxModel getSuggestedModel(java.util.List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for(String s: list) {
            if(s.toUpperCase().contains(text.toUpperCase())) m.addElement(s);
        }
        return m;
    }
    
//    public static void main(String[] args) {
//       JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//                String[] countries = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola","Argentina"
//,"Armenia","Austria","Bahamas","Bahrain", "Bangladesh","Barbados", "Belarus","Belgium",
//"Benin","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","Bulgaria",
//"Burkina Faso","Burma","Burundi","Cambodia","Cameroon","Canada", "China","Colombia",
//"Comoros","Congo","Croatia","Cuba","Cyprus","Czech Republic","Denmark", "Georgia",
//"Germany","Ghana","Great Britain","Greece","Hungary","Holland","India","Iran","Iraq",
//"Italy","Somalia", "Spain", "Sri Lanka", "Sudan","Suriname", "Swaziland","Sweden",
//"Switzerland", "Syria","Uganda","Ukraine","United Arab Emirates","United Kingdom",
//"United States","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam",
//"Yemen","Zaire","Zambia","Zimbabwe"};
//        frame.getContentPane().add(new AutoSuggest(countries));
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
    }