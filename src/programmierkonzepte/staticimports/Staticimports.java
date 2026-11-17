package programmierkonzepte.staticimports;
import global.Workable;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static java.lang.System.lineSeparator;

public class Staticimports implements Workable {
    @Override
    public void dowork() {
        double radius = 2.0;
        double umfang =  2* radius * PI;

        // System.out.println((int)lineSeparator().charAt(0));
        // System.out.println((int)lineSeparator().charAt(1));
        String newline = lineSeparator();
        for(int i = 0; i< newline.length();i++) {
            System.out.println((int)newline.charAt(i));
        }
    }
}
