package io.wetterdaten;

import db.Wetterdaten;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WetterdatenIO {

    public static void schreibeWetterdaten(String filename, List<Wetterdaten> wetterdatenList) {
        // CSV schreiben
        Path path = Path.of(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            for(Wetterdaten wd : wetterdatenList) {
                writer.write(wd.toCSV());
                writer.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static  List<Wetterdaten> leseWetterdaten(String filename) {
        Path path = Path.of(filename);
        String zeile;
        ArrayList<Wetterdaten> wdliste = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            while((zeile = reader.readLine()) !=null) {
                wdliste.add(Wetterdaten.fromCSV(zeile));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return wdliste;
    }

}
