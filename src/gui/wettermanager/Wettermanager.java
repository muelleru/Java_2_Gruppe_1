package gui.wettermanager;

import global.Workable;

import javax.swing.*;

public class Wettermanager implements Workable {
    @Override
    public void dowork() {
        SwingUtilities.invokeLater( ()-> {
            FrmMain frm = new FrmMain();
        });
    }
}
