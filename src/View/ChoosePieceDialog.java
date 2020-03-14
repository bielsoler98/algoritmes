/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author biels
 */
public class ChoosePieceDialog extends JDialog {
    
    JPanel panel;
    
    private final ImageIcon cavall = new ImageIcon(new ImageIcon(getClass()
            .getResource("images/WhiteKnight.png")).getImage().
            getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ));
    private final ImageIcon reina = new ImageIcon(new ImageIcon(getClass()
            .getResource("images/WhiteQueen.png")).getImage().
            getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ));
    private final ImageIcon rei = new ImageIcon(new ImageIcon(getClass()
            .getResource("images/WhiteKing.png")).getImage().
            getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ));
    private final ImageIcon torre = new ImageIcon(new ImageIcon(getClass()
            .getResource("images/WhiteRook.png")).getImage().
            getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ));
    private final ImageIcon peo = new ImageIcon(new ImageIcon(getClass()
            .getResource("images/WhitePawn.png")).getImage().
            getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ));
    
    JButton casella;

    public ChoosePieceDialog(JFrame frame, JButton b) {
        super(frame, "Choose yor piece", true);
        casella = b;
        panel = new JPanel();
        createButtonWithIcon(cavall);
        createButtonWithIcon(rei);
        createButtonWithIcon(reina);
        createButtonWithIcon(torre);
        createButtonWithIcon(peo);
        this.add(panel);
        getContentPane().add(panel);
        pack();
    }

    private void createButtonWithIcon(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(100, 100));
        button.addActionListener((ActionEvent) -> {
            casella.setIcon(icon);
            dispose();
        });
        panel.add(button);
    }
}
