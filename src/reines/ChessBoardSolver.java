/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import Model.Peça;

/**
 *
 * @author biels
 */
public interface ChessBoardSolver {
interface Controller {
        void solveChessBoard();
        void createPeça(int x, int y, TipusPeça tipus);
        void reset();
    }
    
    interface View {
        void showPutOnePieceMessage();
        void showCanNotSolveChessBoardMessage();
        void resetView();
        void setToolbarLabelContent(String s);
        void paintPeça(int x, int y, TipusPeça tipus);
        void setNumberToCasilla(int x, int y, int number);
    }
    
    interface Model {
        boolean isEmptyPeces();
        Peça getPrimeraPeça();
        void AddPeça(int x, int y, TipusPeça t);
    }
}
