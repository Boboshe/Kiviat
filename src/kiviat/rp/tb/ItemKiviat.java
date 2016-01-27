/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiviat.rp.tb;

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
    private double lineLength = 50;
    private double angle;

    private Ellipse2D cursor;
    private Point2D centre = new Point2D.Double(50.0, 50.0);
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
        repaint();
    }

    @Override
    public void paint(Graphics _g) {
        Graphics2D g = (Graphics2D) _g;
        line = new Line2D.Float(centre, angletoCoord());
        Point2D.Double cursorCoord = valuetoCoordCursor();
        cursor = new Ellipse2D.Double(cursorCoord.x, cursorCoord.y, cursorSize, cursorSize);
        g.draw(line);
        g.draw(cursor);
    }

    public ItemKiviat() {
//        line = new Line2D.Float(centre.x, centre.y, xAngle, yAngle);
//        cursor = new Ellipse2D.Float(x, y, cursorSize, cursorSize);

    }

    private Point2D angletoCoord() {
        return new Point2D.Double((Math.cos(angle) * lineLength), (Math.sin(angle) * lineLength));
    }

    private Point2D.Double valuetoCoordCursor() {
        double interval = max - min;
        double pas = 0.0;
        if (interval != 0.0) {
            pas = lineLength / interval;
        }
        double rayon = pas * value;
        return new Point2D.Double((Math.cos(angle) * rayon), (Math.sin(angle) * rayon));
    }
}
