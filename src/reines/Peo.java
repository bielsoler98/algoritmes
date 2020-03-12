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
public class Peo extends Peça {

    public Peo(int x, int y, ImageIcon img) {
        super(x, y, img);
    }

    @Override
    boolean validMove(Casella origin, Casella desti) {
        return (isUp(origin, desti) && (origin.getY() - desti.getY() == 1));
    }

}
