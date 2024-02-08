package nature;

/**
 * Abstract Canine class that extends the Animal class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public abstract class Canine extends Animal 
{
    /**
     * Canine.
     * @param name string
     */
    public Canine(String name)
    {
        super(name);
    }

    /**
     * roam.
     * increases hunger level by 1.
     * prints out a string.
     */
    public void roam()
    {
        this.hungerLevel++;
        System.out.println("like canines roam in packs ...");
    }
}
