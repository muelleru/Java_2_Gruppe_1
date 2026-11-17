package programmierkonzepte.garbage;

import global.Workable;

public class Garbage implements Workable {


    @Override
    public void dowork() {

        // interface AutoCloseable implementieren

        try( DBConnect db = new DBConnect()  ) {

        // automatisches Close/Dispose
        // db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.gc(); // Garbage Collector

        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.freeMemory());
        System.out.println(rt.availableProcessors());

        // rt.gc();
    }


}
