package nature;

/**
 * Ocelot extends Feline class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Ocelot extends Feline
{
    /**
     * Ocelot.
     * @param name string
     */
    public Ocelot(String name)
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
        System.out.println("pick ...");
    }
}
