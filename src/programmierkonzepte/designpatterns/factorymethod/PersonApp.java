package programmierkonzepte.designpatterns.factorymethod;

import global.Workable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//  import de.kvbw.dummy.Dummy;
import de.kvbw.helper.ConsoleHelper;

public class PersonApp implements Workable {

    public void dowork() {

        Person x = Person.createPersonFromCSV("1;Hans;Maier");
        // Error Person x2 = new Person();

        //LocalDate date = new LocalDate(); // Kein öffentlicher Konstruktor
        LocalDate date2 = LocalDate.ofYearDay(2026,200); // statische Factory-Methoden
        LocalDate date3 = LocalDate.of(2026,10,12); //

        int z = ConsoleHelper.getInstance().readInteger("Zahl");
        String s = ConsoleHelper.getInstance().readString("TEST");
        System.out.println(s);
    }

}
