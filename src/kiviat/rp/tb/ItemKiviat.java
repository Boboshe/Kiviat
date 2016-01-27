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

    private Line2D line;
    private double lineLength = 150;
    private double angle;
    private double size = 400;
    private double decalage = 10; 
    private double centreX = size/2;
    private double centreY = size/2;

    private Ellipse2D cursor;
    private double cursorSize = 10;

    private double value;

    
    private double min;
    private double max;
    private String name;

    public ItemKiviat(String name, double angle, double value, double min, double max) {
        super();
        cursor = new Ellipse2D.Double();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.name = name;
        this.angle = angle;
        this.value = value;
        this.min = min;
        this.max = max;
    }
    
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void paint(Graphics _g) {
        Graphics2D g = (Graphics2D) _g;
        g.setStroke(new BasicStroke(2));
        line = new Line2D.Float(debutLine(), finLine());
        Point2D.Double cursorCoord = valuetoCoordCursor();
        cursor.setFrame(cursorCoord.x, cursorCoord.y, cursorSize, cursorSize);
        g.draw(line);
        g.setColor(Color.red);
        g.draw(cursor);
        Ellipse2D.Double circle = new Ellipse2D.Double((size-((lineLength+decalage)*2))/2,(size-((lineLength+decalage)*2))/2, (lineLength+decalage)*2,(lineLength+decalage)*2);
        g.draw(circle);
        
    }

    public ItemKiviat() {
//        line = new Line2D.Float(centre.x, centre.y, xAngle, yAngle);
//        cursor = new Ellipse2D.Float(x, y, cursorSize, cursorSize);

    }
    
    private Point2D debutLine(){
        double x = Math.cos(Math.toRadians(angle)) * decalage;
        double y = -Math.sin(Math.toRadians(angle)) * decalage;
        x += centreX;
        y += centreY;
        return new Point2D.Double(x,y);        
    }
    
    private Point2D finLine(){
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
    
    
    
    
   

    private Point2D.Double valuetoCoordCursor() {
        double interval = max - min;
        double pas = 0.0;
        if (interval != 0.0) {
            pas = lineLength / interval;
        }
        double rayon = pas * (value-min);
        double x = Math.cos(Math.toRadians(angle)) * (rayon+decalage);
        double y = -Math.sin(Math.toRadians(angle)) * (rayon+decalage);
        x += centreX;
        y += centreY;
        
        //On centre le curseur sur la ligne
        x -= cursorSize/2;
        y -= cursorSize/2;
        return new Point2D.Double(x,y);
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
        System.out.println("Drag");
        cursor.setFrame(e.getX(), e.getY(), cursorSize, cursorSize);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
 
    }

    
}
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

    private Line2D line;
    private double lineLength = 150;
    private double angle;
    private double size = 400;
    private double decalage = 10; 
    private double centreX = size/2;
    private double centreY = size/2;

    private Ellipse2D cursor;
    private double cursorSize = 10;

    private double value;

    
    private double min;
    private double max;
    private String name;

    public ItemKiviat(String name, double angle, double value, double min, double max) {
        super();
        cursor = new Ellipse2D.Double();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.name = name;
        this.angle = angle;
        this.value = value;
        this.min = min;
        this.max = max;
    }
    
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void paint(Graphics _g) {
        Graphics2D g = (Graphics2D) _g;
        g.setStroke(new BasicStroke(2));
        line = new Line2D.Float(debutLine(), finLine());
        Point2D.Double cursorCoord = valuetoCoordCursor();
        cursor.setFrame(cursorCoord.x, cursorCoord.y, cursorSize, cursorSize);
        g.draw(line);
        g.setColor(Color.red);
        g.draw(cursor);
        Ellipse2D.Double circle = new Ellipse2D.Double((size-((lineLength+decalage)*2))/2,(size-((lineLength+decalage)*2))/2, (lineLength+decalage)*2,(lineLength+decalage)*2);
        g.draw(circle);
        
    }

    public ItemKiviat() {
//        line = new Line2D.Float(centre.x, centre.y, xAngle, yAngle);
//        cursor = new Ellipse2D.Float(x, y, cursorSize, cursorSize);

    }
    
    private Point2D debutLine(){
        double x = Math.cos(Math.toRadians(angle)) * decalage;
        double y = -Math.sin(Math.toRadians(angle)) * decalage;
        x += centreX;
        y += centreY;
        return new Point2D.Double(x,y);        
    }
    
    private Point2D finLine(){
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
    
    
    
    
   

    private Point2D.Double valuetoCoordCursor() {
        double interval = max - min;
        double pas = 0.0;
        if (interval != 0.0) {
            pas = lineLength / interval;
        }
        double rayon = pas * (value-min);
        double x = Math.cos(Math.toRadians(angle)) * (rayon+decalage);
        double y = -Math.sin(Math.toRadians(angle)) * (rayon+decalage);
        x += centreX;
        y += centreY;
        
        //On centre le curseur sur la ligne
        x -= cursorSize/2;
        y -= cursorSize/2;
        return new Point2D.Double(x,y);
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
        System.out.println("Drag");
        cursor.setFrame(e.getX(), e.getY(), cursorSize, cursorSize);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
 
    }

    
}
