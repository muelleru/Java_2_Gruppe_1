package gui.wettermanager;

import db.DbWetterdaten;
import db.Wetterdaten;
import io.wetterdaten.WetterdatenIO;

import javax.swing.*;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.*;

public class FrmMain extends JFrame {

    private JPanel pnlMain;
    private JScrollPane scrWetterdaten;
    private JTable tblWetterdaten;
    private JButton btnLoad;
    private JButton btnSaveCSV;
    private JButton btnSort;
    private JComboBox cbxSort;
    private WetterdatenTableModel model;

    public FrmMain() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 1024, 800);
        setResizable(false);
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        setContentPane(pnlMain);
        scrWetterdaten = new JScrollPane();
        model = new WetterdatenTableModel();
        tblWetterdaten = new JTable(model);

        scrWetterdaten.setViewportView(tblWetterdaten);
        pnlMain.add(scrWetterdaten);
        scrWetterdaten.setBounds(0, 200, 1024, 600);
        // Z1:  Load, Save
        btnLoad = new JButton("Lade aus DB");
        btnLoad.setBounds(10, 10, 100, 30);
        btnSaveCSV = new JButton("Speichere als CSV");
        btnSaveCSV.setBounds(110, 10, 100, 30);

        // Z2: Sort
        btnSort = new JButton("Sortiere Table nach");
        btnSort.setBounds(10, 50, 100, 30);
        cbxSort = new JComboBox<>();
        cbxSort.setBounds(110, 50, 100, 30);
        cbxSort.setModel(new DefaultComboBoxModel(List.of("TMax", "TMin").toArray()));
        // Felder aus DB laden??? oder aus class Wetterdaten?

        pnlMain.add(btnLoad);
        pnlMain.add(btnSaveCSV);
        pnlMain.add(btnSort);
        pnlMain.add(cbxSort);

        btnLoad.addActionListener( e-> {
            DbWetterdaten.getInstance().setMessager( s-> JOptionPane.showMessageDialog(this,s));
            DbWetterdaten.getInstance().open();

            List<Wetterdaten> wds = DbWetterdaten.getInstance().getWetterdaten();
            model.setData(wds);

            DbWetterdaten.getInstance().close();
        });

        btnSaveCSV.addActionListener( e-> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);

            File dir = new File("c:\\temp");


            fileChooser.setCurrentDirectory(dir);

            // fileChooser.setFileFilter();
//            if(fileChooser.showDialog(FrmMain.this,"Speichern") == JFileChooser.APPROVE_OPTION) {
             if(fileChooser.showSaveDialog(FrmMain.this) == JFileChooser.APPROVE_OPTION) {
                try {
                    WetterdatenIO.schreibeWetterdaten(
                            fileChooser.getSelectedFile().getAbsolutePath(),
                            model.getData());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FrmMain.this,ex.getMessage());
                }
            }

        });

        btnSort.addActionListener( x-> {
            List<Wetterdaten> wdliste = model.getData();
            // Collections.sort(wdliste);
            Collections.sort(wdliste, new Comparator<Wetterdaten>() {
                @Override
                public int compare(Wetterdaten o1, Wetterdaten o2) {
                    // o1 > o2 => return 1
                    // o1 == o2 => return 0
                    // o1 < o2  => return -1
                    // return (int)(o2.getTmax()-o1.getTmax());
                    return o2.getTmax().compareTo(o1.getTmax());
                }
            });
            // AUSWAHL ÜBER MAP
            // Map<String,Comparator<Wetterdaten>> compList = new HashMap<>();
            // compList.put("tmax",(w1, w2) -> w2.getTmax().compareTo(w1.getTmax()));
            // compList.put("tmin",(w1, w2) -> w2.getTmin().compareTo(w1.getTmin()));
            // wdliste.sort(compList.get(cbxSort.getSelectedItem().toString().toLowerCase()));

            switch(cbxSort.getSelectedItem().toString().toLowerCase()) {
                case "tmax":
                    wdliste.sort((w1, w2) -> w2.getTmax().compareTo(w1.getTmax()));
                    break;
                case "tmin":
                    wdliste.sort((w1, w2) -> w2.getTmax().compareTo(w1.getTmin()));
                    break;
            }

            model.fireTableDataChanged();

        });

    }


}
