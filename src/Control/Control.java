/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Casella;
import Model.Cavall;
import Model.Model;
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
    private Model model;
    
    public Control(View view, Model model){
        this.view = view;
        this.model = model;
    }
   
    public void run(){
        Peça p = selectMethod(view.getPieza(), view.getxIcon(), view.getyIcon());
        solve(p);
    }
    
    private void solve(Peça p){
        if (backtracking(p)) {
            showSolution(p);
        } else {
            view.showMessage();
        }
    }
    
    private Peça selectMethod(String pieza, int x, int y){
        Peça p = null;
        switch(pieza){
            case "cavall": 
                p = new Cavall(x, y);
                break;
            case "reina": 
                p = new Reina(x,y);
                break;
            case "peo": 
                p = new Peo(x,y);
                break;
            case "rei": 
                p = new Rei(x,y);
                break;
            case "torre": 
                p = new Torre(x,y);
                break;   
        }
        return p;
    }
    
    public void showSolution(Peça p) {
        for(int i = 0; i < p.getTauler().length; i++){
            for (int j = 0; j < p.getTauler()[i].length; j++) {
                if(i != view.getxIcon() || j != view.getyIcon()){
                    view.setNumberToCasilla(i, j, p.getTauler()[i][j].getTorn());
                }
            }
        }
    }
    
    private boolean backtracking(Peça p) {
        if (p.hasFinished()) {
            return true;
        } else {
            for (int i = 0; i < p.getTauler().length; i++) {
                for (int j = 0; j < p.getTauler()[i].length; j++) {
                    if (p.validMove(i, j)) {
                        int x = p.getX();
                        int y = p.getY();
                        p.visit(i, j);
                        if (backtracking(p)) {
                            return true;
                        } else {
                            p.getBack(x, y);
                        }
                    }
                }
            }
            return false;
        }
    }
}
