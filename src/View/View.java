/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author biels
 */
public class View extends JFrame {

    JPanel panel;

    public View() {
        panel = new JPanel(new BorderLayout(3, 3));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        initToolbar();
        initChessBoard();
        this.add(panel);
    }

    private void initChessBoard() {
        JPanel grid = new JPanel(new GridLayout(0, 8)) {
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int) d.getWidth(), (int) d.getHeight());
                } else if (c.getWidth() > d.getWidth()
                        && c.getHeight() > d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                int s = (w > h ? h : w);
                return new Dimension(s, s);
            }
        };
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.add(grid);
        setCaselles(grid);
        panel.add(boardConstrain);
    }

    private void initToolbar() {
        JToolBar tools = new JToolBar();
        panel.add(tools, BorderLayout.PAGE_START);
        tools.setFloatable(false);
        tools.add(new JButton("Save"));
        tools.addSeparator();
        tools.add(new JButton("Restore"));
        tools.addSeparator();
        tools.add(new JButton("Resign"));
        tools.addSeparator();
    }

    private void setCaselles(JPanel grid) {
        JButton[][] chessBoardSquares = new JButton[8][8];
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                b.setPreferredSize(new Dimension(80,80));
                b.setFont(new Font("Arial", Font.PLAIN, 64));
                if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.LIGHT_GRAY);
                }
                grid.add(b);
            }
        }
    }

}