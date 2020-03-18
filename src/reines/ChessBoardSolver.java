/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reines;

import Model.Peça;
import java.util.ArrayList;

/**
 *
 * @author biels
 */
public interface ChessBoardSolver {
interface Controller {
        void solveChessBoard();
        void createPeça(int x, int y, TipusPeça tipus);
        void reset();
        public void changeSize(int size);
    }
    
    interface View {
        void showPutOnePieceMessage();
        void showCanNotSolveChessBoardMessage();
        void resetView();
        void setToolbarLabelContent(String s);
        void paintPeça(int x, int y, TipusPeça tipus);
        void setNumberToCasilla(int x, int y, int number);
        void setControlador(Controller con);
    }
    
    interface Model {
        boolean isEmptyPeces();
        Peça getPrimeraPeça();
        void AddPeça(int x, int y, TipusPeça t);
        void resetModel();
    }
}
