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
public class Control extends Thread{
    
    private View view;
    
    public Control(View view){
        this.view = view;
    }
    
    public void selectMethod(String pieza, int x, int y){
        Peça p = null;
        switch(pieza){
            case "cavall": 
                p = new Cavall(x, y, null);
                break;
            case "reina": 
                p = new Reina(x,y,null);
                break;
            case "peo": 
                p = new Peo(x,y,null);
                break;
            case "rei": 
                p = new Rei(x,y,null);
                break;
            case "torre": 
                p = new Torre(x,y,null);
                break;   
        }
        if (backtracking(p)) {
            showSolution(p);
        } else {
            System.out.println("Aquesta peça no pot recorrer tot el tauler");
        }
    }
    
    public void showSolution(Peça p) {
        for(int i = 0; i < p.getTauler().length; i++){
            for (int j = 0; j < p.getTauler()[i].length; j++) {
                view.setNumberToCasilla(i, j, p.getTauler()[i][j].getTorn());
            }
        }
    }
    
    private boolean backtracking(Peça p) {
        if (p.hasFinished()) {
            return true;
        } else {
            for (Casella[] tauler : p.getTauler()) {
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
