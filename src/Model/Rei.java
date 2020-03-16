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
public class Rei extends Peça {

    public Rei(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean validMove(int x, int y) {
        return ((getXDistance(x) < 2 && getYDistance(y)< 2)
                && (x != 0 || y != 0))&& !hasVisited(x, y);
    }
}
