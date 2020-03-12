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
public class Reina extends Peça {

    public Reina(int x, int y, ImageIcon img) {
        super(x, y, img);
    }

    @Override
    boolean validMove(Casella origin, Casella desti) {
        return ((isDiagonal(origin, desti) || isUp(origin, desti) || 
                isDown(origin,desti) || isRight(origin, desti) || 
                isLeft(origin, desti)));
    }

}
