/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    boolean validMove(Casella desti) {
        return ((position.isDiagonal(desti) || position.isUp(desti) || 
                position.isDown(desti) || position.isRight(desti) || 
                position.isLeft(desti)) && !desti.isVisited());
    }
}
