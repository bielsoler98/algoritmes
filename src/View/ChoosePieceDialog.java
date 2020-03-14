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
import javax.swing.JPanel;

/**
 *
 * @author biels
 */
public class ChoosePieceDialog extends JDialog {
    
    private JPanel panel;
    private View view;
    
    public ChoosePieceDialog(View frame) {
        super(frame, "Choose yor piece", true);
        this.view = frame;
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
            view.notifySelection(select);
            dispose();
        });
        panel.add(button);
    }
}
