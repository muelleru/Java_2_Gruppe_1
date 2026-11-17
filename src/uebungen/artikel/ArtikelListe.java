package uebungen.artikel;

// Decorator

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArtikelListe implements Iterable<Artikel>{

    private List<Artikel> artikelListe;

    public ArtikelListe() {
        artikelListe = new ArrayList<>();
    }

    @Override
    public Iterator<Artikel> iterator() {
        return artikelListe.iterator();
    }

    public void add(Artikel artikel) {
        artikelListe.add(artikel);
    }

    public void remove(int nummer) {
        artikelListe.removeIf( a -> a.getNummer() == nummer );
    }

    public Artikel get(int nummer) {

        for (Artikel artikel : artikelListe) {
            if(nummer == artikel.getNummer()) {
                return artikel;
            }
        }
        // Nicht gefunden!!!
        //return null;
        throw new ArtikelNotFoundException("Artikel " + nummer + " nicht gefunden");
    }
    @Override
   public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("********** Artikelliste *********" + System.lineSeparator());
        for (Artikel a : artikelListe) {
            buffer.append(a.toString()+System.lineSeparator());
        }
        buffer.append("*********************************" + System.lineSeparator());
        return buffer.toString();
   }
}
