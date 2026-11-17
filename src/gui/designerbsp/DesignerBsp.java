package gui.designerbsp;

import global.Workable;

import javax.swing.*;

public class DesignerBsp implements Workable {


    @Override
    public void dowork() {
        SwingUtilities.invokeLater( () -> {
             JFrame frame = new JFrame("Designer");
             MainPanel designer = new MainPanel();

             frame.setContentPane(designer.getPanel());
             frame.setVisible(true);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setBounds(10,10,400,300);
        });
    }


}
