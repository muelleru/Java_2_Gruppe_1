package programmierkonzepte.inner;

public class Person {
    // Adresse = ORT, PLZ, STRASSE, HNR
    private static class Adresse
            implements AdresseView{
        private String ort;
        private String plz;
        private String strasse;
        private String hnr;
        public Adresse(String ort, String plz, String strasse, String hnr) {
            this.ort = ort;
            this.plz = plz;
            this.strasse = strasse;
            this.hnr = hnr;
        }
        public String getOrt() {
            return ort;
        }
        public String getPlz() {
            return plz;
        }
        public String getStrasse() {
            return strasse;
        }
        public String getHnr() {
            return hnr;
        }
    }
    private int id;
    private String vorname;
    private String nachname;
    private Adresse adresse;

    public Person() {
        adresse = new Adresse("Karlsruhe","76000","Hauptstr.","1");
    }
    public AdresseView getAdresse() {
        return adresse;
    }
    public String getOrt() {
        return adresse.getOrt();
    }

}
