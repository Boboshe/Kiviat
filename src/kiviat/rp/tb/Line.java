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
    private double value;
    private double min;
    private double max;
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

    public Line(String name, double v, double vmin, double vmax) {
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void addChangeListener(ChangeListener x) {
        //TODO
    }

    public void removeChangeListener(ChangeListener x) {
        //TODO

    }

}
