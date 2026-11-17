package algodat.framework;

import global.Workable;

import java.util.*;

public class CollectionFramework implements Workable {

    public void testMap() {

        Map<String,String> kuerzel = new HashMap<>(Map.of(
                "AUT","Österreich",
                "CH","Schweiz",
                "GER","Deutschland",
                "FRA","Frankreich"));

        System.out.println(kuerzel.get("CH"));
        System.out.println(kuerzel.get("GER"));

        Map<String,Object> p1 = new HashMap<>(Map.of(
                "Vorname","Kurt",
                "Nachname","Maier",
                "Alter", 99,
                "Id",12
        ));
        // JSON JavaScript Object Notation
        /*
            {
                "Vorname" : "Kurt",
                "Nachname": "Maier",
                "Alter": 99,
                "Id":12
            }
         */

        for(Map.Entry<String,Object> kv : p1.entrySet()) {
            System.out.println(kv.getKey() + " => " + kv.getValue());
        }

        for(String key : p1.keySet()) {
            System.out.println(key + " : " + p1.get(key));
        }


    }

    public void testSet() {
        // TreeSet und HashSet

        Set<Integer> set1 = new HashSet<>(List.of(10,20,30,40,50));
        System.out.println(set1);
        System.out.println("*********");
        set1.add(10);
        set1.add(15);
        set1.add(20);
        System.out.println(set1);


    }
    public void testLinkedList() {
        Iterable<Integer> schnittstelle0;
        Collection<Integer> schnittstelle1;
        List<Integer> schnittstelle2;
        schnittstelle2 = new ArrayList<>(); // Kapselt ein Array
        schnittstelle2 = new LinkedList<>(); // Doppelt verkettete Liste

        Stack<String> stck = new Stack<>();
        stck.push("A");
        stck.push("B");
        while(stck.size()>0) {
            System.out.println(stck.pop());
        }

        Queue<String> q = new PriorityQueue<>();

        LinkedList<String> ll = new LinkedList<>();

        ll.addFirst("C");
        ll.addFirst("B");
        ll.addFirst("A");

        ll.addLast("D");
        ll.addLast("E");
        ll.addLast("F");
        ll.add(3,"PAUSE");
        System.out.println(ll);
    }
    @Override
    public void dowork() {
        testMap();
    }

}
