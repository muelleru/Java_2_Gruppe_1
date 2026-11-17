package algodat.iteratoren;

import global.Workable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Iteratoren implements Workable {
    public void test_listit() {
        ArrayList<Integer> liste1 = new ArrayList<>(List.of(5,10,15,6,8,1,3,12));
        ListIterator<Integer> listiterator =  liste1.listIterator();

        System.out.println(listiterator.next());
        System.out.println(listiterator.next());
        System.out.println(listiterator.next());
        System.out.println(listiterator.next());
        System.out.println(listiterator.previous());
        System.out.println(listiterator.previous());
        listiterator.add(42);

        listiterator.next();
        listiterator.next();
        listiterator.next();
        listiterator.remove();
        System.out.println(liste1);
    }

    public void test_it() {

        ArrayList<Integer> liste1 = new ArrayList<>(List.of(5,10,15,6,8,1,3,12));

        liste1.removeIf( x-> x>=10);

        Iterator<Integer> it = liste1.iterator(); // Iterable<Integer> =>
                                                  //       Iterator iterator()
                                                  // Iterator<Integer> =>
                                                  //       Integer next()
                                                  //       boolean hasNext()


        while(it.hasNext()) {
            Integer i = it.next();
            if(i >= 10) {
                liste1.remove(i); // wird den Iterator zerstören
            }
            System.out.println(i);
        }
        System.out.println("#liste: "+liste1.size());
        for(var elem : liste1) { // benutzt next(), hasNext()
            System.out.println(elem);
        }




    }

    @Override
    public void dowork() {
test_listit();
    }
}
