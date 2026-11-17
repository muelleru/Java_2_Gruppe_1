package programmierkonzepte.garbage;



public class DBConnect implements AutoCloseable {


    @Override
    public void close() throws Exception {
        System.out.println("AUFRÄUMEN");
    }
}
