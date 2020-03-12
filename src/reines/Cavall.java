/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import javax.swing.ImageIcon;

/**
 *
 * @author biels
 */
public class Cavall extends Peça {

    public Cavall(int x, int y, ImageIcon img) {
        super(x, y, img);
    }
    
    @Override
    boolean validMove(Casella desti) {
        return (!(getCasella().isDiagonal(desti) || getCasella().isUp(desti)
                || getCasella().isDown(desti) || getCasella().isLeft(desti)
                || getCasella().isRight(desti)) && validateHorseMove(desti) 
                && !desti.isVisited());
    }

    private boolean validateHorseMove( Casella desti) {
        return ((Math.abs(this.getX() - desti.getX()) == 1
                && Math.abs(this.getY() - desti.getY()) == 2)
                || (Math.abs(this.getX() - desti.getX()) == 2
                && Math.abs(this.getY() - desti.getY()) == 1));
    }

}
