package algorithms;

import java.util.Random;

/**
 * BigOh Class.
 * takes algorithms and runs.
 * @author Hunter Wilson
 * @version 02/01/2024
 */
public class BigOh 
{
    private static final double MILLISECONDS_PER_SECOND = 1000.0;
    private static final int NUM_TRIALS = 5;
    private Random rand;

    /**
     * BigOh no constructor.
     */
    public BigOh() 
    {
      /* no clue what i was supposed to put here... */  
    }

    /**
     * BigOh takes in a Random and assigns it.
     * 
     * @param rand A random number generator.
     */
    public BigOh(Random rand) 
    {
        this.rand = rand;
    }

    /**
     * runAlgorithm.
     * @param choice A int containing the algorithm to run.
     * @param numElements int of elements.
     * @return algorithm result
     */
    public int runAlgorithm(int choice, int numElements) 
    {
        int result = -1;
        
        switch (choice)
        {
            case 1:
                result = MysteryAlgorithms.alg1(numElements,  this.rand);
                break;

            case 2:
                result = MysteryAlgorithms.alg2(numElements, this.rand);
                break;

            case 3:
                result = MysteryAlgorithms.alg3(numElements, this.rand);
                break;

            case 4:
                result = MysteryAlgorithms.alg4(numElements, this.rand);
                break;

            case 5:
                result = MysteryAlgorithms.alg5(numElements, this.rand);
                break;

            case 6:
                result = MysteryAlgorithms.alg6(numElements, this.rand);
                break;

            default:
                break;
        }

        return result;
    }

   /** 
    * bigOhFunc.
    * @param choice algorithm choice
    * @param n a double
    * @return the bigOh
    */
    public double bigOhFunc(int choice, double n) 
    {
        double result = 0.0;

        switch (choice) 
        {
            case 1:
                result = Math.pow(n, 1);
                break;

            case 2:
                result = Math.pow(n, 3);
                break;

            case 3:
                result = Math.pow(n, 2);
                break;

            case 4:
                result = Math.pow(n, 2);
                break;

            case 5:
                result = Math.pow(n, 5);
                break;

            case 6:
                result = Math.pow(n, 4);
                break;
        
            default:
                break;
        }

        return result;
    }

    /**
     * timeAlgorithm.
     * @param choice int with the algorithm choice
     * @param n int for the 
     * @return time spent
     */
    public double timeAlgorithm(int choice, int n) 
    {
        System.gc();

        long start = System.currentTimeMillis();
    
        runAlgorithm(choice, n);
    
        long end = System.currentTimeMillis();
    
        return (end - start) / MILLISECONDS_PER_SECOND;
    }

    /**
     * robustTimeAlgorithm.
     * @param choice int with the algorithm choice
     * @param n int for the 
     * @return give the smallest time
     */
    public double robustTimeAlgorithm(int choice, int n) 
    {
        double smallestTime = Double.MAX_VALUE;
        
        for (int i = 0; i < NUM_TRIALS; i++) 
        {
            double time = timeAlgorithm(choice, n);
        
            smallestTime = Math.min(smallestTime, time);
        }
        
        return smallestTime;
    }

    /**
     * 
     * @param choice int with the algorithm choice.
     * @param n1 int
     * @param t1 time
     * @param n2 int 
     * @return estimated time
     */
    public double estimateTiming(int choice, int n1, double t1, int n2) 
    {
        double expectedTimeRatio = 
            bigOhFunc(choice, n2) / bigOhFunc(choice, n1);
        double estimatedTime = t1 * expectedTimeRatio;

        return estimatedTime;
    }

    /**
     * percentError.
     * @param correct double
     * @param estimate double 
     * @return percent error
     */
    public double percentError(double correct, double estimate)
    {
        return ((estimate - correct) / correct) * 1.0;
    }

    /**
     * computePercentError.
     * @param choice int
     * @param n1 int
     * @param n2 int
     * @return percent error
     */
    public double computePercentError(int choice, int n1, int n2) 
    {
        double time1 = robustTimeAlgorithm(choice, n1);
        double estimatedTime = estimateTiming(choice, n1, time1, n2);
        double actualTime = robustTimeAlgorithm(choice, n2);
        double error = percentError(actualTime, estimatedTime);

        return error;
    }
}
