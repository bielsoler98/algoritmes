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

    private final Casella[][] tauler;
    private final int tam;
    int maxTorn;

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
     
    public int getSize(){
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

    public void setMaxTorn(int i) {
        maxTorn = i;
    }

    public int getMaxTorn() {
        return maxTorn;
    }
}
