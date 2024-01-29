package week_two.processors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GridProcessor {
    private String[][] grid; 

    public void readInGrid(String filename) {
        try {
            Scanner inputFile = new Scanner(
                new File(filename)
            );

            int rows = Integer.parseInt(inputFile.next());
            int cols = Integer.parseInt(inputFile.next());
            String[][] grid = new String[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = inputFile.next();
                }
            }

            this.grid = grid;

        } 
        catch (FileNotFoundException e) {
            System.out.printf("Could not find file at %s\n", filename);
        }
        catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("File improperly formatted.\n" + 
            "The file must beging with two ints representing the array bounds.\n" + 
            "The file also must contain enough data to fill said array.\n");
        }
    }

    public void printGrid() {
        if (this.grid == null) 
        {
            System.out.println("No grid to print.");
            return;
        } 
        
        for (String[] row : grid) {
            for (String word : row) {
                System.out.print(word + "\t");
            }
            System.out.println();
        }
        
    }
}
