/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author pierre
 */
public class Kiviat extends JPanel{
    
    BorderLayout layout = new BorderLayout();
    
    public Kiviat(){
        
        this.setLayout(layout);
   
    }
    
    
    
    public void addLine(){
        ItemKiviat item1 = new ItemKiviat(45.0, 5.0, 0.0, 10.0);
        JButton bouton = new JButton("Mon bouton");
        layout.addLayoutComponent(bouton, BorderLayout.CENTER);
    }

    
}
