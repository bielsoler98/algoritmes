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
        backtracking(vac);
    }

    private static boolean backtracking(Peça p) {
        if(TAULER.getTauler()[p.getX()][p.getY()].getTorn() == TAULER.getNCasella()){
            return true;
        }
        for(int i=0; i < TAULER.getTauler().length; i++){
            for(int j=0; j< TAULER.getTauler()[i].length; j++){
                
            }
        }
    }

}
