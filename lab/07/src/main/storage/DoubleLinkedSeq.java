package storage;

public class DoubleLinkedSeq implements Cloneable
{
    private int manyNodes;
    private DoubleNode tail;
    private DoubleNode head;
    private DoubleNode precursor;
    private DoubleNode cursor;

    public DoubleLinkedSeq()
    {

    }

    public int size()
    {
        return 0;
    }

    public void addAfter(double data)
    {

    }

    public void addBefore(double data)
    {

    }

    public void addAll(DoubleLinkedSeq addend)
    {

    }

    public boolean isCurrent()
    {
        return false;
    }

    public void start()
    {

    }

    public void advance()
    {

    }

    public double getCurrent()
    {
        return 0.0;
    }

    public void removeCurrent()
    {

    }

    public DoubleLinkedSeq clone()
    {
        DoubleLinkedSeq dls;

        try 
        {
            dls = (DoubleLinkedSeq) super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("does not implement cloneable");
        }

        return dls;
    }

    public String toString()
    {
        return "";
    }

    public boolean equals(Object other)
    {
        return false;
    }

    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
    {
        DoubleLinkedSeq seq = new DoubleLinkedSeq();

        return seq;
    }
    
}
