package programmierkonzepte.inner;

import global.Workable;

public class Inner implements Workable {

    @Override
    public void dowork() {
        Person p = new Person();
        // oopgrundlagen.Person x;
        var x = p.getAdresse();
        System.out.println(p.getOrt());
        System.out.println(p.getAdresse().getOrt());
    }
}
