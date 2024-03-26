package storage;

/**
 * DoubleLinkedSeq.
 * @author Hunter.Wilson
 * @version 03.21.2024
 */

public class DoubleLinkedSeq implements Cloneable 
{
    private int manyNodes;
    private DoubleNode tail;
    private DoubleNode head;
    private DoubleNode precursor;
    private DoubleNode cursor;

    /**
     * DoubleLinkedSeq.
     * Sets the values.
     */
    public DoubleLinkedSeq() 
    {
        this.manyNodes = 0;
        this.tail = null;
        this.head = null;
        this.precursor = null;
        this.cursor = null;
    }

    /**
     * size.
     * @return int
     */
    public int size() 
    {
        return this.manyNodes;
    }

    /**
     * addAfter.
     * @param data double
     */
    public void addAfter(double data) 
    {
        if (this.manyNodes == 0)
        {
            this.head = new DoubleNode(data);
            this.tail = this.head;
            this.cursor = this.head;
        }
        else if (this.manyNodes == 1)
        {
            DoubleNode dn = new DoubleNode(data);
            this.head.setLink(dn);
            this.tail = dn;
            this.cursor = this.tail;
            this.precursor = this.head;
        }
        else if (this.cursor == this.head)
        {
            DoubleNode dn = new DoubleNode(data, this.cursor.getLink());
            this.head.setLink(dn);
            this.cursor = this.cursor.getLink();
            this.precursor = this.head;
        }
        else if (this.cursor != this.head && this.precursor != null)
        {
            DoubleNode dn = new DoubleNode(data, this.cursor.getLink());
            this.cursor.setLink(dn);

            if (this.cursor == this.tail)
            {
                this.tail = this.tail.getLink();
            }

            this.cursor = this.cursor.getLink();
            this.precursor = this.precursor.getLink();
        }
        else if (!isCurrent())
        {
            DoubleNode dn = new DoubleNode(data);
            this.tail.setLink(dn);
            this.precursor = this.tail;
            this.tail = this.tail.getLink();
            this.cursor = this.tail;
        }
        this.manyNodes++;
    }

    /**
     * addBefore.
     * @param data double
     */
    public void addBefore(double data) 
    {
        if (this.head == null && this.tail == null)
        {
            this.head = new DoubleNode(data);
            this.tail = this.head;
            this.cursor = this.head;
        }
        else if (this.cursor == null)
        {
            this.head = new DoubleNode(data, this.head);
            cursor = head;
        }
        else if (this.precursor == null)
        {
            this.head = new DoubleNode(data, this.head);
            this.cursor = this.head;
        }
        else if (this.cursor != null && this.precursor != null)
        {
            DoubleNode dn = new DoubleNode(data, this.cursor);
            this.precursor.setLink(dn);
            this.cursor = dn;
        }
        this.manyNodes++;
    }    

    /**
     * addAll.
     * @param addend DoubleLinkedSeq
     * @throws NullPointerException if addend is null
     */
    public void addAll(DoubleLinkedSeq addend) throws NullPointerException
    {
        DoubleNode newCurs = cursor;
        start();
            
        for (int i = 0; i < this.manyNodes; i++)
        {
            advance();
        }

        DoubleLinkedSeq dls = new DoubleLinkedSeq();
        DoubleNode curs;
        for (curs = addend.head; curs != null; curs = curs.getLink())
        {
            dls.addAfter(curs.getData());
        }

        DoubleNode cur;
        for (cur = dls.head; cur != null; cur = cur.getLink())
        {
            addAfter(cur.getData());
        }

        this.cursor = newCurs;
    }

    /**
     * isCurrent.
     * @return true / false
     */
    public boolean isCurrent() 
    {
        return this.cursor != null;
    }

    /**
     * start.
     * starts the methods.
     */
    public void start() 
    {
        this.cursor = (this.head == null) ? null : this.head;
        this.precursor = null;
    }

    /**
     * advance.
     * throws a IllegalStateException if no current element.
     */
    public void advance() 
    {
        if (!isCurrent()) 
        {
            throw new IllegalStateException("no current element to advance.");
        }
        else
        {
            if (this.cursor == this.tail)
            {
                this.cursor = null;
                this.precursor = null;
            }
            else if (this.cursor != this.tail && this.cursor != this.head)
            {
                this.cursor = this.cursor.getLink();
                this.precursor = this.precursor.getLink();
            }
            else if (this.cursor == this.head)
            {
                this.cursor = this.cursor.getLink();
                this.precursor = this.head;
            }
        }
    }

    /**
     * getCurrent.
     * @return double
     */
    public double getCurrent() 
    {
        if (!isCurrent()) 
        {
            throw new IllegalStateException("isCurrent is null");
        }

        return this.cursor.getData();
    }

