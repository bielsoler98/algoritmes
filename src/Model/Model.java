/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import reines.ChessBoardSolver;
import reines.TipusPeça;

/**
 *
 * @author biels
 */
public class Model implements ChessBoardSolver.Model {

    private ArrayList<Peça> peces;
    private Tauler tauler;
    private final int size;

    public Model(int size) {
        this.size =  size; 
        peces = new ArrayList();
        tauler = new Tauler(size);
    }

    @Override
    public Peça getPrimeraPeça() {
        if (!peces.isEmpty()) {
            return peces.get(0);
        }
        return null;
    }

    @Override
    public boolean isEmptyPeces() {
        return peces.isEmpty();
    }

    @Override
    public void AddPeça(int x, int y, TipusPeça t) {
        Peça p;
        p = getPeça(x, y, t);
        tauler.getTauler()[p.getX()][p.getY()].setTorn(0);
        tauler.setMaxTorn(tauler.getSize() - peces.size());
        insertPeçaInList(p);
        peces.forEach((Peça it) -> {
            it.setTauler(tauler);
        });
    }

    private void insertPeçaInList(Peça p) {
        boolean isIn = false;
        for (int i = 0; i < peces.size(); i++) {
            if(peces.get(i).getX() == p.getX() && peces.get(i).getY() == p.getY()){
                peces.remove(i);
                peces.add(i, p);
                isIn = true;
            }
        }
        if(!isIn){
            peces.add(p);
        }
    }

    private Peça getPeça(int x, int y, TipusPeça t) {
        Peça p = null;
        switch (t) {
            case CAVALL:
                p = new Cavall(x, y);
                break;
            case TORRE:
                p = new Torre(x, y);
                break;
            case PEO:
                p = new Peo(x, y);
                break;
            case REI:
                p = new Rei(x, y);
                break;
            case REINA:
                p = new Reina(x, y);
                break;
        }
        return p;
    }

    public Tauler getTauler() {
        return tauler;
    }

    @Override
    public void resetModel() {
        peces = new ArrayList();
        tauler = new Tauler(size);
    }
}
