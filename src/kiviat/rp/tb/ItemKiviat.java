
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/**
 *
 * @author Boris
 */
public class ItemKiviat extends JComponent implements MouseListener, MouseMotionListener{

    //Taille du composant
    private double size = 400;
    
    private Line2D line;
    private Ellipse2D cursor;
    
    private double lineLength = 150;
    private double decalage = 10; 
    private double centreX = size/2;
    private double centreY = size/2;
    private double cursorSize = 10;
    private Point2D.Double pi;
    private Point2D.Double pf;

    private String name;
    private double angle;
    private double value;
    private double min;
    private double max;
    

    public ItemKiviat(String name, double angle, double value, double min, double max) {
        super(); 
           
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        this.name = name;
        this.angle = angle;
        this.value = value;
        this.min = min;
        this.max = max;
        
        //Point de début et fin de la ligne
        pi = debutLine();
        pf = finLine();
        
        cursor = new Ellipse2D.Double(valuetoCoordCursor(miseEchelle(value)).x, valuetoCoordCursor(miseEchelle(value)).y, cursorSize, cursorSize);
        line = new Line2D.Float(pi, pf);
    }
    
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void paint(Graphics _g) {
        
        Graphics2D g = (Graphics2D) _g;
        g.setStroke(new BasicStroke(2));
        
        g.draw(line);
        g.setColor(Color.red);
        g.draw(cursor);
        
        //Ellipse2D.Double circle = new Ellipse2D.Double((size-((lineLength+decalage)*2))/2,(size-((lineLength+decalage)*2))/2, (lineLength+decalage)*2,(lineLength+decalage)*2);
        //g.draw(circle);
        
    }

    public ItemKiviat() {
//        line = new Line2D.Float(centre.x, centre.y, xAngle, yAngle);
//        cursor = new Ellipse2D.Float(x, y, cursorSize, cursorSize);

    }
    
    private Point2D.Double debutLine(){
        double x = Math.cos(Math.toRadians(angle)) * decalage;
        double y = -Math.sin(Math.toRadians(angle)) * decalage;
        x += centreX;
        y += centreY;
        return new Point2D.Double(x,y);        
    }
    
    private Point2D.Double finLine(){
        double x = Math.cos(Math.toRadians(angle)) * (lineLength+decalage);
        double y = -Math.sin(Math.toRadians(angle)) * (lineLength+decalage);
        x += centreX;
        y += centreY;
        return new Point2D.Double(x,y);
    }
    
    @Override
    public boolean contains(int x, int y){
        return cursor.contains((double)x,(double)y);
    }
    
    
    private double miseEchelle(double val){
        double interval = max - min;
        double pas = 0.0;
        if (interval != 0.0) {
            pas = lineLength / interval;
        }
        double res = pas * (val-min);
        return res;
    }
    
    private Point2D.Double valuetoCoordCursor(double val) {
        
        double x = Math.cos(Math.toRadians(angle)) * (val+decalage);
        double y = -Math.sin(Math.toRadians(angle)) * (val+decalage);
        x += centreX;
        y += centreY;
        
        //On centre le curseur sur la ligne
        x -= cursorSize/2;
        y -= cursorSize/2;
        return new Point2D.Double(x,y);
    }
    
    public double projectOrtho(int x, int y){
        double r2 = (x - pi.x) * (x - pi.x) + (y - pi.y) * (y - pi.y); 
        double cosa = (double) (x - pi.x) / (double) Math.pow(r2, 0.5); 
        double sina = (double) (y - pi.y) / (double) Math.pow(r2, 0.5); 
        double alpha = (double) Math.acos(cosa); 
        if (sina >= 0) { 
            alpha *= -1; 
        } 
        double l = (double) (Math.pow(r2, 0.5) * Math.cos(alpha - Math.toRadians(angle))); 
         l = (l < 0) ? 0 : l; 
         l = (l > lineLength) ? lineLength : l; 
         
         //int newValue = Math.round(min + l / R * (max - min)); 
         return l;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("Clique : X : " + x + " ; " + " Y : " + y);
        
        if(this.contains(x, y)){
            System.out.println("Item : " + name);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double l = projectOrtho(e.getX(), e.getY());
        
        cursor.setFrame(valuetoCoordCursor(l).x, valuetoCoordCursor(l).y, cursorSize, cursorSize);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
 
    }

    
}

