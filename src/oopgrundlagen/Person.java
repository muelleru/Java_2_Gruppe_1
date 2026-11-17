package oopgrundlagen;

public class Person {

    private int alter;

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter)
            throws AlterOutOfBoundException{
        if(alter >= 0 && alter <=120) {
            this.alter = alter;
        } else {
            throw new AlterOutOfBoundException(alter);
        }
    }

}
