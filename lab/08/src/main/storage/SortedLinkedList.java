package storage;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedLinkedList <T extends Comparable<? super T>> implements Iterable<T>
{
    private Node<T> head;
    private int length;
    
    public SortedLinkedList()
    {
        this.head = null;
        this.length = 0;
    }

    public void add(T entry)
    {
        Node<T> newNode = new Node<>(entry); 
        if (head == null || entry.compareTo(head.getData()) <= 0) {
            newNode.setLink(head);
            head = newNode;
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current != null && entry.compareTo(current.getData()) > 0) {
                previous = current;
                current = current.getLink();
            }
            if (previous != null) {
                newNode.setLink(current);
                previous.setLink(newNode);
            } else {
                newNode.setLink(head);
                head = newNode;
            }
        }
        this.length++;;
    }

    public T remove(int position)
    {
        if (position < 0 || position >= length) {
            return null;  // Index out of range
        }
    
        Node<T> removedNode = null;
    
        if (position == 0) {
            removedNode = head;
            head = head.getLink();
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            int index = 0;
    
            while (index < position) {
                previous = current;
                current = current.getLink();
                index++;
            }
    
            removedNode = current;
            previous.setLink(current.getLink());
        }
    
        this.length--;
        return removedNode.getData(); 
    }

    public void clear()
    {
        this.head = null;
        this.length = 0;
    }

    public T getEntry(int position)
    {
        if (position < 0 || position >= length) {
            return null;
        }
    
        Node<T> current = head;
        int index = 0;
    
        while (index < position) {
            current = current.getLink();
            index++;
        }
    
        return current.getData();
    }

    public int getPosition(T entry)
    {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.getData().equals(entry)) {
                return index;
            }
            current = current.getLink();
            index++;
        }

        throw new IllegalArgumentException("Element not found in the list.");
    }

    public boolean contains(T entry)
    {
        Node<T> current = head;

        while (current != null) {
            if (current.getData().equals(entry)) {
                return true;
            }
            current = current.getLink();
        }
    
        return false;
    }

    public int getLength()
    {
        return this.length;
    }

    public boolean isEmpty()
    {
        return this.length == 0;
    }

    public void display()
    {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getLink();
        }

        System.out.println();
    }

    public Iterator<T> iterator()
    {
        return new SLLIterator(head);
    }

    private Node<T> getPrevious(T entry)
    {
        Node<T> previous = null;
        Node<T> current = head;
    
        while (current != null && entry.compareTo(current.getData()) > 0) {
            previous = current;
            current = current.getLink();
        }
    
        return previous;
    }

    private class SLLIterator implements Iterator<T>
    {
        private boolean calledNext;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;

        public SLLIterator(Node<T> firstNode)
        {
            this.prevNode = null;
            this.currNode = firstNode;
        }

        public boolean hasNext()
        {
            return this.currNode != null;
        }

        public T next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException("no more elements in the list.");
            }
            T data = currNode.getData();
            prevNode = currNode;
            currNode = currNode.getLink();
            return data;
        }

        public void remove() {   
            if (prevNode == null) {
                throw new UnsupportedOperationException("Cannot remove the first element using iterator's remove()");
            }
        
            if (head == prevNode) {
                head = head.getLink();
            } else {
                prevNode.setLink(currNode);
            }
        
            currNode = prevNode.getLink();
            calledNext = false;
            prevNode = null;
            length--;
        }        
    }
}