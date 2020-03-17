/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.ImageIcon;

/**
 *
 * @author Andrea
 */
public class Imatge {

    private ImageIcon icon;

    public static final Imatge CAVALL = new Imatge("images/WhiteKnight.png");
    public static final Imatge REINA = new Imatge("images/WhiteQueen.png");
    public static final Imatge REI = new Imatge("images/WhiteKing.png");
    public static final Imatge TORRE = new Imatge("images/WhiteRook.png");
    public static final Imatge PEO = new Imatge("images/WhitePawn.png");

    public Imatge(String I) {
        icon = new ImageIcon(
                new ImageIcon(getClass().getResource(I)).getImage()
                        .getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)
        );
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
