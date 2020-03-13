/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

/**
 *
 * @author biels
 */
public class Reines {

    public static void main(String[] args) {
        Peça vac = new Cavall(0, 0, null);
        vac.visit(vac.getPosition());
        if (backtracking(vac)) {
            System.out.println(vac.tauler);
        } else {
            System.out.println("Aquesta peça no pot recorrer tot el tauler");
        }
    }

    private static boolean backtracking(Peça p) {
        if (p.getPosition().getTorn() == p.getTauler().getNCasella()) {
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
