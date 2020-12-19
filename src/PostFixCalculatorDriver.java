/**
 * CommunistCalculatorDriver.java
 *
 * This file is the driver for the main class file. Its purpose is to test all methods and functionality of the main class
 * by doing math imported by a text file. It is very straightforward.
 *
 * Authors: Jack Hughes, Henry Johnson
 *
 * Date of Creation:11-18-20
 */
public class PostFixCalculatorDriver {
    public static void main(String[] args) {
        CommunistCalculator commieCalc = new CommunistCalculator("src/postfix.txt");
        double[] results = commieCalc.evaluate();
        for(int i = 0; i < results.length; i++){
            System.out.println("RESULT: " + results[i]);
        }
    }
}
