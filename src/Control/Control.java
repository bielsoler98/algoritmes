/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Casella;
import Model.Cavall;
import Model.Peo;
import Model.Peça;
import Model.Rei;
import Model.Reina;
import Model.Torre;
import View.View;

/**
 *
 * @author Andrea
 */
public class Control {
    
    private View vista;
    
    public Control(View view){
        
        vista = view;
        
        Peça vac = new Cavall(0, 0, null);
        vac.visit(vac.getPosition());
        if (backtracking(vac)) {
            System.out.println(vac.tauler);
            vac.showSolution();
        } else {
            System.out.println("Aquesta peça no pot recorrer tot el tauler");
        }
    }
    
    public void selectMethod(String pieza, int x, int y){
        Peça p = null;
        switch(pieza){
            case "Cavall": 
                p = new Cavall(x, y, null);
                break;
            case "Reina": 
                p = new Reina(x,y,null);
                break;
            case "Peo": 
                p = new Peo(x,y,null);
                break;
            case "Rei": 
                p = new Rei(x,y,null);
                break;
            case "Torre": 
                p = new Torre(x,y,null);
                break;   
        }
        backtracking(p);
    }
    
    private static boolean backtracking(Peça p) {
        if (p.hasFinished()) {
            return true;
        } else {
            for (Casella[] tauler : p.tauler.getTauler()) {
                for (Casella desti : tauler) {
                    if (p.validMove(desti)) {
                        Casella inici = p.getPosition();
                        p.visit(desti);
                        if (backtracking(p)) {
                            return true;
                        } else {
                            p.getBack(inici);
                        }
                    }
                }
            }
            return false;
        }
    }
}
