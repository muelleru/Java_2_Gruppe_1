package algodat.enums;

import global.Workable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Enums implements Workable {
    public void testEinfacherEnum() {
        Hersteller h = Hersteller.Mercedes;
        System.out.println(h);
        h = Enum.valueOf(Hersteller.class, "BMW");
        System.out.println(h + ": " + h.ordinal());

        // Iteration über die Enum-Werte
        for (Hersteller x : Hersteller.values()) {
            System.out.println(x + ": " + x.ordinal());
        }
        System.out.println(Hersteller.get42());
    }

    public void testKomplexerEnum() {
        ArrayList<Land> EU = new ArrayList<>(
                List.of(Land.Deutschland,
                        Land.Frankreich,
                        Land.Österreich));

        EU.forEach(new Consumer<Land>() {
            @Override
            public void accept(Land land) {
                System.out.println("LAND: " + land);
            }
        });

        EU.forEach(l -> System.out.println("L: " + l));

        MyForEach(EU, l -> System.out.println("L: " + l));

        for (Land land : EU) {
            System.out.println(land);
        }
            /*List<Land> immutableList = List.of(Land.Schweiz);
            immutableList.add(Land.Deutschland);
            immutableList.forEach(System.out::println);*/

        Land x = Land.Österreich;
        System.out.println(x.name() + " => " + x.getHauptstadt() + ", " + x.getSprache());

    }

    public void MyForEach(List<Land> liste, Consumer<Land> consumer) {
        for (Land l : liste) {
            consumer.accept(l);
        }
    }

    @Override
    public void dowork() {
        // testEinfacherEnum();
        testKomplexerEnum();
    }
}
