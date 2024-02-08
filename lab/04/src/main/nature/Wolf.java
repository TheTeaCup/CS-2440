package nature;

/**
 * Wolf extends Canine class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Wolf extends Canine
{
    /**
     * Wolf.
     * @param name string
     */
    public Wolf(String name)
    {
        super(name);
    }

    /**
     * eat.
     * subtracts hungerLevel by 2.
     * prints out a string.
     */
    public void eat()
    {
        this.hungerLevel = this.hungerLevel - 2;
        System.out.println("rip with teeth ...");
    }

    /**
     * makeNoise.
     * prints out a stringv
     */
    public void makeNoise()
    {
        System.out.println("growl ...");
    }
}
