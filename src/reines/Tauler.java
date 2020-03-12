/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import java.util.ArrayList;

/**
 *
 * @author biels
 */
class Tauler {

    private Casella[][] tauler;
    private int torn = 0;
    private int tam;

    public Tauler(int tam) {
        tauler = new Casella[tam][tam];
        this.tam = tam;
        inicialitzaTauler();
    }

    private void inicialitzaTauler() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                tauler[i][j] = new Casella(i, j);
            }
        }
    }

    public Casella[][] getTauler() {
        return tauler;
    }

    public void visit(Casella c) {
        tauler[c.getX()][c.getY()].setTorn(torn);
        torn++;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < tauler.length; i++) {
            s += "[";
            for (int j = 0; j < tauler[i].length; j++) {
                s += " " + tauler[i][j].getTorn() + " ";
            }
            s += "]\n";
        }
        return s;
    }
    
     public boolean isInBounds(Casella c) {
        return ((c.getX() >= 0 && c.getX() < tam) && (c.getY() >= 0 && c.getY() < tam));
    }

    public int getNCasella() {
        return tam*tam;
    }
}
