package threads;

import global.Workable;

public class ThreadsTest implements Workable {


    @Override
    public void dowork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                try {
                    System.out.print("A");
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.print("INTERRUPT");
                }
            }
        });
        Thread t2 =new Thread(new Worker("B",200,30));
        Thread t3 =new Thread(new Worker("C",300,20));
        //t1.setDaemon(true);// Thread wird mit Haupt-Thread beendet
        //t2.setDaemon(true);
        //t3.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("INTERRUPTED");
        }

        System.out.println("ENDE");

    }


}
