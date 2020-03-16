/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Imatge;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Peo extends Peça {

    public Peo(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean validMove(int x, int y) {
        return (isUp(x, y) && (getYDistance(y) == 1));
    }
}
