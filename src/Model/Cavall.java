package Model;

/**
 *
 * @author biels
 */
public class Cavall extends Peça {

    public Cavall(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean validMove(int x, int y) {
        return (!(isDiagonal(x, y) || isUp(x, y)
                || isDown(x, y) || isLeft(x, y)
                || isRight(x, y)) && validateHorseMove(x, y) 
                && !hasVisited(x, y));
    }

    private boolean validateHorseMove( int x, int y) {
        return ((Math.abs(this.getX() - x) == 1
                && Math.abs(this.getY() - y) == 2)
                || (Math.abs(this.getX() - x) == 2
                && Math.abs(this.getY() - y) == 1));
    }
}
