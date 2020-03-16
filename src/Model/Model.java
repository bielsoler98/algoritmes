/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Control;
import java.util.ArrayList;

/**
 *
 * @author biels
 */
public class Model {

    private ArrayList<Peça> peces;
    private Tauler tauler;
    private Control control;

    public Model() {
        peces = new ArrayList();
        tauler = new Tauler(8);
    }

    public void setControl(Control control) {
        this.control = control;
    }

    private void AddPeça(Peça p) {
        tauler.getTauler()[p.getX()][p.getY()].setTorn(0);
        tauler.setMaxTorn(tauler.getSize() - peces.size() -1);
        peces.add(p);
        peces.forEach((Peça it) -> {
            it.setTauler(tauler);
            
        });
    }

    public void AddCavall(int x, int y) {
        AddPeça(new Cavall(x, y));
    }

    public void AddRei(int x, int y) {
        AddPeça(new Rei(x, y));
    }

    public void AddReina(int x, int y) {
        AddPeça(new Reina(x, y));
    }

    public void AddPeo(int x, int y) {
        AddPeça(new Peo(x, y));
    }

    public Tauler getTauler() {
        return tauler;
    }
}