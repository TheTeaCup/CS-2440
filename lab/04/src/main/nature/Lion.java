package nature;

/**
 * Lion class extends Feline class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Lion extends Feline 
{
    /**
     * Lion.
     * @param name string
     */
    public Lion(String name)
    {
        super(name);
    }

    /**
     * eat.
     * subtracts hungerLevel by 2.
     * prints out a line.
     */
    public void eat()
    {
        this.hungerLevel = this.hungerLevel - 2;
        System.out.println("rip with teeth ...");
    }

    /**
     * makeNoise.
     * prints out a string.
     */
    public void makeNoise()
    {
        System.out.println("roar ...");
    }
}
