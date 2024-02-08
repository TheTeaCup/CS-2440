package nature;

/**
 * HouseCat extends the Feline class.
 * Implements the Pet class.
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class HouseCat extends Feline implements Pet
{
    /**
     * HouseCat.
     * @param name string
     */
    public HouseCat(String name)
    {
        super(name);
    }

    /**
     * eat.
     * subtracts hungerLevel by 3.
     * prints out a string.
     */
    public void eat()
    {
        this.hungerLevel = this.hungerLevel - 3;
        System.out.println("crunch crunch ...");
    }

    /**
     * beFriendly.
     * prints out a string.
     */
    public void beFriendly()
    {
        System.out.println("purr ...");
    }

    /**
     * play.
     * prints out a string.
     */
    public void play()
    {
        System.out.println("frolic ...");
    }
}
