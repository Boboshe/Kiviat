
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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
    

    private DefaultTableModel model;

    private String name;
    private double angle;
    private Integer value;
    private Integer min;
    private Integer max;
    private Integer id;
    
    
    
    public ItemKiviat() {

    }
    
    public ItemKiviat(String name, double angle, Integer value, Integer min, Integer max, DefaultTableModel m, Integer id) {
        super(); 
           
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        cursor = new Ellipse2D.Double();
        line = new Line2D.Double();
        
        this.id = id;
        this.name = name;
        this.angle = angle;
        this.value = value;
        this.min = min;
        this.max = max;
        
        this.model = m;
        
        //Point de début et fin de la ligne
        pi = debutLine();
        pf = finLine();
        this.majCoordCursor();
         
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    public void setValue(Integer value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
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
        
        g.drawString(name,(float) pf.x+10, (float) pf.y+10);
        
        
    }

    
    //Retourne les coordonnées du début de l'axe
    private Point2D.Double debutLine(){
        double x = Math.cos(Math.toRadians(angle)) * decalage;
        double y = -Math.sin(Math.toRadians(angle)) * decalage;
        x += centreX;
        y += centreY;
        return new Point2D.Double(x,y);        
    }
    
    //Retourne les coordonnées de fin de l'axe
    private Point2D.Double finLine(){
        double x = Math.cos(Math.toRadians(angle)) * (lineLength+decalage);
        double y = -Math.sin(Math.toRadians(angle)) * (lineLength+decalage);
        x += centreX;
        y += centreY;
        return new Point2D.Double(x,y);
    }
    
    
    private Integer getInterval(){
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
    private double miseEchelle(Integer val){
        Integer interval = getInterval();
        double pas = 0.0;
        if (interval != 0) {
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
        Integer newValue = arrondi();
        coordCursor = valuetoCoordCursor(miseEchelle(newValue));
        model.setValueAt(newValue, id, 1);
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
    private Integer arrondi(){
        double pas = lineLength/getInterval();
        Integer newValue = Math.round((float) (valueOnDrag/pas)) + min;
        return newValue;
    }
    
    

    
}

