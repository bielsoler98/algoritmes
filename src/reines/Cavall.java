package reines;

import javax.swing.ImageIcon;

/**
 *
 * @author biels
 */
public class Cavall extends Peça {

    public Cavall(int x, int y, ImageIcon img) {
        super(x, y, img);
    }
    
    @Override
    boolean validMove(Casella desti) {
        return (!(position.isDiagonal(desti) || position.isUp(desti)
                || position.isDown(desti) || position.isLeft(desti)
                || position.isRight(desti)) && validateHorseMove(desti) 
                && !desti.isVisited());
    }

    private boolean validateHorseMove( Casella desti) {
        return ((Math.abs(position.getX() - desti.getX()) == 1
                && Math.abs(position.getY() - desti.getY()) == 2)
                || (Math.abs(position.getX() - desti.getX()) == 2
                && Math.abs(position.getY() - desti.getY()) == 1));
    }
}
