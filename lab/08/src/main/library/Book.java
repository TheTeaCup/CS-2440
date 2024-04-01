package library;

public class Book implements Comparable<Book>
{
    private String author;
    private String title;
    private int numPages;

    public Book(String author, String title, int numPages)
    {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getNumPages()
    {
        return this.numPages;
    }

    public boolean equals(Object other)
    {
        if (this == other) return true;
        // todo: getClass() ???
        if (other == null || getClass() != other.getClass()) return false;

        Book book = (Book) other;

        return author.equals(book.author) && title.equals(book.title);
    }

    public int compareTo(Book book)
    {
        int authorComparison = author.compareTo(book.author);
        if (authorComparison == 0) 
        {
            return title.compareTo(book.title);
        }
        return authorComparison;
    }

    public String toString()
    {
        return author + ", " + title + ", " + numPages;
    }
}
