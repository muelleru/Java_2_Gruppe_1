package programmierkonzepte.records;

import global.Workable;

public class Records implements Workable {

    record Bumm(int a, int b) {}

    public Person getMax() {
        return new Person(1,"Max","Mustermann");
    }

    @Override
    public void dowork() {
        Tuple<String,String,Integer> t1 = new Tuple<>("ALPHA","A",1);
        Tuple<Integer,Integer,Integer> t2 = new Tuple<>(1,2,3);
        System.out.println(t1.x() + ", " + t1.y() + ", " + t1.z());
        System.out.println(t2.x() + ", " + t2.y() + ", " + t2.z());
    }

}
