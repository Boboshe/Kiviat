
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    private Point2D.Double coordCursor;
    private double valueOnDrag;
    

    private DefaultTableModel m;

    private String name;
    private double angle;
    private double value;
    private double min;
    private double max;
    
    public ItemKiviat() {
//        line = new Line2D.Float(centre.x, centre.y, xAngle, yAngle);
//        cursor = new Ellipse2D.Float(x, y, cursorSize, cursorSize);

    }
    
    public ItemKiviat(String name, double angle, double value, double min, double max, DefaultTableModel m) {
        super(); 
           
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        cursor = new Ellipse2D.Double();
        line = new Line2D.Double();
        
        this.name = name;
        this.angle = angle;
        this.value = value;
        this.min = min;
        this.max = max;
        
        this.m = m;
        
        //Point de début et fin de la ligne
        pi = debutLine();
        pf = finLine();
        this.majCoordCursor();
         
    }
    
    public void setValue(double value) {
        this.value = value;
    }

    public Point2D.Double getCoordCursor() {
        return coordCursor;
    }
    
    public Point2D.Double getPf() {
        return pf;
    }

    @Override
    public void paint(Graphics _g) {
        super.paint(_g);
        //System.out.println("Paint : " +  name);
        
        Graphics2D g = (Graphics2D) _g;
        g.setStroke(new BasicStroke(2));
        
        majVueCursor();
        majVueLine();
        
        g.draw(line);
        
        
        g.setColor(Color.red);
        g.fill(cursor);
        
        
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
    
    private double getInterval(){
        return max-min;
    }
    
    @Override
    public boolean contains(int x, int y){
        return cursor.contains((double)x,(double)y);
    }
    
    public void majCoordCursor(){
        coordCursor = valuetoCoordCursor(miseEchelle(value));
    }
    
    public void majVueCursor(){
        cursor.setFrame(centreCursor(coordCursor).x, centreCursor(coordCursor).y, cursorSize, cursorSize);
    }
    
    public void majVueLine(){
        line.setLine(pi, pf);
    }
    
    public void majVueAxe(double angle){
        this.angle = angle;
        pi = debutLine();
        pf = finLine();
        majCoordCursor();
    }
    
    //Passe de l'échelle de la valeur[min-max] à l'échelle de la vue[0-linelength]
    private double miseEchelle(double val){
        double interval = max - min;
        double pas = 0.0;
        if (interval != 0.0) {
            pas = lineLength / interval;
        }
        double res = pas * (val-min);
        return res;
    }
    
    //Trouve les coordonées à partie d'une valeur dans l'échelle de la vue [0_linelength]
    private Point2D.Double valuetoCoordCursor(double val) {
        
        double x = Math.cos(Math.toRadians(angle)) * (val+decalage);
        double y = -Math.sin(Math.toRadians(angle)) * (val+decalage);
        x += centreX;
        y += centreY;
        
        
        return new Point2D.Double(x,y);
    }
    
    private Point2D.Double centreCursor(Point2D.Double p){
        return new Point2D.Double(p.getX() - cursorSize/2,p.getY() - cursorSize/2);
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
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double newValue = arrondi();
        coordCursor = valuetoCoordCursor(miseEchelle(newValue));
        m.setValueAt(Double.toString(newValue), 0, 1);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        valueOnDrag = projectOrtho(e.getX(), e.getY());
        coordCursor = valuetoCoordCursor(valueOnDrag);
        repaint();
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        
    }
    
    
    //renvoie la nouvelle valeur dans l'echelle [min-max]
    private double arrondi(){
        double pas = lineLength/getInterval();
        double newValue = valueOnDrag/pas;
        System.out.println("Valeur avant arrondie : " + newValue);
        newValue = Math.round(newValue) + min;
        System.out.println("Valeur après arrondie : " + newValue);
        return newValue;
    }
    
    //affiche les graduation d'une ligne
    private void grad(Graphics2D g){
        double v;
        for(int i = (int) min; i <= (int) max; i++){
            g.fill(new Ellipse2D.Double(centreCursor(valuetoCoordCursor(miseEchelle(i))).x, centreCursor(valuetoCoordCursor(miseEchelle(i))).y, cursorSize-5, cursorSize-5));
        }
    }

    
}

