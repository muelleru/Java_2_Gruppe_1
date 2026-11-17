package programmierkonzepte.designpatterns.factory;

public class AudiFabrik extends Fabrik {
    @Override
    public Auto createAuto(String art, String typ) {
        Auto a = switch (art) {
            case "Sportwagen" -> {
                String x = typ == "Oberklasse" ? "R8" : "S2";
                yield new Sportwagen("Audi", x, 100);
            }
            case "Kombi" -> new Kombi("Audi", typ == "Oberklasse" ? "A6 Avant" : "A4 Avant", 5);
            default -> new Kombi("Audi", "RS 4 Avant", 14);
        };
        return a;
    }
}
