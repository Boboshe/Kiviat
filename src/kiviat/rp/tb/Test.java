/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pierre
 */
public class Test extends JFrame {
    
    private Kiviat pan = new Kiviat();
    

    public Test(){

        this.setTitle("Animation");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
//Ajout du bouton à notre content pane
        JButton bouton = new JButton("Mon bouton");
        ItemKiviat item1 = new ItemKiviat(45.0, 0.0, 0.0, 10.0);
        pan.add(item1);
        this.setContentPane(pan);
        this.setVisible(true);
    }       
}
