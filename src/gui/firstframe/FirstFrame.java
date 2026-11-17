package gui.firstframe;

import global.Workable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstFrame implements Workable {


    @Override
    public void dowork() {

        SwingUtilities.invokeLater( ()-> {

            JFrame frame = new JFrame("Erster Frame");
            frame.setVisible(true);
            frame.setBounds(20,20,400,300);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(0,3));

            frame.setContentPane(panel);
            panel.setBackground(Color.yellow);

            JButton btnHelp = new JButton("Help");
            btnHelp.setText("Hilfe");

            JButton btnOk = new JButton("Ok");

            JButton btnCancel = new JButton("Cancel");
            panel.add(btnOk);
            panel.add(btnCancel);
            panel.add(btnHelp);
            panel.add(new JLabel());// Dummy

            JLabel lblName = new JLabel("Name");
            panel.add(lblName);

            JTextField txtName = new JTextField();
            panel.add(txtName);

            btnHelp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,"Hilfe .","Hilfe-Fenster", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            btnOk.addActionListener( e -> {
                txtName.setText("Hans-Hugo Maier");
            });

            btnCancel.addActionListener( e-> {
                //frame.dispose();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            });

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if(JOptionPane.showConfirmDialog(frame,"Wirklich???","Beenden",JOptionPane.YES_NO_OPTION)
                            ==
                            JOptionPane.YES_OPTION) {
                        frame.dispose();
                    }
                }
            });


            frame.pack();

        });

    }
}
