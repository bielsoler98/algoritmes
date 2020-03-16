/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author biels
 */
public class Tauler {

    private Casella[][] tauler;
    private int tam;
    int maxTorn;

    public Tauler(int tam) {
        tauler = new Casella[tam][tam];
        this.tam = tam;
        inicialitzaTauler();
    }

    private void inicialitzaTauler() {
        maxTorn = getSize() -1;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                tauler[i][j] = new Casella(i, j);
            }
        }
    }

    public Casella[][] getTauler() {
        return tauler;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < tauler.length; i++) {
            s += "[";
            for (int j = 0; j < tauler[i].length; j++) {
                s += "\t" + (tauler[i][j].getTorn()!= -1 ? tauler[i][j].getTorn() : "x" );
            }
            s += "]\n";
        }
        s+="\n====================================================================================================================================================\n";
        return s;
    }
    
     public boolean isInBounds(Casella c) {
        return ((c.getX() >= 0 && c.getX() < tam) && (c.getY() >= 0 && c.getY() < tam));
    }
     
     int getSize(){
         return tam*tam;
     }
     

    public int getCasellesLliures() {
        int n = 0;
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                if(!tauler[i][j].isVisited()){
                    n++;
                }
            }
        }
        return n;
    }

    void setMaxTorn(int i) {
        maxTorn = i;
    }

    int getMaxTorn() {
        return maxTorn;
    }
}
