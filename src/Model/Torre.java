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

    public Torre(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean validMove(int x, int y) {
        return (isUp(x, y) || isDown(x, y) || 
                isLeft(x, y) || isRight(x, y)) && !hasVisited(x, y);
    }
    
}
