package programmierkonzepte.designpatterns.factory;
public class VolkswagenFabrik extends Fabrik {
    @Override
    public Auto createAuto(String art, String typ) {
        Auto a = switch (art) {
            case "Sportwagen" -> {
                String x = typ == "Oberklasse" ? "Käfer" : "Schirocco";
                yield new Sportwagen("VW", x, 100);
            }
            case "Kombi" -> new Kombi("VW", typ == "Oberklasse" ? "Passat" : "Golf Variant", 5);
            default -> new Kombi("VW", "Käfer", 13);
        };
        return a;
    }
}
