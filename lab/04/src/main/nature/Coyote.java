package nature;

/**
 * Coyote class that extends the Canine Class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Coyote extends Canine
{
    /**
     * Coyote.
     * @param name string
     */
    public Coyote(String name)
    {
        super(name);
    }

    /**
     * eat.
     * subtracts two from hungerLevel.
     * prints out a string.
     */
    public void eat()
    {
        this.hungerLevel = this.hungerLevel - 2;
        System.out.println("gnaws");
    }

    /**
     * makeNoise.
     * prints out a string.
     */
    public void makeNoise()
    {
        System.out.println("howl ...");
    }
}
