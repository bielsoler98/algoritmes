/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;
import reines.Reines;

/**
 *
 * @author biels
 */
public abstract class Peça {

    protected Casella position;
    private ImageIcon img;
    protected Tauler tauler;
    private int torn;
    
    public Peça(int x, int y, ImageIcon img) {
        tauler = new Tauler(8);
        position = getCasella(x, y);
        this.img = img;
        torn =0;
    }

    public Tauler getTauler() {
        return tauler;
    }

    abstract boolean validMove(Casella desti);

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
        tauler.getTauler()[c.getX()][c.getY()].setTorn(torn);
        setPosition(c.getX(), c.getY());
        torn++;
//        System.out.println("GOTO: ["+ tauler.getTauler()[c.getX()][c.getY()].getX()+ " , " + tauler.getTauler()[c.getX()][c.getY()].getY() + "] en el torn "+ torn);
    }
    
    public void getBack(Casella c){
        tauler.getTauler()[position.getX()][position.getY()].setTorn(-1);
        setPosition(c.getX(), c.getY());
        torn--;
//        System.out.println("RESET: ["+ tauler.getTauler()[c.getX()][c.getY()].getX()+ " , " + tauler.getTauler()[c.getX()][c.getY()].getY() + "]en el torn "+ torn);
    }
    
    public Casella getCasella(int x, int y){
        return tauler.getTauler()[x][y];
    }    
   
    protected final void setTauler(Tauler t){
        tauler = t;
    }

    boolean hasFinished() {
        return position.getTorn() == tauler.getNCasella();
    }
    
    public void showSolution() {
        for(int i = 0; i < tauler.getTauler().length; i++){
            for (int j = 0; j < tauler.getTauler()[i].length; j++) {
                Reines.view.setNumberToCasilla(i, j, tauler.getTauler()[i][j].getTorn());
            }
        }
    }
}
