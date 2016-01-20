/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Boris
 */
public class Line {

    private ArrayList<ChangeListener> listerList;
    private String name;
    private int value;
    private int min;
    private int max;
    private int nbColumn;
    private Vector vector;

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Line() {
        this(new String("Default Name"), 0, 0, 0);
    }

    public Line(String name, int v, int vmin, int vmax) {
        this.name = name;
        this.value = v;
        this.min = vmin;
        this.max = vmax;
        vector = new Vector();
        vector.add(name);
        vector.add(v);
        vector.add(vmin);
        vector.add(vmax);
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbColumn() {
        return nbColumn;
    }

    public void setNbColumn(int nbColumn) {
        this.nbColumn = nbColumn;
    }

    public int getMinimum() {
        return min;
    }

    public void setMinimum(int newMinimum) {
        min = newMinimum;
    }

    public int getMaximum() {
        return max;
    }

    public void setMaximum(int newMaximum) {
        max = newMaximum;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    public void addChangeListener(ChangeListener x) {
        //TODO
    }

    public void removeChangeListener(ChangeListener x) {
        //TODO

    }

}
