import java.util.ArrayList;
import java.util.Random;

/**
 * Hi - Lo Guessing Game Stat Generator.
 * 
 * @author Willow Sapphire
 * @version 04/18/2024
 */
public class HiLoGame
{
    public static final int MAX_GUESSES = 100;
    public static final int START_INT = 1;
    private Random rand;
    private int numInts;
    private int numGames;
    private ArrayList<Integer> results;
    private ArrayList<Integer[]> numberPerStep;
    private ArrayList<Integer> totalPerNumber;

    /**
     * HiLogGame.
     * @param numInts int
     * this method initializes:
     * - sets the rand of the class to a new Random generator.
     * - sets the results of the class to a new ArrayList of Integers with the max capacity of MAX_GUESSES.
     * - sets numberPerStep of the class to a new ArrayList of Integers.
     * - sets totalPerNumber of the class to a new ArrayList of Integers.
     * - calls setNumInts with the numInts provided
     */
    public HiLoGame(int numInts)
    {
        this.rand = new Random(); // initialized  rand to a new Random constructor.
        setNumInts(numInts); // passes the numInts to setNumInts.
        this.results = new ArrayList<Integer>(MAX_GUESSES); // initializes results to an ArrayList of Integers with the capacity of MAX_GUESSES (being 100).
        this.numberPerStep = new ArrayList<Integer[]>(); // initializes numberPerStep to an ArrayList of Integers with the defeault capacity (10).
        this.totalPerNumber = new ArrayList<Integer>(); // initializes totalPerNumber to an ArrayList of Integers with the default capacity (10).
    }

    /**
     * setNumInts.
     * @param numInts int
     * @throws IllegalArgumentException if Number of ints is not posititve.
     * sets the numInts of the class to the numInts specified
     */
    public void setNumInts(int numInts)
    {
        if (numInts <= 0)
        {
            throw new IllegalArgumentException("Number of ints must be positive");
        }
        this.numInts = numInts;
    }

    /**
     * setRandomGenerator.
     * @param rand Random
     * @throws IllegalArgumentException if rand (passed from the method header) is null
     * sets the random generator of the class to the rand that is specified.
     */
    public void setRandomGenerator(Random rand)
    {
        if (rand == null)
        {
            throw new IllegalArgumentException("Random number generator may not be null");
        }
        this.rand = rand;
    }

    /**
     * getNumInts.
     * @return numInts int
     */
    public int getNumInts()
    {
        return this.numInts;
    }

    /**
     * getResults.
     * @return results ArrayList of Integers
     */
    public ArrayList<Integer> getResults()
    {
        return this.results;
    }

    /**
     * playGame.
     * @return a int
     * this method starts out by filling in the numberPerStep and totalPerNumber Arrays if they are empty.
     * then it does a do-while loop then sets guess to either smaller or bigger
     * then another do-while loop looks at the nextNumber and currNumber and if they are the same number then it updates next number to a random int.
     * after that the ...
     */
    public int playGame()
    {
        boolean guessedRight = true;
        int currNumber = rand.nextInt(numInts) + START_INT;
        int nextNumber = 0;
        int numCount = 0;
        String guess = "";
        if (this.numberPerStep.isEmpty())
        {
            // if numberPerStep is empty then we add a new Intger[] with the value of numInts + START_INT
            // ex: [1, 2, 3]
            this.numberPerStep.add(new Integer[numInts + START_INT]);
            for (int i = 0; i < 10; i++) // looping 10x
            {
                this.numberPerStep.get(numCount)[i] = 0; // sets the value at index i of numberPerStep[] to 0
            }
        }
        if (this.totalPerNumber.isEmpty())
        {
            // if totalPerNumber is empty then add a 0
            // would look like: [0]
            this.totalPerNumber.add(0);
        }
        do // do-while true (guessedRight)
        {
            // guess is either "smaller" or "bigger"
            // guess's value is based on if the currNumber is greater than START_INT + (numInts / 2)
            // if currNumber is greater than it is smaller otherwise its "bigger"
            guess = (currNumber > START_INT + (numInts / 2)) ? "smaller" : "bigger";

            do // do-while "nextNumber" == "currNumber"
            {
                // set nextNumber to a new int from the random number generator
                nextNumber = this.rand.nextInt(numInts) + START_INT;
            } while(nextNumber == currNumber);

            this.numberPerStep.get(numCount)[currNumber]++; // incrementing the value of currNumber in the integer array retrieved from numberPerStep at index numCount
            this.totalPerNumber.set(numCount, this.totalPerNumber.get(numCount) + 1); // this sets the value of numCount in totalPerNumber to the current value of numCount plus 1

            if (((nextNumber > currNumber) && (guess == "smaller"))
                || ((nextNumber < currNumber) && (guess == "bigger")))
            {
                // if nextNumber is greater than currNumber and guess is "smaller"
                // if nextNumber is less than currNumber and guess is "bigger"
                // then guessedRight is set to false and the loop stops 
                guessedRight = false;
            }
            else
            {
                // increment numCount by 1
                numCount++;
                if (numCount == this.numberPerStep.size()) // if numCount == numberPerStep.size then do the following:
                {
                    this.numberPerStep.add(new Integer[numInts + START_INT]); // add [numInts + START_INT] to numberPerStep
                    for (int i = 0; i < numInts + START_INT; i++) // loop for numInts + START_INT
                    {
                        this.numberPerStep.get(numCount)[i] = 0; // sets the value at index i of the Integer array at index numCount in numberPerStep to 0
                    }
                }
                if (numCount == this.totalPerNumber.size()) // if numCount == totalPerNumber.size
                {
                    this.totalPerNumber.add(0); // add a 0 to totalPerNumber
                }
                currNumber = nextNumber; // set currNumber to nextNumber
              }
          } while(guessedRight); // while guessRight = true
        return numCount; // return the int starts at 0
    }

