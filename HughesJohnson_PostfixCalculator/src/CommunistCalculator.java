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

    //CONSTRUCTORS
    //Empty Constructor
    public CommunistCalculator(){
        runningTotal = 0;
        communistPotatoes = "";
        operatorPotatoes = new Stack<String>();
        numPotatoes = new Stack<String>();
        operatorPotatoesFlipped = new Stack<String>();
        numPotatoesFlipped = new Stack<String>();
        out = "";
    }

    //METHODS
    //public double math(String communistPotatoes): input ur commie garbage and get a number eventually
    //it's the only public method besides the constructor
    public double math(String communistPotatoes){
        //incase some absolute maniac liked this so much they wanted to use it
        //more than once instead of burning it after verifying its functionality, never to look at it
        //ever, ever, EVERRRRRR, again.
        out = "";
        out+=firstPotato();

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
            }while (!numPotatoesFlipped.isEmpty());
            for(int i = 0;i<numBushelSize;i++){
                out+=")";
            }
        }while (index<communistPotatoes.length());
        //**IMPORTANT** you must convert the string made here into a double
    }
    //this will turn a string into executable math
    private double makeCommunist(String taters){

    }

    //private boolean isNum(String potato): returns true if string constitutes a number
    private boolean isNum(String potato){
        if (potato == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(potato);
        } catch (NumberFormatException noPotato) {
            return false;
        }
        return true;
    }

    //private boolean isOperator(char potato): returns true if the char is one of the accepted operators
    private boolean isOperator(char potato){
        return potato == '+' || potato == '-' || potato == '*' || potato == '/';
    }

    //private double harvestPotato(String communistPotatoes): selects the next potato to harvest
    //based on commie order of operations
    private String harvestPotato(String communistPotatoes){
        String nextPotato = "";

        return nextPotato;
    }
    private String firstPotato(){
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
            }while (isOnFristTater);
            return onePotato;
    }
    //when we run this, we have to make sure that n< communistPotatos.length
    private void makeBushels(){
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
            do{
                onePotato = "";
              if(communistPotatoes.charAt(index)>='0'&&communistPotatoes.charAt(index)<='9'){
                 onePotato+=communistPotatoes.charAt(index);
                 index++;
              }
              else if(communistPotatoes.charAt(index)==' '){
                  numPotatoes.push(onePotato);
                  numBushelSize++;
                  index++;
              }
              else{
                  onNumbers=false;
                  onOperators = true;
              }
            }while (onNumbers);
            do{
                onePotato = "";
                if(isOperator(communistPotatoes.charAt(index))){
                    onePotato+=communistPotatoes.charAt(index);
                    index++;
                }
                else if(communistPotatoes.charAt(index)==' '){
                    operatorPotatoes.push(onePotato);
                    index++;
                }
                else{
                    onOperators = false;
                }
            }while (onOperators);
            //flips the stacks so that the data can be pulled out in the correct order later
        while(!operatorPotatoes.isEmpty()){
            operatorPotatoesFlipped.push(operatorPotatoes.pop());
        }
        while(!numPotatoes.isEmpty()){
            numPotatoesFlipped.push(numPotatoes.pop());
        }
    }
}
