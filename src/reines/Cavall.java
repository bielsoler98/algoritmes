/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import java.awt.Point;
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
    boolean validMove(Point origin, Point desti) {
        return (!(isDiagonal(origin, desti) || isUp(origin, desti)
                || isDown(origin, desti) || isLeft(origin, desti)
                || isRight(origin, desti)) && validateHorseMove(origin, desti));
    }

    private boolean validateHorseMove(Point origen, Point desti) {
        return ((Math.abs(origen.x - desti.x) == 1
                && Math.abs(origen.y - desti.y) == 2) || 
                (Math.abs(origen.x - desti.x) == 2
                && Math.abs(origen.y - desti.y) == 1));
    }

}
