package threads;

import global.Workable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreadsTest2 implements Workable {


    static class Worker implements Runnable {
        private ArrayList<String> satz;
        private static Object semaphore = new Object(); // Eine Ampel (Dijkstra)

        private static Semaphore s2 = new Semaphore(1);

        public Worker(String... text) {
            satz = new ArrayList<>(List.of(text));
        }

        @Override
        public void run() {
            // Kritischer Abschnitt
            // s2.acquire();
            // StringBuffer
            // StringBuilder
            synchronized(semaphore) {
                for (String wort : satz) {
                    System.out.print(wort + " ");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        System.out.println("INTERRUPTED");
                    }
                }
            }
            //
            // s2.leave();
        }
    }

    @Override
    public void dowork() {
        Thread t1 = new Thread(new Worker("Java", "ist", "eine", "Insel"));
        Thread t2 = new Thread(new Worker("Java", "ist", "auch", "eine", "Insel"));
        Thread t3 = new Thread(new Worker("Ich", "liebe", "Cobol"));
        Thread t4 = new Thread(new Worker("Cobol", "ist", "viel", "besser", "als", "Java"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
