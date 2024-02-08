package nature;

/**
 * Abstract Animal Class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public abstract class Animal 
{
    protected String name;
    protected int hungerLevel;

    /**
     * Animal.
     * @param name String for animal name.
     */
    public Animal(String name)
    {
        this.name = name;
    }

    /**
     * getHungerLevel.
     * @return hungerLevel (0-10)
     */
    public int getHungerLevel()
    {
        return this.hungerLevel;
    }

    /**
     * getName.
     * @return name string
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * setHungerLevel.
     * @param hungerLevel int
     */
    public void setHungerLevel(int hungerLevel)
    {
        if (hungerLevel < 0) 
        {
            this.hungerLevel = 0;
        } 
        else if (hungerLevel > 10)
        {
            this.hungerLevel = 10;
        }
        else 
        {
            this.hungerLevel = hungerLevel;
        }
    }

    /**
     * setName.
     * @param name string
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * sleep.
     * sets hungerLevel to 10.
     * also prints out a string.
     */
    public void sleep()
    {
        this.hungerLevel = 10;
        System.out.println("sleeping ...");
    }

    /**
     * roam.
     * increases hungerLevel by 1.
     * prints out a string.
     */
    public void roam()
    {
        this.hungerLevel++;
        System.out.println("moving around ...");
    }

    /**
     * abstract eat.
     */
    public abstract void eat();

    /**
     * abstract makeNoise.
     */
    public abstract void makeNoise();
    
}