    /**
     * playGames.
     * @param numGames
     */
    public void playGames(int numGames)
    {
        this.numGames = numGames; // sets the numGames of the class to the numsGame argument.
        // this loop is filling in the array "results" with 0s.
        // if you did not do this then it would return a IndexOutOfBoundsException,
        // when you try to set the results below.
        for(int i = 0; i < MAX_GUESSES; i++) // for loop runs "MAX_GUESSES" times (100)
        {
            this.results.add(0); // adding a new "result" with 0 as the data.
        }
        // this loop will run whatever int argument is specified during the call above.
        // inside of the loop it will call playGame and will get the data returned 
        // for count it gets the index from results using the response from result (playGame)
        // then it sets results to the [result, count]
        for(int i = 0; i < numGames; i++)
        {
            int result = this.playGame();
            int count = this.results.get(result) + 1;
            this.results.set(result, count);
        }
    }

    /**
     * printResults.
     */
    public void printResults()
    {
        int totalCheck = 0;
        double average = 0.0;
        double lineAverage = 0.0;
        double prevAverage = -1;
        System.out.printf("%4s%-25s%-25s%-25s%-25s\n", "", "Correct Guesses",
            "Percent Chance", "Dropoff Ratio", "Dropoff Percent");
        for(int i = 0; i < this.results.size(); i++)
        {
            int result = this.results.get(i);
            if (result != 0)
            {
                lineAverage = (double) result / this.numGames * 100;
                if (i == 0)
                {
                    System.out.printf("%-4d%15d%23f%%\n", i, result, lineAverage);
                }
                else
                {
                    System.out.printf("%-4d%15d%23f%%%24f%26f%%\n", i, result, lineAverage,
                        lineAverage/prevAverage, (-1 * (100 - (lineAverage / prevAverage) * 100)));
                }
                prevAverage = lineAverage;
            }
            average += (result * i);
            totalCheck += result;
        }
        average /= numGames;
        System.out.printf("%-8s%10f\n", "Average:", average);
        System.out.printf("%-8s%10d\n", "Total:", totalCheck);
    }

    /**
     * printNumbersPerStep.
     */
    public void printNumbersPerStep()
    {
        for (int i = 0; i < this.numberPerStep.size(); i++)
        {
            System.out.printf("%10s%3s", getFormattedNum(i + 1), "");
            for (int j = 1; j < this.numberPerStep.get(i).length; j++)
            {
                String result = String.format("%d's: %" + getMaxNumStepsDigits(j)
                    + "d, ", j, this.numberPerStep.get(i)[j]);
                System.out.printf("%-12s", result);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * printRatiosPerStep.
     */
    public void printRatiosPerStep()
    {
        // loop through the length of numberPerStep
        for (int i = 0; i < this.numberPerStep.size(); i++)
        {
            // print the formatted step number
            System.out.printf("%10s%3s", getFormattedNum(i + 1), "");
            // loop through each digit in the current step
            for (int j = 1; (j < this.numberPerStep.get(i).length); j++)
            {
                // calculate the percent using the numberPerStep
                double percent = ((((double) this.numberPerStep.get(i)[j])
                    / (this.totalPerNumber.get(i)) * 100));
                // format the digit count and percent
                String digit = String.format("%d's:  ", j);
                String digitPercent = String.format("%3.1f%%", percent);
                // pring out the formatted strings
                System.out.printf("%-2s%6s, ", digit, digitPercent);
            }
            // print the total count
            System.out.print("Total: " + this.totalPerNumber.get(i));
            System.out.println();
        }
        System.out.println();
    }

    /**
     * getFormattedNum.
     * @param num int
     * @return formatted string
     * this method generates a formatted string
     */
    private String getFormattedNum(int num)
    {
        if (num % 100 == 11 || num % 100 == 12 || num % 100 == 13) // check if the number modulo 100 is equal to 11, 12, or 13
            return num + "th num: ";
        // check if the number modulo 10 is 1
        else if (num % 10 == 1) return num + "st num: ";
        // check if the number modulo 10 is 2
        else if (num % 10 == 2) return num + "nd num: ";
        // check if the number modulo 10 is 3
        else if (num % 10 == 3) return num + "rd num: ";
        // for all others, use "th"
        else return num + "th num: ";
    }

    /**
     * getMaxNumStepsDigits.
     * @param index int
     * @return maxDigits, maximum number of digits among the elements at the specified index.
     */
    private int getMaxNumStepsDigits(int index)
    {
        int maxDigits = Integer.MIN_VALUE; // initialize maxDigits to the minimum possible integer value
        for (Integer[] a : numberPerStep) // loop through each Integer array in numberPerStep
        {
            int digits = (a[index] + "").length(); // convert to a string and get the length
            if (digits > maxDigits) maxDigits = digits; // set maxDigits if the current digits count is greater
        }
        return maxDigits;
    }

    /**
     * main method.
     * @param args array of strings.
     * 
     */
    public static void main(String[] args)
    {
        int numGames            = (args.length >= 1) ? Integer.parseInt(args[0]) : 1000000;
        boolean printRatios     = (args.length >= 2) ? (args[1].equals("true")) : false;
        boolean printNumPerStep = (args.length >= 3) ? (args[2].equals("true")) : false;
        int numInts             = (args.length >= 4) ? Integer.parseInt(args[3]) : 9; // was originally args[4] but that doesn't work lol changed to args[3].
        HiLoGame game = new HiLoGame(numInts);
        game.playGames(numGames);
        game.printResults();
        if(printNumPerStep)
        {
            game.printNumbersPerStep();
        }
        if(printRatios)
        {
            game.printRatiosPerStep();
        }
    }
}
