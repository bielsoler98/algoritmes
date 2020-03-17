/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Model;
import Model.Peça;
import View.View;
import reines.ChessBoardSolver;
import reines.TipusPeça;

/**
 *
 * @author Andrea
 */
public class Control implements ChessBoardSolver.Controller{

    private final View view;
    private Model model;

    public Control(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void solveChessBoard() {
        if (!model.isEmptyPeces()) {
            Peça p = model.getPrimeraPeça();
            new Thread(() -> solve(p)).start();
        } else {
            view.showPutOnePieceMessage();
        }
    }

    private void solve(Peça p) {
        view.setToolbarLabelContent("Calculant recorregut...");
        if (backtracking(p)) {
            showSolution(p);
        } else {
            view.showCanNotSolveChessBoardMessage();
        }
        view.setToolbarLabelContent("");
    }

    @Override
    public void createPeça(int x, int y, TipusPeça tipus) {
        model.AddPeça(x, y, tipus);
        view.paintPeça(x, y, tipus);
    }

    public void showSolution(Peça p) {
        for (int i = 0; i < p.getTauler().length; i++) {
            for (int j = 0; j < p.getTauler()[i].length; j++) {
                if (p.getTauler()[i][j].getTorn() != 0) {
                    view.setNumberToCasilla(i, j, p.getTauler()[i][j].getTorn());
                }
            }
        }
    }

    private boolean backtracking(Peça p) {
        if (p.hasFinished()) {
            return true;
        } else {
            for (int i = 0; i < p.getTauler().length; i++) {
                for (int j = 0; j < p.getTauler()[i].length; j++) {
                    if (p.validMove(i, j)) {
                        int x = p.getX();
                        int y = p.getY();
                        p.visit(i, j);
                        if (backtracking(p)) {
                            return true;
                        } else {
                            p.getBack(x, y);
                        }
                    }
                }
            }
            return false;
        }
    }

    @Override
    public void reset() {
        view.resetView();
        model = new Model();
    }
}
