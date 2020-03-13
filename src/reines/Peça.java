/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import javax.swing.ImageIcon;

/**
 *
 * @author biels
 */
public abstract class Peça {

    protected Casella position;
    private ImageIcon img;
    protected Tauler tauler;

    public Peça(int x, int y, ImageIcon img) {
        tauler = new Tauler(8);
        position = getCasella(x, y);
        this.img = img;
    }

    public Tauler getTauler() {
        return tauler;
    }

    abstract boolean validMove(Casella desti);
    abstract Peça clonePeça();

    public void setPosition(int x, int y) {
        position = getCasella(x,y);
    }

    protected final Casella getPosition() {
        return position;
    }

    public Casella nextMove() {
        for (int i = 0; i < tauler.getTauler().length; i++) {
            for (int j = 0; j < tauler.getTauler()[i].length; j++) {
                if (validMove(tauler.getTauler()[i][j])) {
                    return tauler.getTauler()[i][j];
                }
            }
        }
        return null;
    }

    public void visit(Casella c) {
        tauler.getTauler()[c.getX()][c.getY()].setTorn(tauler.getTorn());
        setPosition(c.getX(), c.getY());
    }
    
    public Casella getCasella(int x, int y){
        return tauler.getTauler()[x][y];
    }    
    
    public Casella getCasella(Casella c){
        return tauler.getTauler()[c.getX()][c.getY()];
    }
    protected final void setTauler(Tauler t){
        tauler = t;
    }
}
