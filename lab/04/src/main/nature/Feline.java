package nature;

/**
 * Feline class extends the Animal Class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public abstract class Feline extends Animal 
{
    /**
     * Feline.
     * @param name string
     */
    public Feline(String name)
    {
        super(name);
    }

    /**
     * roam.
     * increases hungerLevel by 1.
     * prints out a string.
     */
    public void roam()
    {
        this.hungerLevel++;
        System.out.println("felines like to roam alone ...");
    }


    /**
     * sleep.
     * sets hungerLevel to 10.
     * prints out a string.
     */
    public void sleep()
    {
        this.hungerLevel = 10;
        System.out.println("taking a cat nap ...");
    }

    /**
     * makeNoise.
     * prints out a string.
     */
    public void makeNoise()
    {
        System.out.println("meow ...");  
    }

}
