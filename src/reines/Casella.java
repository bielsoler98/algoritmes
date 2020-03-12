/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

/**
 *
 * @author biels
 */
public class Casella {

    private int torn;
    private int x;
    private int y;
    
    public Casella(int x, int y) {
        this.x = x;
        this.y = y;
        torn = -1;
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
        return torn != -1;
    }
    
    public boolean isDiagonal(Casella c) {
        return (Math.abs(c.getX() - this.getX()) == Math.abs(c.getY() - this.getY()));
    }

    public boolean isUp(Casella c) {
        return (this.getX() == c.getX() && this.getY() > c.getY());
    }

    public boolean isDown(Casella c) {
        return (this.getX() == c.getX() && this.getY() < c.getY());
    }

    public boolean isLeft(Casella c) {
        return (this.getY() == c.getY() && this.getX() > c.getX());
    }

    public boolean isRight(Casella c) {
        return (this.getY() == c.getY() && this.getX() < c.getX());
    }
    
    public int getXDistance(Casella c){
        return Math.abs(this.x - c.x);
    }
    public int getYDistance(Casella c){
        return Math.abs(this.y - c.y);
    }
}
