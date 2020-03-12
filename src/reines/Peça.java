/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author biels
 */
public abstract class Peça {

    private Casella posicio;
    private Tauler taulerVisitades;
    private Tauler taulerNoVisitades;
    private ImageIcon img;

    public Peça(int x, int y, ImageIcon img) {
        posicio = new Casella(x, y);
        taulerVisitades = new Tauler();
        taulerNoVisitades = new Tauler();
        visitar(posicio);
        this.img = img;
    }

    abstract boolean validMove(Casella origin, Casella desti);

    public Casella getPosicio() {
        return posicio;
    }

    public void setPosicio(Casella posicio) {
        this.posicio = posicio;
    }

    public final void visitar(Casella desti) {
        taulerNoVisitades.eleimina(desti);
        taulerVisitades.afegeix(desti);
        posicio = desti;
        System.out.println("He visitat la casella " + (desti.getX()*8 + desti.getY()));
    }

    protected boolean isDiagonal(Casella origen, Casella desti) {
        return taulerNoVisitades.isDiagonal(origen, desti);
    }

    protected final boolean isUp(Casella origen, Casella desti){
        return taulerNoVisitades.isUp(origen, desti);
    }
    
    protected final boolean isDown(Casella origen, Casella desti){
        return taulerNoVisitades.isDown(origen, desti);
    }
    
    protected final boolean isLeft(Casella origen, Casella desti){
        return taulerNoVisitades.isLeft(origen, desti);
    }
    
    protected final boolean isRight(Casella origen, Casella desti){
        return taulerNoVisitades.isRight(origen, desti);
    }

    public Tauler getTaulerNoVisitades() {
        return taulerNoVisitades;
    }
    public Tauler getTaulerVisitades() {
        return taulerVisitades;
    }
}
