package oopgrundlagen;
// Basisklasse aller graphischen Formen (2D)
// Kreis, Rechteck, ...
public abstract class Form {

//    public double getUmfang()
//    {
//        return 0;
//    }
    private int id;
    private String farbe;

    public Form(int id, String farbe) {
        this.id = id; // setId(id);
        this.farbe = farbe;
    }

    public abstract double getUmfang();
    public abstract double getFläche();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        if(id > 0) {
            this.id = id;
        } else {
            this.id = 0;
        }
    }
    public String getFarbe() {
        return farbe;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
