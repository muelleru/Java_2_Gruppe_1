package threads;

public class Worker implements Runnable {

    private String text;
    private int wartezeit;
    private int anzahl;

    public Worker(String text, int anzahl, int wartezeit) {
        this.text = text;
        this.wartezeit = wartezeit;
        this.anzahl = anzahl;
    }

    @Override
    public void run() {
        for (int i = 0; i < anzahl; i++) {
            try {
                System.out.print(text);
                Thread.sleep(wartezeit);
            } catch (InterruptedException e) {
                System.out.print("INTERRUPT");
            }
        }


    }
}
