package global;

import algodat.enums.Enums;
import algodat.framework.CollectionFramework;
import algodat.generics.MyArrayListTest;
import algodat.iteratoren.Iteratoren;
import db.JDBCTest;
import gui.designerbsp.DesignerBsp;
import gui.firstframe.FirstFrame;
import gui.wettermanager.Wettermanager;
import programmierkonzepte.designpatterns.factory.FactoryApp;
import programmierkonzepte.designpatterns.factorymethod.PersonApp;
import programmierkonzepte.reflections.Reflections;
import threads.ThreadsTest;
import threads.ThreadsTest2;
import uebungen.todo.ToDoTest;

import java.util.ArrayList;

public class Main {


    static void main() {

        ArrayList<Workable> worker = new ArrayList<>();
        //  worker.add(new Grundlagen());
        // worker.add(new Konzepte());
        // worker.add(new Garbage());
        // worker.add(new Staticimports());
        //worker.add(new Records());
        //worker.add(new Lambdas());
        //worker.add(new ArtikelVerwaltung());
        // worker.add(new FactoryApp());
       // worker.add(new PersonApp());
        // worker.add(new Reflections());
        //worker.add(new Enums());
       // worker.add(new Iteratoren());
//        worker.add(new MyArrayListTest());
//        worker.add(new CollectionFramework());
         // worker.add(new JDBCTest());
        // worker.add(new ToDoTest());
        // worker.add(new FirstFrame());
       // worker.add(new DesignerBsp());
      // worker.add(new Wettermanager());
      // worker.add(new ThreadsTest());
        worker.add(new ThreadsTest2());
        for (Workable w : worker) {
            w.dowork();
        }

    }

}
