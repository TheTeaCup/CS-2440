package storage;

public class DoubleArraySeq 
{
    public static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int manyItems;
    private int currentIndex;

    public DoubleArraySeq()
    {
        this(DEFAULT_CAPACITY);
    }

    public DoubleArraySeq(int initialCapacity)
    {
        this.data = new double[initialCapacity];
        this.manyItems = 0;
        this.currentIndex = 0;   
    }

    public void addAfter(double element)
    {

    }

    public void addBefore(double element)
    {

    }

    public void addAll(DoubleArraySeq appended)
    {

    }

    public void trimToSize()
    {

    }

    public void ensureCapacity(int minimumCapacity)
    {

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

    public boolean isCurrent()
    {
        return false;
    }

    public int getCapacity()
    {
        return this.data.length;
    }

    public int size()
    {
        return this.manyItems;
    }

    public DoubleArraySeq clone()
    {
        return new DoubleArraySeq();
    }

    public String toString()
    {
        String result = "<";

        for (int i = 0; i < manyItems; i++) 
        {
            if (i > 0) 
            {
                result += ", ";
            }

            if (i == currentIndex) 
            {
                result += "[";
            }

            result += data[i];

            if (i == currentIndex) 
            {
                result += "]";
            }
        }
        
        result += ">";
        return result;
    }

    public boolean equals(Object other)
    {
        return false;
    }

    public static DoubleArraySeq concatenation(DoubleArraySeq s1, 
        DoubleArraySeq s2)
    {
        DoubleArraySeq seq = new DoubleArraySeq(s1.manyItems + s2.manyItems);
        return seq;
    }
}
