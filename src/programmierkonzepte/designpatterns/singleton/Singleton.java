package programmierkonzepte.designpatterns.singleton;

public class Singleton {

    // Konstruktor ist PRIVAT!!!
    private Singleton() {
        name = "LEO";
    }

    // Singleton Objekt speichern
    private static Singleton instance = null;

    public static /*synchronized*/ Singleton getInstance() {
        // Beim ersten Aufruf Objekt erzeugen
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    //
    private String name;

    public String getName() {
        return name;
    }
    // Build
    public Singleton setName(String name) {
        this.name = name;
        return this;
    }

    public Singleton setAlter(int alter) {
        return this;
    }

}
