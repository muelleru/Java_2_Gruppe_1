package algodat.generics;

import global.Workable;

import java.util.ArrayList;

public class MyArrayListTest implements Workable {

    @Override
    public void dowork() {
        MyArrayList<String> l1 = new  MyArrayList<>();
        l1.add("Anton");
        l1.add("Berta");
        l1.add("Cäsar");


        for (var elem : l1) {
            System.out.println(elem);
        }
        System.out.println("*************");
        l1.remove("Berta");
        l1.forEach(System.out::println);
        System.out.println("*************");
        l1.add("Dora");
        l1.forEach(System.out::println);
        System.out.println("*************");

        var spliterator = l1.spliterator();
        var s2 = spliterator.trySplit();
        spliterator.forEachRemaining(System.out::println);
        System.out.println("**");
        s2.forEachRemaining(System.out::println);



    }
}
