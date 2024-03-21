package week_seven;

public class StringNode {
    private String data;
    private StringNode link;

    public StringNode(String data)
    {
        this(data, null);
    }

    public StringNode(String data, StringNode link)
    {
        setData(data);
        setLink(link);
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public void setLink(StringNode link)
    {
        this.link = link;
    }

    public String getData()
    {
        return this.data;
    }

    public StringNode getLink()
    {
        return this.link;
    }

    
}
