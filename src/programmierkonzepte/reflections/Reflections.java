package programmierkonzepte.reflections;

import global.Workable;
import uebungen.artikel.Artikel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflections implements Workable {


    @Override
    public void dowork() {
        Artikel a = new Artikel(1, "Blubbb");
        // Metaklasse
        Class meta = a.getClass();
        Class meta2 = Artikel.class;

        for (Field field : meta.getDeclaredFields()) {
            System.out.println(
                    field.getName() + " : " +
                    field.getType().getName());
            if(field.getName().equals("preis")) {
                try {
                    field.setAccessible(true);
                    field.set(a, 99.9);
                } catch (IllegalAccessException e) {
                   e.printStackTrace();
                }
            }
        }
        System.out.println("Preis: " + a.getPreis());

        for (Field field : meta.getDeclaredFields()) {
            System.out.println(
                    field.getName() + " : " +
                            field.getType().getName());
            if(field.getName().equals("preis")) {
                try {
                    field.set(a, 12);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Preis: " + a.getPreis());
        for (Method m : meta.getDeclaredMethods()) {
            System.out.println(m.getName() + " : " + m.getReturnType().getName());
        }
        try {
            Method sp = meta.getDeclaredMethod("setPreis",double.class);
            sp.invoke(a,42.0);

            Method gp = meta.getDeclaredMethod("getPreis");
            Object o =  gp.invoke(a);

            System.out.println("DER PREIS: " +  o );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
