package oopgrundlagen;


public class Kreis extends Form{
    private double radius;
    public Kreis() {
        // super(1,"rot"); // Verkettung mit Form(id,farbe)
        this(1,"rot",3.0); // Verkettung mit Kreis(id,farbe,radius)
    }
    public Kreis(int id, String farbe, double radius) {
        super(id, farbe);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getUmfang() {
        return 2*Math.PI*radius;
    }
    @Override
    public double getFläche() {
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Kreis{");
        sb.append("id=").append(getId()).
           append("farbe=").append(getFarbe());
        sb.append("radius=").append(radius);
        sb.append("umfang=").append(getUmfang());
        sb.append("fläche=").append(getFläche());
        sb.append('}');
        return sb.toString();
    }
}
