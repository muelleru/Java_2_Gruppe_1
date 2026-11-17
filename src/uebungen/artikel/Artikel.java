package uebungen.artikel;

import java.util.StringJoiner;

public class Artikel {

    private int nummer;
    private String bezeichnung;
    private String programmiersprache;
    private String beschreibung;
    private double preis;

    public Artikel(int nummer, String bezeichnung) {
        setNummer(nummer);
        setBezeichnung(bezeichnung);
        setPreis(0.0); // this.preis = 0.0;
        setProgrammiersprache("C#");
        setBeschreibung(""); // Ohne Setzen wäre beschreibung := null
    }

    //region Getter
    public int getNummer() {
        return nummer;
    }
    public String getBezeichnung() {
        return bezeichnung;
    }
    public String getProgrammiersprache() {
        return programmiersprache;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public double getPreis() {
        return preis;
    }
    //endregion
    //region Setter

    private void setNummer(int nummer) {
        if(nummer > 0) {
            this.nummer = nummer;
        } else {
            this.nummer = 0;
        }
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public void setProgrammiersprache(String programmiersprache) {
        this.programmiersprache = programmiersprache;
    }
    protected void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public void setPreis(double preis) {
        if(preis >=0) {
            this.preis = preis;
        } else {
            throw new IllegalArgumentException("Preis");
        }
    }
    //endregion


    @Override
    public String toString() {
     return "| %5d | %-20s | %15s | %40s | %6.2f |".formatted(nummer,bezeichnung,
             programmiersprache,beschreibung,preis);
    }

}
