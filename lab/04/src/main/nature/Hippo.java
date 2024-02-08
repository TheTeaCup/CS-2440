package nature;

/**
 * Hippo Class extends Animal Class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Hippo extends Animal
{
    /**
     * Hippo.
     * @param name string
     */
    public Hippo(String name)
    {
        super(name);
    }

    /**
     * eat.
     * subtract hungerLevel by 1.
     * prints out string.
     */
    public void eat()
    {
        this.hungerLevel--;
        System.out.println("slurp ...");
    }

    /**
     * makeNoise.
     * print out string.
     */
    public void makeNoise()
    {
        System.out.println("blub ...");
    }
}
