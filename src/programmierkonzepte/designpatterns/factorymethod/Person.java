package programmierkonzepte.designpatterns.factorymethod;

public class Person {

    private Person() {

    }

    // Factory-Method
    public static Person createPerson(String vn, String nn) {
        Person tmp = new Person();

        return tmp;
    }

    public static Person createPersonFromXML(String xml) {
        Person tmp = new Person();

        return tmp;
    }

    public static Person createPersonFromCSV(String csv) {
        Person tmp = new Person();

        return tmp;
    }



}
