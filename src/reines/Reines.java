/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import javax.swing.JFrame;
import View.View;
/**
 *
 * @author biels
 */
public class Reines {

    
    
    public static View f;

    public static void main(String[] args) {
        Peça vac = new Cavall(0, 0, null);
        startView();
        vac.visit(vac.getPosition());
        if (backtracking(vac)) {
            System.out.println(vac.tauler);
            vac.showSolution();
        } else {
            System.out.println("Aquesta peça no pot recorrer tot el tauler");
        }
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

    private static void startView() {
        f = new View();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.pack();
        f.setMinimumSize(f.getSize());
        f.setVisible(true);
    }
}
