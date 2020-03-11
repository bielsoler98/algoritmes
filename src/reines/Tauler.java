/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import java.awt.Point;

/**
 *
 * @author biels
 */
class Tauler {

    private int[][] tauler;
    private int pecesMarcades = 0;

    public Tauler() {
        tauler = new int[8][8];
        inicialitzaTauler();
    }

    private void inicialitzaTauler() {
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[j].length; j++) {
                tauler[i][j] = 0;
            }
        }
    }

    public void marcarPeça(Point p) {
        pecesMarcades++;
        tauler[p.x][p.y] = pecesMarcades;
    }

    public boolean isMarcada(Point p) {
        return (tauler[p.x][p.y] != 0);
    }

    public boolean isDiagonal(Point origen, Point desti) {
        return (Math.abs(desti.x - origen.x) == Math.abs(desti.y - origen.y));
    }

    public boolean isUp(Point origen, Point desti) {
        return (origen.x == desti.x && origen.y < desti.y);
    }

    public boolean isDown(Point origen, Point desti) {
        return (origen.x == desti.x && origen.y > desti.y);
    }

    public boolean isLeft(Point origen, Point desti) {
        return (origen.y == desti.y && origen.x > desti.x);
    }

    public boolean isRight(Point origen, Point desti) {
        return (origen.y == desti.y && origen.x < desti.x);
    }
}
