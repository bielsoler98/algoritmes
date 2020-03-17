/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author biels
 */
public class Reina extends Peça {

    public Reina(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean validMove(int x, int y) {
        return ((isDiagonal(x, y) || isUp(x, y) || 
                isDown(x, y) || isRight(x, y) || 
                isLeft(x, y)) && !hasVisited(x, y));
    }
}
