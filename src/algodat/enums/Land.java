package algodat.enums;

public enum Land {

    Schweiz("Bern","deutsch(unverständlich)","CH",Waehrung.EUR),
    Österreich("Wien","deutsch","AUT", Waehrung.EUR),
    Frankreich("Paris","franz.","FRA", Waehrung.EUR),
    Deutschland("Berlin","deutsch","GER",Waehrung.EUR);

    public static enum LandKuerzel {CH,AUT,GER}
    public static enum Waehrung {USD, EUR, CHF}

    private String hauptstadt;
    private String sprache;
    private String kuerzel;             /* LandKuerzel kuerzel als Alternative */
    private Waehrung waehrung;

    Land(String hauptstadt, String sprache, String kuerzel, Waehrung waehrung) {
        this.hauptstadt = hauptstadt;
        this.sprache = sprache;
        this.kuerzel = kuerzel;
        this.waehrung = waehrung;
    }

    public String getHauptstadt() {
        return hauptstadt;
    }

    public Land setHauptstadt(String hauptstadt) {
        this.hauptstadt = hauptstadt;
        return this;
    }

    public String getSprache() {
        return sprache;
    }

    public Land setSprache(String sprache) {
        this.sprache = sprache;
        return this;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public Land setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
        return this;
    }

    public Waehrung getWaehrung() {
        return waehrung;
    }

    public Land setWaehrung(Waehrung waehrung) {
        this.waehrung = waehrung;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Land{");
        sb.append("hauptstadt='").append(hauptstadt).append('\'');
        sb.append(", sprache='").append(sprache).append('\'');
        sb.append(", kuerzel='").append(kuerzel).append('\'');
        sb.append(", waehrung=").append(waehrung);
        sb.append('}');
        return sb.toString();
    }
}
