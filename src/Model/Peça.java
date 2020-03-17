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
public abstract class Peça {

    private int x;
    private int y;
    protected Tauler taulerCami;
    private int torn;

    public Peça(int x, int y) {
        this.x = x;
        this.y = y;
        torn = 1;
    }

    public Casella[][] getTauler() {
        return taulerCami.getTauler();
    }

    public abstract boolean validMove(int x, int y);

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public void visit(int x, int y) {
        getTauler()[x][y].setTorn(torn);
        setPosition(x, y);
        torn++;
    }

    public void getBack(int x, int y) {
        torn--;
        getTauler()[this.x][this.y].setTorn(Casella.NOT_VISITED);
        setPosition(x, y);
    }

    public Casella getCasella(int x, int y) {
        return getTauler()[x][y];
    }

    protected final void setTauler(Tauler t) {
        taulerCami = t;
    }

    public int getTorn() {
        return torn;
    }

    public boolean hasFinished() {
        return torn == taulerCami.getMaxTorn();
    }

    protected boolean isDiagonal(int x, int y) {
        return (Math.abs(this.x - x) == Math.abs(this.y - y));
    }

    protected boolean isUp(int x, int y) {
        return (x == this.x && y > this.y);
    }

    protected boolean isDown(int x, int y) {
        return (x == this.x && y < this.y);
    }

    protected boolean isLeft(int x, int y) {
        return (y == this.y && x > this.x);
    }

    protected boolean isRight(int x, int y) {
        return (y == this.y && x < this.x);
    }

    protected int getXDistance(int x) {
        return Math.abs(x - this.x);
    }

    protected int getYDistance(int y) {
        return Math.abs(y - this.y);
    }
    
    protected boolean hasVisited(int x, int y){
        return taulerCami.getTauler()[x][y].isVisited();
    }
}
