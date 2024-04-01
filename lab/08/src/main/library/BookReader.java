package library;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import storage.SortedLinkedList;

public class BookReader 
{
    private Scanner fileIn;
    private SortedLinkedList<Book> books;
    
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

    public void setFileIn(Scanner fileIn)
    {
        this.fileIn = fileIn;
    }

    public void readLines()
    {
        books = new SortedLinkedList<Book>();
        String line;
        while (fileIn.hasNextLine()) {
            line = fileIn.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String author = parts[0].trim();
                String title = parts[1].trim();
                int pages = Integer.parseInt(parts[2].trim());
                Book book = new Book(author, title, pages);
                books.add(book);
            } else {
                System.out.println("Invalid data format: " + line);
            }
        }
    }

    public SortedLinkedList<Book> getBooks()
    {
        return this.books;
    }

    public void printMoreThan300()
    {
        Book temp;
        Iterator<Book> itr = this.books.iterator();
        while (itr.hasNext())
        {
            temp = itr.next();
            if (temp.getNumPages() > 300)
            {
                System.out.println(temp.toString());
            }
        }
    }

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

    public void removeLessThan200()
    {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getNumPages() < 200) {
                iterator.remove(); // Use the iterator's remove method to remove the book
            }
        }
    }
}
