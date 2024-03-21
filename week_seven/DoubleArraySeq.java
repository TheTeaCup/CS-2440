package week_seven;

/**
 * DoubleArraySeq.
 * 
 * @author Hunter.Wilson
 * @version 02.22.2024
 */

public class DoubleArraySeq implements Cloneable
{
    public static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int manyItems;
    private int currentIndex;

    /**
     * DoubleArraySeq no-arg constructor.
     */
    public DoubleArraySeq()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * DoubleArraySeq one-arg constructor.
     * @param initialCapacity int
     */
    public DoubleArraySeq(int initialCapacity)
    {
        this.data = new double[initialCapacity];
        this.manyItems = 0;
        this.currentIndex = 0;   
    }

    /**
     * addAfter the currentIndex.
     * @param element double
     */
    public void addAfter(double element)
    {
        if (data.length == manyItems)
        {
            ensureCapacity(manyItems * 2 + 1);
        }
        
        if (isCurrent()) 
        {
            for (int i = manyItems; i > (currentIndex + 1); i--)
            {
                data[i] = data[i - 1];
            }

            currentIndex++;
            data[currentIndex] = element;
            manyItems++;
        }
        else 
        {
            currentIndex = manyItems;
            data[currentIndex] = element;
            manyItems++;
        } 
    }

    /**
     * addBefore currentIndex.
     * @param element double
     */
    public void addBefore(double element)
    {
        if (data.length == manyItems)
        {
            ensureCapacity(manyItems * 2 + 1);
        }
        
        if (isCurrent()) 
        {
            for (int i = manyItems; i > currentIndex; i--)
            {
                data[i] = data[i - 1];
            }

            data[currentIndex] = element;
            manyItems++;
        } 
        else 
        {
            for (int i = manyItems; i > 0; i--)
            {
                data[i] = data[i - 1];
            }

            currentIndex = 0;
            data[currentIndex] = element;
            manyItems++;
        }  
    }

    /**
     * addAll appended DoubleArraySeq.
     * @param appended DoubleArraySeq
     */
    public void addAll(DoubleArraySeq appended)
    {
        ensureCapacity(manyItems + appended.manyItems);
        System.arraycopy(appended.data, 0, data, manyItems, appended.manyItems);
        manyItems += appended.manyItems;
    }

    /**
     * trimToSize.
     * changes the size of the 
     * DoubleArray to the required amount.
     */
    public void trimToSize()
    {
        if (data.length > manyItems) 
        {
            double[] trimmedArray = new double[manyItems];
            
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        } 
    }

    /**
     * ensureCapacity.
     * @param minimumCapacity int
     */
    public void ensureCapacity(int minimumCapacity)
    {
        if (getCapacity() < minimumCapacity) 
        {
            double[] expandData = new double[minimumCapacity];
            System.arraycopy(data, 0, expandData, 0, manyItems);
            data = expandData;
        }
    }

    /**
     * start.
     * sets currentIndex to 0
     */
    public void start()
    {
        this.currentIndex = 0;
    }

    /**
     * advance.
     * increases the currentIndex by 1.
     */
    public void advance()
    {
        if (isCurrent())
        {
            this.currentIndex++;
        }
        else
        {
            throw new IllegalStateException("no current element");
        }
    }

    /**
     * getCurrent.
     * @return double
     */
    public double getCurrent()
    {
        if (isCurrent())
        {
            return data[currentIndex];
        }
        else
        {
            throw new IllegalStateException("no current element");
        }
    }

    /**
     * removeCurrent.
     * removes the current index.
     */
    public void removeCurrent()
    {
        if (isCurrent())
        {
            for (int i = currentIndex; i < manyItems; i++) 
            {
                data[i] = data[i + 1];
            }
            manyItems--;
        }
        else
        {
            throw new IllegalStateException("no current element");
        }
    }

    /**
     * isCurrent.
     * @return is current less than manyItems.
     */
    public boolean isCurrent()
    {
        return (this.currentIndex < this.manyItems);
    }

    /**
     * getCapacity.
     * @return length
     */
    public int getCapacity()
    {
        return this.data.length;
    }

    /**
     * size.
     * @return manyItems count
     */
    public int size()
    {
        return this.manyItems;
    }

    /**
     * clone.
     * makes a clone of the DoubleArraySeq.
     * @return clone
     */
    public DoubleArraySeq clone()
    {
        DoubleArraySeq das;
        
        try 
        {
            das = (DoubleArraySeq) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("does not implement cloneable");
        }

        das.data = this.data.clone();

        return das;
    }

    /**
     * toString.
     * makes the DoubleArraySeq a string.
     * @return string
     */
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

    /**
     * equals.
     * @param other Object
     * @return true or false
     */
    public boolean equals(Object other)
    {
        boolean equal = false;

        DoubleArraySeq seq2 = (DoubleArraySeq) other;

        if (this.manyItems == seq2.manyItems)
        {
            if (this.currentIndex == seq2.currentIndex)
            {
                boolean dataEqual = true;
                
                for (int i = 0; i < manyItems && dataEqual; i++) 
                {
                    if (this.data[i] != seq2.data[i])
                    {
                        dataEqual = false;
                    }
                }

                if (dataEqual)
                {
                    equal = true;
                }
            }
        }

        return equal;
    }

    /**
     * concatenation.
     * @param s1 DoubleArraySeq
     * @param s2 DoubleArraySeq
     * @return s1 + s2
     */
    public static DoubleArraySeq concatenation(DoubleArraySeq s1, 
        DoubleArraySeq s2)
    {
        DoubleArraySeq seq = 
            new DoubleArraySeq(s1.getCapacity() + s2.getCapacity());

        System.arraycopy(s1.data, 0, seq.data, 0, s1.manyItems);
        System.arraycopy(s2.data, 0, seq.data, s1.manyItems, s2.manyItems);

        seq.manyItems = (s1.manyItems + s2.manyItems);
        seq.currentIndex = seq.manyItems;

        return seq;
    }
}

