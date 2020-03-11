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
public class Peo extends Peça {

    public Peo(int x, int y, ImageIcon img) {
        super(x, y, img);
    }

    @Override
    boolean validMove(Point origin, Point desti) {
        return (isUp(origin, desti) && (origin.y - desti.y == 1));
    }

}
