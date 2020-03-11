/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author biels
 */
public abstract class Peça {

    private Point posicio;
    private Tauler tauler;
    private ImageIcon img;

    public Peça(int x, int y, ImageIcon img) {
        posicio = new Point(x, y);
        tauler = new Tauler();
        tauler.marcarPeça(posicio);
        this.img = img;
    }

    abstract boolean validMove(Point origin, Point desti);

    private void moveTo(Point desti) {
        tauler.marcarPeça(desti);
    }

    protected boolean isDiagonal(Point origen, Point desti) {
        return tauler.isDiagonal(origen, desti);
    }

    protected boolean isUp(Point origen, Point desti){
        return tauler.isUp(origen, desti);
    }
    
    protected boolean isDown(Point origen, Point desti){
        return tauler.isDown(origen, desti);
    }
    
    protected boolean isLeft(Point origen, Point desti){
        return tauler.isLeft(origen, desti);
    }
    
    protected boolean isRight(Point origen, Point desti){
        return tauler.isRight(origen, desti);
    }
}
