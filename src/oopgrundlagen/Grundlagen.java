package oopgrundlagen;

import global.Workable;

public class Grundlagen implements Workable {

    @Override
    public void dowork() {
        System.out.println("Grundlagen Start");
        testPoly();
        testException();
    }
    private void testException() {

        Person x = new Person();
        try {
            x.setAlter(121);
        } catch(AlterOutOfBoundException ex) {
            System.out.println(ex.getMessage());
            int a = ex.getAlter();
            System.out.println("Alter: " + a);
        } catch(Exception ex) {
            System.out.println("Fataler Fehler");
            ex.printStackTrace();
        } finally {
            System.out.println("BYE BYE");
        }
    }

    private void testPoly() {
        // Kein Objekt einer abstrakten Klasse möglich
        // Form f1 = new Form(1,"blau");
        Kreis k1 = new Kreis();
        System.out.println(k1);
        Form f1 = new Kreis(1,"grün",4);
        System.out.println(f1);

        // double r0 = f1.getRadius();
        if(f1 instanceof Kreis) {
            Kreis tmp = (Kreis)f1;
            double r1 = ((Kreis) f1).getRadius();
            // f1 ist kompatibel mit Kreis
        }

        if(f1 instanceof Kreis tmp) {
            double r1 = tmp.getRadius();
        }

        Class meta = f1.getClass();
        System.out.println(meta.getName());
        // Über Meta-Klasse Class
        if(f1.getClass() == Kreis.class) {
            // identische Klasse
        }




    }

}
