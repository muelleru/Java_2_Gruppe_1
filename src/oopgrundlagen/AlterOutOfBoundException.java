package oopgrundlagen;

 public class AlterOutOfBoundException extends Exception /*RuntimeException*/ {
//   public class AlterOutOfBoundException extends RuntimeException {

    private int alter;

    public AlterOutOfBoundException(int alter) {
        super();
        this.alter = alter;
    }
    @Override
    public String getMessage() {
        return "Alter (%d) ist nicht im korrekten Bereich".formatted(alter);
    }

    public int getAlter() {
        return alter;
    }

}
