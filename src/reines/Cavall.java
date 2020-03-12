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
    boolean validMove(Casella origin, Casella desti) {
        return (!(isDiagonal(origin, desti) || isUp(origin, desti)
                || isDown(origin, desti) || isLeft(origin, desti)
                || isRight(origin, desti)) && validateHorseMove(origin, desti));
    }

    private boolean validateHorseMove(Casella origen, Casella desti) {
        return ((Math.abs(origen.getX() - desti.getX()) == 1
                && Math.abs(origen.getY() - desti.getY()) == 2)
                || (Math.abs(origen.getX() - desti.getX()) == 2
                && Math.abs(origen.getY() - desti.getY()) == 1));
    }

}
