/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.modul;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JDesktopPane;

/**
 *
 * @author Martinus Ady H <mrt.itnewbies@gmail.com>
 *         Edited by El Hakim
 */
public class DesktopPaneBK extends JDesktopPane {

    private Image image;
    private String path;
 
    public DesktopPaneBK() {
      
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            image = new javax.swing.ImageIcon(getClass().getResource("/com/siti/gambar/bgBimbinganKonseling.png")).getImage();

            if (g != null) {
                g.drawImage(image,
                        (this.getSize().width - image.getWidth(null)) / 2,
                        (this.getSize().height - image.getHeight(null)) / 2,
                        null);
            }
        } catch (NullPointerException npe) {
            System.out.println("Can't find images !!");
        }
    }
}
