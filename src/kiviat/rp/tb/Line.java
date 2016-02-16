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
    private Integer value;
    private Integer min;
    private Integer max;
    private int nbColumn;
    private Vector vector;

    
    
    

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    //Constructeur par défaut
    public Line() {
        this(new String("Default Name"), 0, 0, 0);
    }

    //Nécessaire pour la supression
    public Line(String name) {
        this(name, 0, 0, 0);
    }    

    //Nécessaire pour l'ajout
    public Line(String name, Integer v, Integer vmin, Integer vmax) {
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

    public void setValue(Integer value) {
        this.value = value;
    }

    public double getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void addChangeListener(ChangeListener x) {
        //TODO
    }

    public void removeChangeListener(ChangeListener x) {
        //TODO

    }

}
