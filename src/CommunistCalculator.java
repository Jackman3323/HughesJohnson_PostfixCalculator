public class CommunistCalculator {
    //INSTANCE-DATA
    //Keeps track of total as steps progress
    private double runningTotal;
    //All the junk that the commies inputted in the driver
    private String communistPotatoes;
    //Stack object to stack da potatoes
    private Stack<Character> operatorPotatoes;
    private Stack<Double> numPotatoes;

    //CONSTRUCTORS
    //Empty Constructor
    public CommunistCalculator(){
        runningTotal = 0;
        communistPotatoes = "";
        operatorPotatoes = new Stack<Character>();
        numPotatoes = new Stack<Double>();
    }

    //METHODS
    //public double math(String communistPotatoes): input ur commie garbage and get a number eventually
    //it's the only public method besides the constructor
    public double math(String communistPotatoes){
        this.runningTotal = 0; //in case some absolute maniac liked this so much they wanted to use it
        //more than once instead of burning it after verifying its functionality, never to look at it
        //ever, ever, EVERRRRRR, again.
        return runningTotal;
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

    //private String removeSpaces(String communistPotatoes): returns the same string just without spaces
    private String removeSpaces(String communistPotatoes){
        return communistPotatoes.replaceAll("\\s","");
    }

    //private String sortPotatoes(String communistPotatoes): sorts the potatoes into numbers then operators
    private String sortPotatoes(String communistPotatoes){
        this.communistPotatoes = this.removeSpaces(communistPotatoes);
        int ancestor = 0;
        boolean state = true; //True is a num segment, false is an operator segment
        for(int i = 0; i < this.communistPotatoes.length(); i++){
            if(state && this.communistPotatoes.charAt())
        }

    }

    //private double harvestPotato(String communistPotatoes): selects the next potato to harvest
    //based on commie order of operations
    private String harvestPotato(String communistPotatoes){
        String nextPotato = "";

        return nextPotato;
    }

}
