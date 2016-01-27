/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author pierre
 */
public class Component2 extends JComponent {
    
    public Component2(){
        super();
    }
    
    public void paint(Graphics g){
        g.drawString ("Hello World !", 50, 50);
    }
    
}
