package client;

import nature.Coyote;
import nature.Dog;
import nature.Habitat;
import nature.Hippo;
import nature.HouseCat;
import nature.Lion;
import nature.Ocelot;
import nature.SiameseCat;
import nature.Wolf;

/**
 * Demo used to manually test the program.
 * 
 * @author Hunter Wilson
 * @version 02.08.2005
 */
public class Demo
{
	/**
     * Runs the demo.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Habitat hb = new Habitat("Place", 0, 0);
        hb.addAnimal(new Hippo("1"));
        hb.addAnimal(new Lion("2"));
        hb.addAnimal(new SiameseCat("3"));
        hb.addAnimal(new HouseCat("4"));
        hb.addAnimal(new Ocelot("5"));
        hb.addAnimal(new Coyote("6"));
        hb.addAnimal(new Dog("7"));
        hb.addAnimal(new Wolf("8"));

        hb.testAnimals();
    }
}
