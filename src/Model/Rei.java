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

    public Rei(int x, int y, ImageIcon img) {
        super(x, y, img);
    }

    @Override
    boolean validMove(Casella desti) {
        return ((position.getXDistance(desti) == 1 && position.getYDistance(desti)<2)
                || (position.getYDistance(desti) == 1) && position.getXDistance(desti)<2)&& !desti.isVisited();
    }
}
