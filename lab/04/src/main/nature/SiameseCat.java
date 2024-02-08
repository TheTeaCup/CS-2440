package nature;

/**
 * SiameseCat extends HouseCat class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class SiameseCat extends HouseCat
{
    /**
     * SiameseCat.
     * @param name string
     */
    public SiameseCat(String name)
    {
        super(name);
    }

    /**
     * makeNoise.
     * prints out a string
     */
    public void makeNoise()
    {
        System.out.println("mrrooowwww ...");
    }

    /**
     * play.
     * prints out a string
     */
    public void play()
    {
        System.out.println("zoom zoom zoom ...");
    }
}
