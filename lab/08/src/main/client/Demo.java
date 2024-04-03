package client;

import library.Book;
import library.BookReader;

/**
 * Demo used to manually test the program.
 * 
 * @author Hunter.Wilson
 * @version 04.02.2024
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
        BookReader bR = new BookReader("data/bookdata.txt");
        for (Book b : bR.getBooks())
        {
            System.out.println(b.toString());
        }
    }
}
