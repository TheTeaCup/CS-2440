package library;

/**
 * @author Hunter.Wilson
 * @version 04.03.2024
 */
public class Book implements Comparable<Book>
{
    private String author;
    private String title;
    private int numPages;

    /**
     * @param author string
     * @param title string
     * @param numPages int
     */
    public Book(String author, String title, int numPages)
    {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    /**
     * getAuthor.
     * @return author
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * getTitle.
     * @return title
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * getNumPages.
     * @return numPages
     */
    public int getNumPages()
    {
        return this.numPages;
    }

    /**
     * equals.
     * @param other Object
     * @return boolean
     */
    public boolean equals(Object other)
    {
        if (this == other) 
        {
            return true;
        }
        // todo: getClass() ???
        if (other == null || getClass() != other.getClass())
        {
            return false;
        }

        Book book = (Book) other;

        return author.equals(book.author) && title.equals(book.title);
    }

    /**
     * compareTo.
     * @param book Book
     * @return int
     */
    public int compareTo(Book book)
    {
        int authorComparison = author.compareTo(book.author);
        if (authorComparison == 0) 
        {
            return title.compareTo(book.title);
        }
        return authorComparison;
    }

    /**
     * toString.
     * @return string
     */
    public String toString()
    {
        return author + ", " + title + ", " + numPages;
    }
}
