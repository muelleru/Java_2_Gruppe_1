package programmierkonzepte.designpatterns.factory;

public class Sportwagen extends  Auto {
    private int leistung;
    public Sportwagen(String hersteller, String typ, int leistung) {
        super(hersteller, typ);
        this.leistung = leistung;
    }
}
