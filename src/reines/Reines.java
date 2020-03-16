/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import Control.Control;
import Model.Model;
import Model.Tauler;
import View.View;

/**
 *
 * @author biels
 */
public class Reines {
    
    private Control control;
    private View view;
    private Model model;
    
    public static void main(String[] args) {
        (new Reines()).inicio();
    }

    private void inicio() {
        view = new View();
        control = new Control(view, model);
        view.setControlador(control);
    }
    
    
}
