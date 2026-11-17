package db;

public class Wetterdaten {

    private Integer yyyy;
    private Integer mm;
    private Double sun;  // null
    private Double rain;
    private Double tmin;
    private Double tmax;
    private Integer af;

    public Wetterdaten() {
        this(null,null,null,null,null,null,null);
    }

    public Wetterdaten(Integer yyyy, Integer mm, Double sun, Double rain, Double tmin, Double tmax, Integer af) {
        this.yyyy = yyyy;
        this.mm = mm;
        this.sun = sun;
        this.rain = rain;
        this.tmin = tmin;
        this.tmax = tmax;
        this.af = af;
    }

    public Integer getYyyy() {
        return yyyy;
    }

    public Wetterdaten setYyyy(Integer yyyy) {
        this.yyyy = yyyy;
        return this;
    }

    public Integer getMm() {
        return mm;
    }

    public Wetterdaten setMm(Integer mm) {
        this.mm = mm;
        return this;
    }

    public Double getSun() {
        return sun;
    }

    public Wetterdaten setSun(Double sun) {
        this.sun = sun;
        return this;
    }

    public Double getRain() {
        return rain;
    }

    public Wetterdaten setRain(Double rain) {
        this.rain = rain;
        return this;
    }

    public Double getTmin() {
        return tmin;
    }

    public Wetterdaten setTmin(Double tmin) {
        this.tmin = tmin;
        return this;
    }

    public Double getTmax() {
        return tmax;
    }

    public Wetterdaten setTmax(Double tmax) {
        this.tmax = tmax;
        return this;
    }

    public Integer getAf() {
        return af;
    }

    public Wetterdaten setAf(Integer af) {
        this.af = af;
        return this;
    }

    public String toString() {
        return String.format("| %d | %d | %6.2f | %6.2f | %6.2f | %6.2f | %6d |",
                yyyy,mm,tmin,tmax,rain,sun, af);
    }
    public String toCSV() {
        return String.format("%d;%d;%.2f;%.2f;%.2f;%.2f;%d",
                yyyy,mm,tmin,tmax,rain,sun, af);
    }
    public static Wetterdaten fromCSV(String csv) {
        String felder[] = csv.split(";");
        Wetterdaten wd = new Wetterdaten();
        if(felder.length == 7) {
            try {
                // yyyy,mm,tmin,tmax,rain,sun, af
                wd.setYyyy(Integer.parseInt(felder[0]));
                wd.setMm(Integer.parseInt(felder[1]));
                wd.setTmin(Double.parseDouble(felder[2]));
                wd.setTmax(Double.parseDouble(felder[3]));
                wd.setRain(Double.parseDouble(felder[4]));
                wd.setSun(Double.parseDouble(felder[5]));
                wd.setAf(Integer.parseInt(felder[6]));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return wd;
    }

}
