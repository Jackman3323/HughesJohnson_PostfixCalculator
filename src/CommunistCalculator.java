import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * CommunistCalculator.java
 *
 * This file is the main class file. Its purpose is to engage in communist math with ridiculously archaic notation that
 * has no net benefit to its usage other than infuriating the user. Very epico. It does this with a lot of helper methods
 * and a fancy algorithm that Henry thought of. Everything else is explained in context.
 *
 * Authors: Jack Hughes, Henry Johnson
 *
 * Date of Creation:11-15-20
 */
public class CommunistCalculator {
    //INSTANCE-DATA
    //Keeps track of total as steps progress
    private double runningTotal;
    //All the junk that the commies inputted in the driver
    private String communistPotatoes;
    //Stack object to stack da potatoes
    private Stack<String> operatorPotatoes;
    private Stack<String> numPotatoes;
    private Stack<String> operatorPotatoesFlipped;
    private Stack<String> numPotatoesFlipped;
    private int index = 0;
    private int numBushelSize = 0;
    private String out;
    private final String filePath;

    //CONSTRUCTORS
    //Empty Constructor
    public CommunistCalculator(String fileName) {
        runningTotal = 0;
        communistPotatoes = "";
        operatorPotatoes = new Stack<String>();
        numPotatoes = new Stack<String>();
        operatorPotatoesFlipped = new Stack<String>();
        numPotatoesFlipped = new Stack<String>();
        out = "";
        this.filePath = (new File(".").getAbsolutePath() + fileName).replaceFirst("\\.","");
    }

    //METHODS
    //public double doTheMath(String americanFrenchFries): input american math as a String, output the resultant double
    private double doTheMath(String americanFrenchFries) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Double dumb = (Double) engine.eval(americanFrenchFries);
        BigDecimal bd = new BigDecimal(Double.toString(dumb));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    //private double math(String communistPotatoes): input ur commie garbage and get a number eventually
    private double math(String communistPotatoes) {
        //incase some absolute maniac liked this so much they wanted to use it
        //more than once instead of burning it after verifying its functionality, never to look at it
        //ever, ever, EVERRRRRR, again.
        this.communistPotatoes = communistPotatoes;
        out = new String("");
        out += firstPotato();

        do {
            makeBushels();
            do {
                if (!operatorPotatoesFlipped.isEmpty()) {
                    out += operatorPotatoesFlipped.pop();

                }
                if (!numPotatoesFlipped.isEmpty()) {
                    out += "(";
                    out += numPotatoesFlipped.pop();
                }
            } while (!numPotatoesFlipped.isEmpty());
            for (int i = 0; i < numBushelSize; i++) {
                out += ")";
            }
        } while (index < communistPotatoes.length());
        //**IMPORTANT** you must convert the string made here into a double
        //MATH STARTS HERE
        double toReturn = 0.0;
        try {
            toReturn = doTheMath(out + "+ 0.0"); //You don't wanna know...
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
    //private boolean isOperator(char potato): returns true if the char is one of the accepted operators
    private boolean isOperator(char potato) {
        return potato == '+' || potato == '-' || potato == '*' || potato == '/';
    }
    //private double harvestPotato(String communistPotatoes): selects the next potato to harvest
    //based on commie order of operations
    private String harvestPotato(String communistPotatoes) {
        String nextPotato = "";

        return nextPotato;
    }
    //private String firstPotato(): gets the first potato
    private String firstPotato() {
        String onePotato;
        boolean isOnFristTater = true;
        //this do while loop is 1. awsome cuz its a do while loop(screw you druhv)
        //2. adds all of the nubers to the stack(probably)
        onePotato = "";
        do {
            if (communistPotatoes.charAt(index) >= '0' && communistPotatoes.charAt(index) <= '9') {
                onePotato += communistPotatoes.charAt(index);
                index++;
            } else if (communistPotatoes.charAt(index) == ' ') {
                isOnFristTater = false;
                index++;
            }
        } while (isOnFristTater);

        return onePotato;
    }
    //return boolean value whether or not input is a number
    private boolean isNumber(char input){
        boolean toReturn;
        switch(input){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '.': //Must include decimal
                toReturn = true;
                break;
            default:
                toReturn = false;
                break;
        }
        return toReturn;
    }
    //when we run this, we have to make sure that n< communistPotatos.length
    private void makeBushels() {
        boolean onNumbers;
        boolean onOperators;
        //this for loop is useless, delete it
        onNumbers = true;
        onOperators = false;
        String onePotato;
        //this is how many numbers are in one bushel
        //it helps to find how many closing parenthasese need to be added
        numBushelSize = 0;
        //this do while loop is 1. awsome cuz its a do while loop(screw you druhv)
        //2. adds all of the nubers to the stack(probably)
        onePotato = "";
        do {
            if (isNumber(communistPotatoes.charAt(index))) {
                onePotato += communistPotatoes.charAt(index);
                index++;
            } else if (communistPotatoes.charAt(index) == ' ') {
                numPotatoes.push(onePotato);
                onePotato = "";
                numBushelSize++;
                index++;
            } else {
                onePotato = "";
                onNumbers = false;
                onOperators = true;
            }
        } while (onNumbers && index < communistPotatoes.length());
        do {
            if (isOperator(communistPotatoes.charAt(index))) {
                onePotato += communistPotatoes.charAt(index);
                if(index == communistPotatoes.length()-1){
                    operatorPotatoes.push(onePotato);
                    onePotato = "";
                }
                index++;
            } else if (communistPotatoes.charAt(index) == ' ') {
                operatorPotatoes.push(onePotato);
                onePotato = "";
                index++;
            } else {
                onOperators = false;
                onePotato = "";
            }

        } while (onOperators && index < communistPotatoes.length());
        //flips the stacks so that the data can be pulled out in the correct order later
        while (!operatorPotatoes.isEmpty()) {
            operatorPotatoesFlipped.push(operatorPotatoes.pop());
        }
        while (!numPotatoes.isEmpty()) {
            numPotatoesFlipped.push(numPotatoes.pop());
        }
    }
    //public double[] evaluate(): the only public method; evaluates all lines in the given .txt file and
    // returns an array of doubles that are the results of each row
    public double[] evaluate(){
        String file = "";

        try {
            file = new String(Files.readAllBytes(Paths.get(this.filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        file = file.replace("\n","#");
        String curExpression = "";
        int startExpression = 0;
        int endExpression = 0;
        ArrayList<Double>resultArr = new ArrayList<Double>();
        for(int i = 0; i < file.length(); i++){
            if(file.charAt(i) == '#'){
                //Deliminator char encountered! must cut out this expression and evaluate it and store the result
                endExpression = i;
                curExpression = file.substring(startExpression,endExpression);
                this.index = 0;
                resultArr.add(this.math(curExpression));
                //reset start index to the char after the deliminator char
                startExpression = i + 1;
            }
            else if(i == file.length() -1){
                //Last char in file, set this as the end of the currrent expression and evaluate it while storing the result
                curExpression = file.substring(startExpression);
                this.index = 0;
                resultArr.add(this.math(curExpression));
            }
        }
        double[] returnable = new double[resultArr.size()];
        for(int i = 0; i < resultArr.size(); i++){
            returnable[i] = resultArr.get(i);
        }
        return returnable;
    }
}
