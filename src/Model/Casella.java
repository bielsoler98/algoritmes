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
public class Casella {

    private int torn;
    private int x;
    private int y;
    public static final int NOT_VISITED = -1;
    
    public Casella(int x, int y) {
        this.x = x;
        this.y = y;
        torn = NOT_VISITED;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setTorn(int torn){
        this.torn = torn; 
    }

    public int getTorn() {
        return torn;
    }
    
    public boolean isVisited(){
        return torn != NOT_VISITED;
    }
    
}
