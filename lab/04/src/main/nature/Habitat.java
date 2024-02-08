package nature;
import java.util.ArrayList;

/**
 * Habitat Class.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Habitat 
{
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> animals;

    /**
     * Habitat.
     * @param name string
     * @param lat double
     * @param lon double
     */
    public Habitat(String name, double lat, double lon)
    {
        this.animals = new ArrayList<Animal>();
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
    }

    /**
     * getLatitude.
     * @return latitude double
     */
    public double getLatitude()
    {
        return this.latitude;
    }

    /**
     * getLongitude.
     * @return longitude double
     */
    public double getLongitude()
    {
        return this.longitude;
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
     * setLatitude.
     * @param lat double
     */
    public void setLatitude(double lat)
    {
        this.latitude = lat;
    }

    /**
     * setLongitude.
     * @param lon double
     */
    public void setLongitude(double lon)
    {
        this.longitude = lon;
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
     * getNumOfAnimals.
     * @return number int
     */
    public int getNumOfAnimals()
    {
        return animals.size();
    }

    /**
     * addAnimal.
     * @param animal Animal 
     */
    public void addAnimal(Animal animal)
    {
        animals.add(animal);
    }

    /**
     * testAnimals.
     * prints out information.
     */
    public void testAnimals()
    {
        System.out.println(this.name);
        System.out.println(this.latitude);
        System.out.println(this.longitude);
        System.out.println(this.animals.size());
        
        for (Animal animal : animals)
        {
            animal.sleep();
            animal.makeNoise();
            animal.eat();
            animal.roam();
            
            if (animal instanceof Pet)
            {
                Pet pet = (Pet) animal;
                pet.play();
                pet.beFriendly();
            }
        }
    }
}
