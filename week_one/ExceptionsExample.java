import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsExample {
    // checked exceptions
    // unchecked exceptions
    // try-catch

    public static void main(String[] args) //throws FileNotFoundException
    {
        // unchecked exception:
        // int[] a = new int[3];
        // System.out.println(a[5]);
        
        try {
            Scanner kb = new Scanner(new File("week_one/data/exception.txt"));
            int x = kb.nextInt();
            if (x < 0) 
            {
                // unchecked exception
                throw new IllegalArgumentException("Need a postive int.");
            }
            System.out.println(x);

        }
        catch (InputMismatchException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Could not read in file.");
        }
        finally {
            System.out.println("Made it to the end...");
        }
        
    }
}
