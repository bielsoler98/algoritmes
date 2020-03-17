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
public class Rei extends Peça {

    public Rei(int x, int y){
        super(x, y);
    }

    @Override
    public boolean validMove(int x, int y) {
        return ((getXDistance(x)<2 && getYDistance(y)<2)
                    && (getYDistance(y) != 0 || getXDistance(x)!=0)) && !hasVisited(x,y);
    }

}
