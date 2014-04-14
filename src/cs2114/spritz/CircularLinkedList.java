package cs2114.spritz;

import java.util.Iterator;
import java.util.NoSuchElementException;

//-------------------------------------------------------------------------
/**
 * A circular, doubly-linked list.
 *
 * @param <E> the type of element stored in the list
 *
 * @author Andrew Subowo (asubowo)
 * @version (2014.3.29)
 */
public class CircularLinkedList<E>
{
    //~ Fields ................................................................

    private Node<E> current;

    private int size;

    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * This is the constructor for the linked list
     */
    public CircularLinkedList()
    {
        size = 0; //Size of the array
        current = new Node<E>(null);
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Updates the list's current location to the node next
     */
    public void next()
    {
        if (size != 0) {
            current = current.next();
        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the list's current location to the node previous
     */
    public void previous()
    {
        if (size != 0) {
            current = current.previous();
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the data of the current node
     * @return The data of the current node
     */
    public E getCurrent()
    {
        if (size != 0) {
            return current.data();
        }

        else {
            throw new NoSuchElementException("Cannot get current. " +
                "The list is empty!");
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the size of the Circular linkedlist
     * @return An int type representing the size
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Adds a node at the current position
     * @param item The data content to be added
     */
    public void add(E item)
    {
        Node<E> newNode = new Node<E>(item);

        if (size == 0) {
            newNode.join(newNode);
            current = newNode;
            size++;
        }

        else {
            Node<E> temp = current.previous();
            temp.split();
            temp.join(newNode);
            newNode.join(current);
            current = newNode;
            size++;
        }
    }


    // ----------------------------------------------------------
    /**
     * Removes the node at the current position
     * @return The data of the node that was removed
     */
    public E removeCurrent()
    {
        if (size != 0) {
            size--;
            current = current.previous();
            current.split();

            return current.data();
        }

        else {
            throw new NoSuchElementException("Cannot remove " +
                "current. The list is empty!");
        }
    }


    // ----------------------------------------------------------
    /**
     * This method clears the circular linked list
     */
    public void clear()
    {
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Prints out the contents of the list
     * @return The contents of the list
     */
    public String toString()
    {
    
        String temp = "";

        if (size != 0) {
            for (int c = 0; c < size - 1; c++) {
                temp += getCurrent() + " ";
                previous();
            }
            temp += getCurrent();
            previous();
        }

        else {
            return "[]";
        }

        return temp;
    }


    // ----------------------------------------------------------
    /**
     * Creates an iterator class
     * @return A new iterator class
     */
    public Iterator<E> iterator()
    {
        return new CircularLinkedListIterator();
    }


    //~ Inner classes .........................................................

    // ----------------------------------------------------------
    /**
     *  This is the iterator class - allows iteration through the
     *  CircularLinkedList
     *
     *  @author Andrew Subowo (asubowo)
     *  @version 4.2.2014
     */
    private class CircularLinkedListIterator implements Iterator<E>
    {

        //~ Constructors ......................................................

        // ----------------------------------------------------------
        /**
         * This is the constructor class
         */
        public CircularLinkedListIterator()
        {
            //Nothing to do here. Move along...
        }


        //~ Public methods ....................................................

        // ----------------------------------------------------------
        /**
         * This method determines if the node exists or not
         * @return If there is an element following the preceeding
         */
        public boolean hasNext()
        {
            return (size != 0);
        }


        // ----------------------------------------------------------
        /**
         * Returns the data of the next item in the iterator
         * @return The data of the next item
         */
        public E next()
        {
            if (hasNext()) {
                current = current.next();
                return getCurrent();
            }

            else {
                return null;
            }
        }


        // ----------------------------------------------------------
        /**
         * This method removes an element from a list.
         * However, this method is not supported
         */
        public void remove()
        {
            throw new UnsupportedOperationException(
                "remove() is not supported.");
        }
    }
}
