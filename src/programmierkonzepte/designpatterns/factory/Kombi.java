package programmierkonzepte.designpatterns.factory;

public class Kombi extends Auto{

    private int sitzplaetze;

    public Kombi(String hersteller, String typ, int sitzplaetze) {
        super(hersteller, typ);
        this.sitzplaetze = sitzplaetze;
    }
}
