package uebungen.artikel;

public class ArtikelNotFoundException extends RuntimeException {
    public ArtikelNotFoundException(String message) {
        super(message);
    }
}
