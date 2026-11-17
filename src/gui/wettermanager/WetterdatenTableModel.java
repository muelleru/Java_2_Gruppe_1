package gui.wettermanager;

import db.Wetterdaten;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class WetterdatenTableModel extends AbstractTableModel {
    private List<Wetterdaten> daten;

    public WetterdatenTableModel(List<Wetterdaten> daten) {
        this.daten = daten;
    }

    public WetterdatenTableModel() {

    }

    public void setData(List<Wetterdaten> daten) {
        this.daten = daten;
        fireTableDataChanged();
    }
    public List<Wetterdaten> getData() {
        return daten;
    }

    @Override
    public int getRowCount() {
        return daten != null ? daten.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return Wetterdaten.class.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (daten != null) {
            Wetterdaten wd = daten.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return wd.getYyyy();
                case 1:
                    return wd.getMm();
                case 2:
                    return wd.getRain();
                case 3:
                    return wd.getSun();
                case 4:
                    return wd.getTmin();
                case 5:
                    return wd.getTmax();
                case 6:
                    return wd.getAf();
                default:
                    return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "YYYY";
            case 1:
                return "MM";
            case 2:
                return "Rain";
            case 3:
                return "Sun";
            case 4:
                return "Tmin";
            case 5:
                return "Tmax";
            case 6:
                return "Af";
            default:
                return null;
        }
    }
}