    /**
     * removeCurrent.
     * removes the current element
     */
    public void removeCurrent() 
    {
        if (!isCurrent()) 
        {
            throw new 
                IllegalStateException("no current element to remove.");
        }
        else
        {
            if (this.head == this.tail) 
            {
                this.head = null;
                this.tail = null;
                this.cursor = null;
                this.manyNodes--;
            }
            else if (this.cursor == this.head && this.precursor == null) 
            {
                this.head = this.head.getLink();
                this.cursor = this.head;
                this.manyNodes--;
            }
            else if (this.cursor != this.tail && this.precursor != null) 
            {
                this.cursor = this.cursor.getLink();
                this.precursor.setLink(this.cursor);
                this.manyNodes--;
            }
            else if (this.cursor == this.tail && this.precursor != null) 
            {
                this.cursor = null;
                this.precursor.setLink(null);
                this.precursor = null;
                this.manyNodes--;
            }
        }
    }

    /**
     * clone.
     * makes a clone of the DoubleLinkedSeq.
     * @return DoubleLinkedSeq
     */
    public DoubleLinkedSeq clone() 
    {
        DoubleLinkedSeq clonedSeq;
        try 
        {
            clonedSeq = (DoubleLinkedSeq) super.clone();
        } 
        catch (CloneNotSupportedException e) 
        {
            throw new 
                RuntimeException("Clone not supported for DoubleLinkedSeq.");
        }

        if (this.cursor == null)
        {
            DoubleNode[] nl = DoubleNode.listCopyWithTail(this.head);
            clonedSeq.head = nl[0];
            clonedSeq.tail = nl[1];
        }
        else if (this.cursor == this.head)
        {
            DoubleNode[] nl = DoubleNode.listCopyWithTail(this.head);
            clonedSeq.head = nl[0];
            clonedSeq.tail = nl[1];
            clonedSeq.precursor = null;
            clonedSeq.cursor = clonedSeq.head;
        }
        else if (this.cursor != null && this.precursor != null) 
        {
            DoubleNode[] s1 = DoubleNode.listPart(this.head, this.precursor);
            clonedSeq.head = s1[0];
            clonedSeq.precursor = s1[1];
            DoubleNode[] s2 = DoubleNode.listPart(this.cursor, this.tail);
            clonedSeq.cursor = s2[0];
            clonedSeq.tail = s2[1];
            clonedSeq.precursor.setLink(clonedSeq.cursor);
        }
        return clonedSeq;
    }

    /**
     * toString.
     * @return string
     */
    public String toString() 
    {
        String result = "<";

        DoubleNode current = this.head;

        while (current != null) 
        {
            if (this.cursor == current) 
            {
                result += "[" + current.getData() + "]";
            } 
            else 
            {
                result += current.getData();
            }

            if (current.getLink() != null) 
            {
                result += ", ";
            }
            current = current.getLink();
        }

        result += ">";
        return result;
    }

    /**
     * equals.
     * @param other object
     * @return true / false
     */
    public boolean equals(Object other) 
    {
        boolean result = true;
        DoubleLinkedSeq otherSeq = (DoubleLinkedSeq) other;
    
        if (this.manyNodes == otherSeq.manyNodes) 
        {
            DoubleNode s1 = this.head;
            DoubleNode s2 = otherSeq.head;
    
            while (s1 != null) 
            {
                if (s1.getData() != s2.getData()) 
                {
                    result = false;
                    break;
                }
                if (s1 == this.cursor && s2 != otherSeq.cursor) 
                {
                    result = false;
                    break;
                }
                if (s2 == otherSeq.cursor && s1 != this.cursor) 
                {
                    result = false;
                    break;
                }
                s1 = s1.getLink();
                s2 = s2.getLink();
            }
        } 
        else
        {
            result = false;
        }
    
        return result;
    }
    

    /**
     * concatenation.
     * @param s1 DoubleLinkedSeq
     * @param s2 DoubleLinkedSeq
     * @return the elements of s1 followed by s2
     */
    public static DoubleLinkedSeq 
        concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2) 
    {
        DoubleLinkedSeq seq = new DoubleLinkedSeq();

        DoubleNode s1Current = s1.head;
        while (s1Current != null) 
        {
            seq.addAfter(s1Current.getData());
            s1Current = s1Current.getLink();
        }

        DoubleNode s2Current = s2.head;
        while (s2Current != null) 
        {
            seq.addAfter(s2Current.getData());
            s2Current = s2Current.getLink();
        }

        seq.cursor = null;

        return seq;
    }
}
