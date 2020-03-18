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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import reines.ChessBoardSolver;
import reines.TipusPeça;

/**
 *
 * @author biels
 */
public class View extends JFrame implements ChessBoardSolver.View {

    private JPanel panel;
    private JPanel grid;
    private JButton[][] chessBoardSquares;
    private JPanel boardConstrain;
    private ChessBoardSolver.Controller control;
    private JLabel toolbarLabel;
    private final View context = this;
    private int size = 4;

    public View(int size) {
        this.size = size;
        startChessBoard();
    }

    private void startChessBoard() {
        initView();
        setTitle("ChessBoard Solver");
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(getSize());
        setVisible(true);
    }

    private void initView() {
        initPanel();
        initToolbar();
        initChessBoard();
        setToolbarLabelContent("La primera peça col·locada realitzará el recorregut");
        add(panel);
        pack();
    }

    private void initPanel() {
        panel = new JPanel(new BorderLayout(3, 3));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    @Override
    public void setControlador(ChessBoardSolver.Controller con) {
        control = con;
    }

    //PERMITE REDIMENSIONAR EL TABLERO
    private void initChessBoard() {
        grid = new JPanel(new GridLayout(0, size)) {
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
        boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.add(grid);
        setCaselles();
        panel.add(boardConstrain);
    }

    //PINTA LA BARRA Y EL BOTON INICIAR
    private void initToolbar() {
        JToolBar tools = new JToolBar();
        panel.add(tools, BorderLayout.PAGE_START);
        tools.setFloatable(false);
        JButton iniciar = new JButton("Iniciar");
        JButton reset = new JButton("Reset");
        reset.addActionListener((ActionEvent) -> {
            control.reset();
            iniciar.setEnabled(true);
        });
        iniciar.addActionListener((ActionEvent) -> {
            setChssBoardNotClickable();
            iniciar.setEnabled(false);
            control.solveChessBoard();
        });
        toolbarLabel = new JLabel();
        JLabel labelSize = new JLabel(Integer.toString(size), SwingConstants.CENTER);
        JButton minus = new JButton("-");
        minus.addActionListener((ActionEvent) -> {
            if (size > 4) {
                size--;
                control.changeSize(size);
            }
        });
        JButton plus = new JButton("+");
        plus.addActionListener((ActionEvent) -> {
            if (size < 8) {
                size++;
                control.changeSize(size);
            }
        });
        
        tools.add(iniciar);
        tools.addSeparator();
        tools.add(reset);
        tools.addSeparator();
        tools.add(toolbarLabel);
        tools.add(Box.createHorizontalGlue());
        tools.add(minus);
        tools.addSeparator();
        tools.add(labelSize);
        tools.addSeparator();
        tools.add(plus);
    }

    //PINTA LAS CASILLAS DEL TABLERO
    private void setCaselles() {
        chessBoardSquares = new JButton[size][size];
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                b.setPreferredSize(new Dimension(80, 80));
                b.setFont(new Font("Arial", Font.PLAIN, 64));
                if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.LIGHT_GRAY);
                }
                final int x = ii;
                final int y = jj;
                b.addActionListener((ActionEvent) -> {
                    JDialog d = new ChoosePieceDialog(x, y);
                });
                chessBoardSquares[ii][jj] = b;
                grid.add(b);
            }
        }
    }

    @Override
    public void paintPeça(int x, int y, TipusPeça tipus) {
        Imatge img = getImage(tipus);
        chessBoardSquares[x][y].setIcon(img.getIcon());
    }

    @Override
    public void setNumberToCasilla(int x, int y, int number) {
        chessBoardSquares[x][y].setText(Integer.toString(number));
        chessBoardSquares[x][y].setFont(new Font("Arial", Font.PLAIN, 64));
    }

    @Override
    public void showCanNotSolveChessBoardMessage() {
        JOptionPane.showMessageDialog(this, "Aquesta peça no pot recòrrer tot el tauler.");
    }

    @Override
    public void showPutOnePieceMessage() {
        resetView();
        JOptionPane.showMessageDialog(this, "Afegeix mínim una peça per iniciar el recorregut.");
    }

    @Override
    public void resetView() {
        remove(panel);
        initView();
    }

    @Override
    public void setToolbarLabelContent(String s) {
        toolbarLabel.setText(s);
    }

    private Imatge getImage(TipusPeça tipus) {
        Imatge img = null;
        switch (tipus) {
            case CAVALL:
                img = Imatge.CAVALL;
                break;
            case TORRE:
                img = Imatge.TORRE;
                break;
            case PEO:
                img = Imatge.PEO;
                break;
            case REI:
                img = Imatge.REI;
                break;
            case REINA:
                img = Imatge.REINA;
                break;
        }
        return img;
    }

    private void setChssBoardNotClickable() {
        for (JButton[] chessBoardSquare : chessBoardSquares) {
            for (JButton chessBoardSquare1 : chessBoardSquare) {
                chessBoardSquare1.removeActionListener(chessBoardSquare1.getActionListeners()[0]);
            }
        }
    }

    private class ChoosePieceDialog extends JDialog {

        private final JPanel panel;
        private final int peçaX;
        private final int peçaY;

        public ChoosePieceDialog(int x, int y) {
            super(context, "Choose yor piece", true);
            this.peçaX = x;
            this.peçaY = y;
            panel = new JPanel();
            createButtonWithIcon(Imatge.CAVALL, TipusPeça.CAVALL);
            createButtonWithIcon(Imatge.REI, TipusPeça.REI);
            createButtonWithIcon(Imatge.REINA, TipusPeça.REINA);
            createButtonWithIcon(Imatge.TORRE, TipusPeça.TORRE);
            createButtonWithIcon(Imatge.PEO, TipusPeça.PEO);
            getContentPane().add(panel);
            pack();
            setLocationRelativeTo(context);
            setVisible(true);
        }

        private void createButtonWithIcon(Imatge icon, TipusPeça tipus) {
            JButton button = new JButton(icon.getIcon());
            button.setPreferredSize(new Dimension(100, 100));
            button.addActionListener((ActionEvent) -> {
                control.createPeça(peçaX, peçaY, tipus);
                dispose();
            });
            panel.add(button);
        }
    }
}
