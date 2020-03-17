/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Control;
import View.Imatge;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

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
    
    public Peça getPrimeraPeça(){
        if(!peces.isEmpty()){
            return peces.get(0);
        }
        return null;
    }
    
    public boolean isEmptyPeces(){
        return peces.isEmpty();
    }

    private void AddPeça(Peça p) {
        tauler.getTauler()[p.getX()][p.getY()].setTorn(0);
        tauler.setMaxTorn(tauler.getSize() - peces.size());
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
    
    public void AddTorre(int x, int y) {
        AddPeça(new Torre(x, y));
    }

    public Tauler getTauler() {
        return tauler;
    }
}
