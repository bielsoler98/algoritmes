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

    private ArrayList<Casella> tauler;
    private final int MAX_TAULER = 8;

    public Tauler() {
        tauler = new ArrayList();
        inicialitzaTauler();
    }

    private void inicialitzaTauler() {
        for (int i = 0; i < MAX_TAULER; i++) {
            for (int j = 0; j < MAX_TAULER; j++) {
                tauler.add(new Casella(i,j));
            }
        }
    }

    public ArrayList<Casella> getTauler() {
        return tauler;
    }

    public boolean isDiagonal(Casella origen, Casella desti) {
        return ((Math.abs(desti.getX() - origen.getX()) == Math.abs(desti.getY() - origen.getY()) && isInBounds(desti)));
    }

    public boolean isUp(Casella origen, Casella desti) {
        return ((origen.getX() == desti.getX() && origen.getY() > desti.getY()) && isInBounds(desti));
    }

    public boolean isDown(Casella origen, Casella desti) {
        return ((origen.getX() == desti.getX() && origen.getY() < desti.getY()) && isInBounds(desti));
    }

    public boolean isLeft(Casella origen, Casella desti) {
        return ((origen.getY() == desti.getY() && origen.getX() > desti.getX()) && isInBounds(desti));
    }

    public boolean isRight(Casella origen, Casella desti) {
        return ((origen.getY() == desti.getY() && origen.getX() < desti.getX()) && isInBounds(desti));
    }

    public boolean isInBounds(Casella desti) {
        return ((desti.getX() >= 0 && desti.getX() < MAX_TAULER) && (desti.getY() >= 0 && desti.getY() < MAX_TAULER));
    }

    @Override
    public String toString() {
        String s = "";
        for(Casella c : tauler){
            int pos = getLinealPos(c);
            if(pos % MAX_TAULER == 0){
                s+="[";
            }
            s+= "\t" + pos + "\t";
            if(pos % MAX_TAULER == MAX_TAULER - 1){
                s+="]"+'\n';
            }
        }
        return s;
    }

    private int getLinealPos(Casella c) {
        return c.getX()*MAX_TAULER + c.getY();
    }

    void afegeix(Casella c) {
        tauler.add(c);
    }
    
    void eleimina(Casella c){
        tauler.remove(c);
    }
}
