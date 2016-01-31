/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author pierre
 */

public class Kiviat extends javax.swing.JLayeredPane implements TableModelListener {

    private int size = 400;
    private DefaultTableModel model;

    /**
     * Creates new form Kiviat
     */
    private ArrayList<ItemKiviat> listItem = new ArrayList<ItemKiviat>();

    public Kiviat() {
        initComponents();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //addLine(0,8,0,20);
        //addLine(-100,8,0,20);
//        addLine(45,5,0,20);
//        addLine(90,5,0,20);
//        addLine(0,5,0,20);

    }

    public void setModel(DefaultTableModel model) {
        System.out.println("SET MODEL");
        this.model = model;
        listItem.clear();
        int nbAxes;
        nbAxes = this.model.getRowCount();
        System.out.println("Nb axes : " + nbAxes);
        double angle = 360.0 / (double) nbAxes;
        for (int i = 0; i < nbAxes; i++) {
            String name = (String) this.model.getValueAt(i, 0);
            Double value = (Double) this.model.getValueAt(i, 1);
            Double min = (Double) this.model.getValueAt(i, 2);
            Double max = (Double) this.model.getValueAt(i, 3);
            addLine(name, 0.0 + (angle * i), value, min, max);
//            Integer value = (Integer) this.model.getValueAt(i, 1);
//            Integer min = (Integer) this.model.getValueAt(i, 2);
//            Integer max = (Integer) this.model.getValueAt(i, 3);
//            addLine(0.0 + (angle * i), value.doubleValue(), min.doubleValue(), max.doubleValue());            
        }
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }
    
    @Override
    public void paint(Graphics _g) {
        super.paint(_g);
        Polygon poly = new Polygon();
        for(ItemKiviat item : listItem){
            Point2D.Double point = item.getCoordCursor();
            poly.addPoint((int)point.x,(int)point.y);
        }
        _g.drawPolygon(poly);
        
        
            
        
    }
    
    

    //Crée un nouvel objet kiviat et l'ajoute à la liste
    public void addLine(String name, double angle, double value, double min, double max) {
        ItemKiviat item = new ItemKiviat(name, angle, value, min, max);
        listItem.add(item);
        this.add(item);
    }

    @Override
    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x, y, w, h);
        for (ItemKiviat item : listItem) {
            item.setBounds(0, 0, w, h);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 772, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 484, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            //Numéro de la ligne qui a été modifé
            int numRow = e.getFirstRow();
            
            //Nouvelle valeur
            Integer newValue = Integer.parseInt((String) model.getValueAt(numRow, e.getColumn()));
            listItem.get(numRow).setValue(newValue.doubleValue());
            
            for(ItemKiviat item : listItem){
                item.majCoordCursor();
            }
            

        } else if (e.getType() == TableModelEvent.INSERT) {
            //Numéro de la ligne qui a été modifé
            int numRow = e.getFirstRow();
            if(model != null){
                int nbAxes = model.getRowCount();
                double angle = 360.0 / (double) nbAxes;
            
                String name = (String) model.getValueAt(numRow, 0);
                Double value = (Double) model.getValueAt(numRow, 1);
                Double min = (Double) model.getValueAt(numRow, 2);
                Double max = (Double) model.getValueAt(numRow, 3);
       
                addLine(name, 0.0 + (angle * nbAxes), value.doubleValue(), value.doubleValue(), value.doubleValue());
                
                for(int i = 0; i< nbAxes;i++){
                    listItem.get(i).majVueAxe(0.0 + (angle * i));
                }    
            
            }
            
            
        } else if (e.getType() == TableModelEvent.DELETE) {
            //TOdo
        }

        repaint();
    }
}
