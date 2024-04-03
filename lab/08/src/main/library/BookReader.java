package library;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import storage.SortedLinkedList;

/**
 * @author Hunter.Wilson
 * @version 04.03.2024
 */
public class BookReader 
{
    private Scanner fileIn;
    private SortedLinkedList<Book> books;
    
    /**
     * BookReader.
     * @param filename string
     */
    public BookReader(String filename)
    {
        try
        {
            setFileIn(new Scanner(new FileReader(filename)));
        }
        catch (IOException e)
        {
            System.out.println("could not open file");
        }

        readLines();
        fileIn.close();
    }

    /**
     * setFileIn.
     * @param fileIn scanner
     */
    public void setFileIn(Scanner fileIn)
    {
        this.fileIn = fileIn;
    }

    /**
     * readLines.
     */
    public void readLines()
    {
        books = new SortedLinkedList<Book>();
        String line;
        while (fileIn.hasNextLine()) 
        {
            line = fileIn.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) 
            {
                String author = parts[0].trim();
                String title = parts[1].trim();

                int pages = Integer.parseInt(parts[2].trim());

                Book book = new Book(author, title, pages);
                books.add(book);
            } 
            else
            {
                System.out.println("invalid data format: " + line);
            }
        }
    }

    /**
     * getBooks.
     * @return books
     */
    public SortedLinkedList<Book> getBooks()
    {
        return this.books;
    }

    /**
     * printMoreThan300.
     */
    public void printMoreThan300()
    {
        final int MIN_PAGES = 300;
        Book temp;
        Iterator<Book> itr = this.books.iterator();
        while (itr.hasNext())
        {
            temp = itr.next();
            if (temp.getNumPages() > MIN_PAGES)
            {
                System.out.println(temp.toString());
            }
        }
    }

    /**
     * averagePages.
     * @return double
     */
    public double averagePages()
    {
        int totalPages = 0;
        int numBooks = 0;
        
        for (Book book : books)
        {
            totalPages += book.getNumPages();
            numBooks++;
        }
        
        return (double) totalPages / numBooks;
    }

    /**
     * removeLessThan200.
     */
    public void removeLessThan200()
    {
        final int MIN_PAGES = 200;
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) 
        {
            Book book = iterator.next();
            if (book.getNumPages() < MIN_PAGES) 
            {
                iterator.remove();
            }
        }
    }
}
