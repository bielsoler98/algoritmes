/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Control;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author biels
 */
public class View extends JFrame{

    private JPanel panel;
    private JPanel grid;
    private JButton[][] chessBoardSquares;
    private JPanel boardConstrain;
    private Control control;

    public View() {
        panel = new JPanel(new BorderLayout(3, 3));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        initToolbar();
        initChessBoard();
        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        pack();
        setMinimumSize(getSize());
        setVisible(true);
    }
    
    public void setControlador(Control con) {
        control = con;
    }
       
    //PERMITE REDIMENSIONAR EL TABLERO
    private void initChessBoard() {
        grid = new JPanel(new GridLayout(0, 8)) {
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
           clearView();
        });
        iniciar.addActionListener((ActionEvent) -> {
           control.start();
        });
        tools.add(iniciar);
        tools.addSeparator();
        tools.add(reset);
    }

    //PINTA LAS CASILLAS DEL TABLERO
    private void setCaselles() {
        chessBoardSquares = new JButton[8][8];
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
                   JDialog d = new ChoosePieceDialog(this,x,y);
                });
                chessBoardSquares[ii][jj] = b;
                grid.add(b);
            }
        }
    }
    
    private void paintPeça(int x, int y, Imatge img){
        chessBoardSquares[x][y].setIcon(img.getIcon());
    }
    
    public void paintCavall(int x, int y){
        paintPeça(x,y,Imatge.CAVALL);
    }
    
    public void paintPeo(int x, int y){
        paintPeça(x,y,Imatge.PEO);
    }
    
    public void paintTorre(int x, int y){
        paintPeça(x,y,Imatge.TORRE);
    }
    
    public void paintRei(int x, int y){
        paintPeça(x,y,Imatge.REI);
    }
    
    public void paintReina(int x, int y){
        paintPeça(x,y,Imatge.REINA);
    }
    
    public void setNumberToCasilla(int x, int y, int number) {
        chessBoardSquares[x][y].setText(Integer.toString(number));
        chessBoardSquares[x][y].setFont(new Font("Arial", Font.PLAIN, 64));
    }
    
    public void showMessage(){
        JOptionPane.showMessageDialog(this, "Aquesta peça no pot recorrer tot el tauler");
    }

    private void clearView() {
        control = null;
        panel.remove(boardConstrain);
        initChessBoard();
        initToolbar();
        this.remove(panel);
        add(panel);
        repaint();
    }
    
    public class ChoosePieceDialog extends JDialog {
    
    private JPanel panel;
    private View view;
    private int peçaX;
    private int peçaY;
    
    public ChoosePieceDialog(View frame, int x, int y) {
        super(frame, "Choose yor piece", true);
        this.view = frame;
        this.peçaX = x;
        this.peçaY = y;
        panel = new JPanel();
        createButtonWithIcon(Imatge.CAVALL,"cavall");
        createButtonWithIcon(Imatge.REI,"rei");
        createButtonWithIcon(Imatge.REINA,"reina");
        createButtonWithIcon(Imatge.TORRE,"torre");
        createButtonWithIcon(Imatge.PEO,"peo");
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(view);
        setVisible(true);
    }

    private void createButtonWithIcon(Imatge icon, String select) {
        JButton button = new JButton(icon.getIcon());
        button.setPreferredSize(new Dimension(100, 100));
        button.addActionListener((ActionEvent) -> {
            control.createPeça(select,peçaX,peçaY);
            dispose();
        });
        panel.add(button);
    }
}

}
