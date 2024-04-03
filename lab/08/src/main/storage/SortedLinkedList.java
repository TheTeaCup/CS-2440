package storage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Hunter.Wilson
 * @version 04.03.2024
 * @param <T> generic
 */
public class SortedLinkedList 
    <T extends Comparable<? super T>> implements Iterable<T>
{
    private Node<T> head;
    private int length;
    
    /**
     * SortedLinkedList.
     * no-params
     */
    public SortedLinkedList()
    {
        this.head = null;
        this.length = 0;
    }

    /**
     * add.
     * @param entry T
     */
    public void add(T entry)
    {
        Node<T> newNode = new Node<>(entry);
    
        if (head == null || entry.compareTo(head.getData()) <= 0) 
        {
            newNode.setLink(head);
            head = newNode;
        }
        else
        {
            Node<T> previous = getPrevious(entry);
            newNode.setLink(previous.getLink());
            previous.setLink(newNode);
        }
        
        length++;
    }

    /**
     * remove.
     * @param position int
     * @return new position
     */
    public T remove(int position)
    {
        if (position < 0 || position >= length)
        {
            return null;
        }
        else if (position == 0)
        {
            T and = head.getData();
            head = head.getLink();
            this.length--;
            return and;
        }
        else
        {
            Node<T> no = head;
            for (int i = 0; i < length; i++)
            {
                if (i + 1 == position && no.getLink() != null)
                {
                    T data = no.getLink().getData();
                    no.setLink(no.getLink().getLink());
                    length--;
                    return data;
                }
                else if (i + 1 == position && no.getLink() == null)
                {
                    return null;
                }
                no = no.getLink();
            }
        }
        return null;
    }

    /**
     * clear.
     */
    public void clear()
    {
        this.head = null;
        this.length = 0;
    }

    /**
     * getEntry.
     * @param position int
     * @return position
     */
    public T getEntry(int position)
    {
        if (position < 0 || position >= length)
        {
            return null;
        }
    
        Node<T> current = head;
        int index = 0;
    
        while (index < position)
        {
            current = current.getLink();
            index++;
        }
    
        return current.getData();
    }

    /**
     * getPosition.
     * @param entry T
     * @return position
     */
    public int getPosition(T entry)
    {
        Node<T> current = head;
        int index = 0;

        while (current != null)
        {
            if (current.getData().equals(entry))
            {
                return index;
            }
            current = current.getLink();
            index++;
        }

        throw new IllegalArgumentException("element not found in the list.");
    }

    /**
     * contains.
     * @param entry T
     * @return boolean
     */
    public boolean contains(T entry)
    {
        Node<T> current = head;

        while (current != null) 
        {
            if (current.getData().equals(entry)) 
            {
                return true;
            }
            current = current.getLink();
        }
    
        return false;
    }

    /**
     * getLength.
     * @return int
     */
    public int getLength()
    {
        return this.length;
    }

    /**
     * isEmpty.
     * @return boolean
     */
    public boolean isEmpty()
    {
        return this.length == 0;
    }

    /**
     * display.
     */
    public void display()
    {
        Node<T> current = head;

        while (current != null) 
        {
            System.out.print(current.getData() + " ");
            current = current.getLink();
        }

        System.out.println();
    }

    /**
     * iterator.
     * @return Iterator
     */
    public Iterator<T> iterator()
    {
        return new SLLIterator(head);
    }

    /**
     * getPrevious.
     * @param entry T
     * @return previous node
     */
    private Node<T> getPrevious(T entry)
    {
        Node<T> previous = null;
        Node<T> current = head;
    
        while (current != null && entry.compareTo(current.getData()) > 0) 
        {
            previous = current;
            current = current.getLink();
        }
    
        return previous;
    }

    /**
     * SLLIterator.
     */
    private class SLLIterator implements Iterator<T>
    {
        private boolean calledNext;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;

        /**
         * One-Arg Constructor.
         * @param firstNode Node<T>
         */
        public SLLIterator(Node<T> firstNode)
        {
            this.prevNode = null;
            this.currNode = firstNode;
        }

        /**
         * hasNext.
         * @return boolean
         */
        public boolean hasNext()
        {
            return this.currNode != null;
        }

        /**
         * next.
         * @throws NoSuchElementException something...
         * @return data
         */
        public T next()
        {
            if (!hasNext()) 
            {
                throw new NoSuchElementException();
            }

            T data = currNode.getData();
            prevNode = currNode;
            currNode = currNode.getLink();
            calledNext = true;
            nextNode = currNode != null ? currNode.getLink() : null;
            return data;
        }

        /**
         * remove.
         * @throws IllegalStateException ...
         */
        public void remove() 
        {  
            if (!calledNext) 
            {
                throw new IllegalStateException();
            }
            else
            {
                calledNext = false;
                if (head == prevNode)
                {
                    head = head.getLink();
                }
                else
                {
                    prevNode.setLink(currNode);
                }
            
                currNode = prevNode.getLink();
    
                length--;
            }
        }        
    }
}
