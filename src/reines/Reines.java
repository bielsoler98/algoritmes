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

    static final int MAX_TAULER = 8;
    static Tauler TAULER = new Tauler(MAX_TAULER);

    public static void main(String[] args) {
        Cavall vac = new Cavall(0, 0, null);
        vac.visit(vac.getPosition());
        backtracking(vac);
        System.out.println(vac.tauler);
    }

    private static boolean backtracking(Peça p) {
        Casella desti = p.nextMove();
        while (desti != null) {
            if (p.getCasella(p.getPosition()).getTorn() == p.getTauler().getNCasella()) {
                return true;
            } else {
                Peça p1 = p.clonePeça();
                p1.visit(desti);
                if (backtracking(p1)) {
                    p.visit(desti);
                }
            }
            desti = p.nextMove();
        }
        return false;
    }
}
