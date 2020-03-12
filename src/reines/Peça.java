/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author biels
 */
public abstract class Peça {

    private int x;
    private int y;
    private ImageIcon img;

    public Peça(int x, int y, ImageIcon img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    abstract boolean validMove( Casella desti);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    protected final Casella getCasella(){
        return new Casella(x,y);
    }
}
