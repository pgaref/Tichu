/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tichu.view.panels;

import java.awt.Point;

/**
 *
 * @author Dimitris
 */
public enum Direction {
    UP,DOWN,LEFT,RIGHT;
    
    public Point getPoint(){
        switch(this){
            case UP:
                return new Point(0,15);
            case DOWN:
                return new Point(0,-15);
            case LEFT:
                return new Point(20,0);
            case RIGHT:
                return new Point(-20,0);
            default:
                return new Point(0,0);
        }
    }
}
