package storage;

/**
 * @author Hunter.Wilson
 * @version 04.03.2024
 * @param <T> generic
 */
public class Node<T>
{
    private T data;
    private Node<T> link;

    /**
     * Node.
     * @param data t
     * @param link Node<T>
     */
    public Node(T data, Node<T> link)
    {
        this.data = data;
        this.link = link;
    }

    /**
     * Node.
     * @param data T
     */
    public Node(T data)
    {
        this(data, null);
    }

    /**
     * Node.
     * no-params
     */
    public Node()
    {
        this(null, null);
    }

    /**
     * getLink.
     * @return link
     */
    public Node<T> getLink()
    {
        return link;
    }

    /**
     * getData.
     * @return data
     */
    public T getData()
    {
        return data;
    }

    /**
     * setLink.
     * @param link Node<T>
     */
    public void setLink(Node<T> link)
    {
        this.link = link;
    }

    /**
     * setData.
     * @param data T
     */
    public void setData(T data)
    {
        this.data = data;
    }
}
