package nature;

/**
 * Dog class that extends the Canine class.
 * Implements the Pet interface.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Dog extends Canine implements Pet
{
    /**
     * Dog.
     * @param name string
     */
    public Dog(String name)
    {
        super(name);
    }

    /**
     * eat.
     * subtracts 3 from hungerLevel.
     * prints out a string.
     */
    public void eat()
    {
        this.hungerLevel = this.hungerLevel - 3;
        System.out.println("slop ...");
    }

    /**
     * makeNoise.
     * prints out a string.
     */
    public void makeNoise()
    {
        System.out.println("bark ...");
    }

    /**
     * beFriendly.
     * prints out a string.
     */
    public void beFriendly()
    {
        System.out.println("nuzzles ...");
    }

    /**
     * play.
     * prints out a string.
     */
    public void play()
    {
        System.out.println("runs ...");
    }
}
