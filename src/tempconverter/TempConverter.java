package tempconverter;

import java.util.Scanner;


public class TempConverter {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter celcius: ");
        double temp = myScanner.nextDouble();
        System.out.println(toF(temp));

        System.out.println("Enter F: ");
        double temp2 = myScanner.nextDouble();
        System.out.println(toC(temp2));
    }

    public static double toF(double a) {
        return ((a * 1.8) + 32);
    }

    public static double toC(double a) {
        return ((a - 32)/1.8);
    }
}
