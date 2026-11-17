package programmierkonzepte.designpatterns.singleton;

import global.Workable;

public class SingletonTest implements Workable {
    @Override
    public void dowork() {

        System.out.println(Singleton.getInstance().getName());

        System.out.println(Singleton.getInstance().setName("PIUS III").setAlter(89));

        Singleton s = Singleton.getInstance();

        //Singleton s2 = new Singleton();

    }
}
