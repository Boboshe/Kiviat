/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author pierre
 */
public class Main {
    
    public static void main(String args[]) {
        // Création de la fenêtre
    JFrame frame = new JFrame ("PlotComponent");
    frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
    frame.setSize (new Dimension (300, 200));
 
    Kiviat pan = new Kiviat();
 
    // Construction de la fenêtre
    ItemKiviat item1 = new ItemKiviat(10.0, 5.0, 0.0, 10.0);
    JButton bouton = new JButton("Mon bouton");
    
    
    frame.setContentPane(pan);
    pan.addLine();
    
    //frame.getContentPane().add (item1);
 
    // On affiche la fenêtre
    frame.setVisible (true);
    }
    
}
