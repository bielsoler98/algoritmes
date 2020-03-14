/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;

public class Peo extends Peça {

    public Peo(int x, int y, ImageIcon img) {
        super(x, y, img);
    }

    @Override
    boolean validMove(Casella desti) {
        return (position.isUp(desti) && (position.getYDistance(desti) == 1));
    }
}
