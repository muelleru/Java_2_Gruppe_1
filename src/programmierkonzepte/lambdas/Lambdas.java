package programmierkonzepte.lambdas;

import global.Workable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambdas implements Workable {

    @FunctionalInterface
    interface IntOperator {
        int op(int a, int b);
    }

    void testOp() {
        IntOperator op = (x, y) -> x + y;

        System.out.println(op.op(10, 20));

        op = (x, y) -> x * y;
        System.out.println(op.op(10, 20));

        op = (a,b) -> {
            System.out.println("LAMBDA");
            return (b+2) * (a-2);
        };
    }

    @Override
    public void dowork() {

        ArrayList<Integer> liste = new ArrayList<>(List.of(10, 20, 5, 15, 25, 15, 10, 12, 13, 15, 16, 8));
        // Predicate<Integer>

        liste.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer >= 10 && integer <= 19) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        // Lambda-Ausdruck => Funkionsausdruck
        // () -> System.println();
        // x -> System.println(x);
        // (x,y) -> x+y; // return x+y;
        // (Integer x) -> x >= 20
        // x -> x >= 20

        //[20, 5, 25, 8]
        liste.removeIf(x -> x >= 20); // Werfe alle Zahlen >= 20 aus der Liste

        //[5, 8]
        System.out.println(liste);

        Predicate<Integer> pr = x -> x >= 20;
        boolean res = pr.test(19);

        System.out.println("***************************");
        liste.forEach(x -> System.out.println("ELEM: " + x));

        System.out.println("***************************");
        liste.forEach(System.out::println); // Funktion direkt übergeben


    }


}
