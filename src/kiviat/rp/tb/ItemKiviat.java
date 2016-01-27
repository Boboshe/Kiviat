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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/**
 *
 * @author Boris
 */
public class ItemKiviat extends JComponent {

    private Line2D line;
    private double lineLength = 150;
    private double angle;
    private double size = 400;
    private double decalage = 10; 
    private double centreX = size/2;
    private double centreY = size/2;

    private Ellipse2D cursor;
    private double cursorSize = 5;

    private double value;

    
    private double min;
    private double max;

    public ItemKiviat(double angle, double value, double min, double max) {
        super();
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
        cursor = new Ellipse2D.Double(cursorCoord.x, cursorCoord.y, cursorSize, cursorSize);
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
        return new Point2D.Double(x,y);
    }
}
