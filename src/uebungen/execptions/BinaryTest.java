package uebungen.execptions;

import global.Workable;

public class  BinaryTest implements Workable
{


  @Override
  public void dowork() {
    try {
      System.out.println("10111011 ist " + BinaryStringToNumber.parseBinary("10111011"));
      String s = "10511011";
      System.out.println(s + " ist " + BinaryStringToNumber.parseBinary(s));
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
