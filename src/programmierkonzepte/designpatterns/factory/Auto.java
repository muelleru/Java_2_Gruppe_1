package programmierkonzepte.designpatterns.factory;

import java.util.StringJoiner;

public abstract class Auto {
    private String hersteller;
    private String typ;
    public Auto(String hersteller, String typ) {
        this.hersteller = hersteller;
        this.typ = typ;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("hersteller='" + hersteller + "'")
                .add("typ='" + typ + "'")
                .toString();
    }
}
