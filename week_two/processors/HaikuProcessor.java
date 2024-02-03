package week_two.processors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * HaikuProcessor.
 * Processor for Haikus.
 * @author Hunter Wilson
 * @version 02/03/2024
 */
public class HaikuProcessor {
    public int NUM_LINES_IN_HAIKU = 3;
    private String title;
    private String author;
    private String[][] poem;

    /**
     * readFile.
     * opens the Haiku file and sets the Poem array.
     * @param filename
     */
    public void readFile(String filename) 
    {
        try 
        {
            Scanner sc = new Scanner(new File(filename));

            this.title = sc.nextLine();
            this.author = sc.nextLine();
            this.poem = new String[NUM_LINES_IN_HAIKU][];

            for (int i = 0; i < NUM_LINES_IN_HAIKU; i++)
            {
                if (!sc.hasNextLine()) 
                {
                    System.out.println("Not enough lines in file. There must be at least five.");
                    sc.close();
                    return;
                }

                String line = sc.nextLine();
                String[] words = line.split(" ");

                this.poem[i] = words;
            }
            sc.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("Could not found file " + filename);
        }
    }

    /**
     * printPoem.
     * This will print out the poem.
     */
    public void printPoem()
    {
        if (poem == null) 
        {
            System.out.println("No poem to print.");
            return;
        }

        System.out.printf("%s by %s\n", this.title, this.author);

        for (int i = 0; i < NUM_LINES_IN_HAIKU; i++) 
        {
            for (int j = 0; j < poem[i].length; j++) 
            {
                System.out.print(poem[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * getWord.
     * Get a word from the poem.
     * @param lineNum
     * @param wordNum
     * @return "word"
     */
    public String getWord(int lineNum, int wordNum)
    {
        if (poem == null || lineNum < 0 || 
                lineNum >= NUM_LINES_IN_HAIKU || poem[lineNum] == null) 
        {
            throw new IllegalArgumentException("Invalid line number " + lineNum + " for poem with " + NUM_LINES_IN_HAIKU + " lines");
        }
    
        if (wordNum < 0 || wordNum >= poem[lineNum].length) 
        {
            throw new IllegalArgumentException("Invalid word number " + wordNum + " for line with " + poem[lineNum].length + " words");
        }
    

        return poem[lineNum][wordNum];
    }
    
}