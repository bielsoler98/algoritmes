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
public interface ChessBoardSolver {
    interface Controller {
        
    }
    
    interface View {
        void showPutOnePieceMessage();
        void showCanNotSolveChessBoardMessage();
        void resetView();
    }
    
    interface Model {
        
    }
}
