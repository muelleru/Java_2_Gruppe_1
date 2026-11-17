package uebungen.artikel;

import global.Workable;

public class ArtikelVerwaltung implements Workable {

    @Override
    public void dowork() {
        ArtikelListe artikelliste = new ArtikelListe();

        artikelliste.add(new Artikel(4711,"Diashow"));
        artikelliste.add(new Artikel(4712,"Bildbeschriftung"));
        artikelliste.add(new Artikel(8726,"100 Piktos"));

        Artikel tmp = artikelliste.get(4711);
        tmp.setBeschreibung("Erlaubt Dia ...");
        tmp.setPreis(29.9);
        tmp.setProgrammiersprache("Java");

        tmp = artikelliste.get(4712);
        tmp.setBeschreibung("Erlaubt Beschriftung ...");
        tmp.setPreis(99.9);
        tmp.setProgrammiersprache("Java");
        try {
            tmp = artikelliste.get(8726);
            tmp.setBeschreibung("100 Pikto ...");
            tmp.setPreis(-49.9);
            tmp.setProgrammiersprache("Java");
        } catch (ArtikelNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("PREIS !!!!"+ ex.getMessage());
        }

        System.out.println(artikelliste);
        double summe = 0.0;
        for(Artikel a : artikelliste) {
            summe += a.getPreis();
        }
        System.out.println("Gesamtpreis: " + summe);
    }
}
