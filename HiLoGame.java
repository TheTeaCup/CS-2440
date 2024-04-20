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

    public HiLoGame(int numInts)
    {
        this.rand = new Random();
        setNumInts(numInts);
        this.results = new ArrayList<Integer>(MAX_GUESSES);
        this.numberPerStep = new ArrayList<Integer[]>();
        this.totalPerNumber = new ArrayList<Integer>();
    }

    public void setNumInts(int numInts)
    {
        if (numInts <= 0)
        {
            throw new IllegalArgumentException("Number of ints must be positive");
        }
        this.numInts = numInts;
    }

    public void setRandomGenerator(Random rand)
    {
        if (rand == null)
        {
            throw new IllegalArgumentException("Random number generator may not be null");
        }
        this.rand = rand;
    }

    public int getNumInts()
    {
        return this.numInts;
    }

    public ArrayList<Integer> getResults()
    {
        return this.results;
    }

    public int playGame()
    {
        boolean guessedRight = true;
        int currNumber = rand.nextInt(numInts) + START_INT;
        int nextNumber = 0;
        int numCount = 0;
        String guess = "";
        if (this.numberPerStep.isEmpty())
        {
            this.numberPerStep.add(new Integer[numInts + START_INT]);
            for (int i = 0; i < 10; i++)
            {
                this.numberPerStep.get(numCount)[i] = 0;
            }
        }
        if (this.totalPerNumber.isEmpty())
        {
            this.totalPerNumber.add(0);
        }
        do
        {
            guess = (currNumber > START_INT + (numInts / 2)) ? "smaller" : "bigger";
            do
            {
                nextNumber = this.rand.nextInt(numInts) + START_INT;
            } while(nextNumber == currNumber);
            this.numberPerStep.get(numCount)[currNumber]++;
            this.totalPerNumber.set(numCount, this.totalPerNumber.get(numCount) + 1);
            if (((nextNumber > currNumber) && (guess == "smaller"))
                || ((nextNumber < currNumber) && (guess == "bigger")))
            {
                guessedRight = false;
            }
            else
            {
                numCount++;
                if (numCount == this.numberPerStep.size())
                {
                    this.numberPerStep.add(new Integer[numInts + START_INT]);
                    for (int i = 0; i < numInts + START_INT; i++)
                    {
                        this.numberPerStep.get(numCount)[i] = 0;
                    }
                }
                if (numCount == this.totalPerNumber.size())
                {
                    this.totalPerNumber.add(0);
                }
                currNumber = nextNumber;
              }
          } while(guessedRight);
        return numCount;
    }

    public void playGames(int numGames)
    {
        this.numGames = numGames;
        for(int i = 0; i < MAX_GUESSES; i++)
        {
            this.results.add(0);
        }
        for(int i = 0; i < numGames; i++)
        {
            int result = this.playGame();
            int count = this.results.get(result) + 1;
            this.results.set(result, count);
        }
    }

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

    public void printRatiosPerStep()
    {
        for (int i = 0; i < this.numberPerStep.size(); i++)
        {
            System.out.printf("%10s%3s", getFormattedNum(i + 1), "");
            for (int j = 1; (j < this.numberPerStep.get(i).length); j++)
            {
                double percent = ((((double) this.numberPerStep.get(i)[j])
                    / (this.totalPerNumber.get(i)) * 100));
                String digit = String.format("%d's:  ", j);
                String digitPercent = String.format("%3.1f%%", percent);
                System.out.printf("%-2s%6s, ", digit, digitPercent);
            }
            System.out.print("Total: " + this.totalPerNumber.get(i));
            System.out.println();
        }
        System.out.println();
    }

    private String getFormattedNum(int num)
    {
        if (num % 100 == 11 || num % 100 == 12 || num % 100 == 13)
            return num + "th num: ";
        else if (num % 10 == 1) return num + "st num: ";
        else if (num % 10 == 2) return num + "nd num: ";
        else if (num % 10 == 3) return num + "rd num: ";
        else return num + "th num: ";
    }

    private int getMaxNumStepsDigits(int index)
    {
        int maxDigits = Integer.MIN_VALUE;
        for (Integer[] a : numberPerStep)
        {
            int digits = (a[index] + "").length();
            if (digits > maxDigits) maxDigits = digits;
        }
        return maxDigits;
    }

    public static void main(String[] args)
    {
        int numGames            = (args.length >= 1) ? Integer.parseInt(args[0]) : 1000000;
        boolean printRatios     = (args.length >= 2) ? (args[1].equals("true")) : false;
        boolean printNumPerStep = (args.length >= 3) ? (args[2].equals("true")) : false;
        int numInts             = (args.length >= 4) ? Integer.parseInt(args[4]) : 9;
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
