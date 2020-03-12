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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Andrea");
        Cavall vac = new Cavall(0, 0, null);
        System.out.println(vac.getTaulerNoVisitades().toString());
        backtracking(vac);
    }

    private static void backtracking(Peça p) {
        for(int i = 0; i < p.getTaulerNoVisitades().getTauler().size(); i++){
            Casella desti = p.getTaulerNoVisitades().getTauler().get(i);
            if(p.validMove(p.getPosicio(), desti)){
                p.visitar(desti);
            }
        }
        if(p.getTaulerNoVisitades().getTauler().isEmpty()){
            System.out.println(p.getTaulerVisitades().toString());
        }
    }

}
