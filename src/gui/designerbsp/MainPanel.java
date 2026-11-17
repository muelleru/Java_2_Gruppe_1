package gui.designerbsp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainPanel {

    private JButton btnOK;
    private JTextField txtVorname;
    private JTextField txtNachname;
    private JLabel lblVorname;
    private JLabel lblNachname;
    private JPanel pnlMain;
    private JComboBox cbxGeschlecht;
    private JLabel lblGeschlecht;

    public MainPanel() {
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cbxGeschlecht.setModel(new DefaultComboBoxModel(List.of("","Frau","Herr","Divers").toArray()));


    }

    public JPanel getPanel() {
        return pnlMain;
    }

}
