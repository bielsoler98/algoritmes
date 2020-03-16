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
import View.Imatge;
import View.View;
import java.awt.Image;

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
        Peça p = model.getPrimeraPeça();
        solve(p);
        System.out.println("");
    }
    
    private void solve(Peça p){
        if (backtracking(p)) {
            showSolution(p);
        } else {
            view.showMessage();
        }
    }
    
    public void createPeça(String pieza, int x, int y){
        switch(pieza){
            case "cavall": 
                model.AddCavall(x,y);
                view.paintCavall(x,y);
                break;
            case "reina": 
                model.AddReina(x,y);
                view.paintReina(x,y);
                break;
            case "peo": 
                model.AddPeo(x,y);
                view.paintPeo(x,y);
                break;
            case "rei": 
                model.AddRei(x,y);
                view.paintRei(x,y);
                break;
            case "torre": 
                model.AddTorre(x,y);
                view.paintTorre(x,y);
                break;   
        }
    }
    
    public void showSolution(Peça p) {
        for(int i = 0; i < p.getTauler().length; i++){
            for (int j = 0; j < p.getTauler()[i].length; j++) {
                if(p.getTauler()[i][j].getTorn()!=0){
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
