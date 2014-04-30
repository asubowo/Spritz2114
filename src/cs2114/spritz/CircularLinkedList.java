package cs2114.spritz;

import java.util.Iterator;
import java.util.NoSuchElementException;

//-------------------------------------------------------------------------
/**
 * A circular, doubly-linked list, with an indicator at the end
 *
 * @param <E> the type of element stored in the list
 *
 * @author Andrew Subowo (asubowo)
 * @version 4.13.2014
 */
public class CircularLinkedList<E>
{
	//~ Fields ................................................................

	private Node<E> current;
	private Node<E> lastNode;

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
			lastNode = newNode;
			size++;
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
	 * Resets list back to beginning
	 */
	public void reset() {
		current = lastNode;
	}

	// ----------------------------------------------------------
	/**
	 * Checks if the linked list has reached the end
	 * @return If linked list has returned to its original state
	 */
	public boolean end() {
		return current.equals(lastNode);
	}
}
