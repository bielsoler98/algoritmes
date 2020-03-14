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
public class Torre extends Peça{

    public Torre(int x, int y, ImageIcon img) {
        super(x, y, img);
    }

    @Override
    public boolean validMove(Casella desti) {
        return (position.isUp(desti) || position.isDown(desti) || 
                position.isLeft(desti) || position.isRight(desti)) && !desti.isVisited();
    }
    
}
