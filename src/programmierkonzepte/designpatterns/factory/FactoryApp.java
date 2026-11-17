package programmierkonzepte.designpatterns.factory;

import global.Workable;

public class FactoryApp implements Workable {

    public void dowork() {
        Fabrik f;

        //f = new AudiFabrik();
        f = new VolkswagenFabrik();

        Auto a1 = f.createAuto("Kombi", "Oberklasse");
        Auto a2 = f.createAuto("Sportwagen","Normalklasse");
        System.out.println(a1);
        System.out.println(a2);

    }
}
