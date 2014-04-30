package cs2114.spritz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is the logic base for the Spritz application.
 *
 * @author Andrew Subowo (asubowo)
 * @author Cory Howard (arch518)
 * @author Meghan Hamannwright (meghankh)
 * @version 4.13.2014
 *
 */
public class Spritz {

	private Scanner input;
	private String token;
    private CircularLinkedList<String> dataArray;

	/**
	 * Constructor for this class
	 * The default class displays the embedded text file, Lorem Ipsum
	 */
	public Spritz() {
		dataArray = new CircularLinkedList<String>();
	}

	/**
	 * Overloaded constructor - able to take in arguments
	 * @param is InputStream - This allows this application to parse .txt files
	 */
	public Spritz(InputStream is) { 

		dataArray = new CircularLinkedList<String>();

		try {
			BufferedReader re = new BufferedReader(new InputStreamReader(is, "UTF8"));
			parseTxt(re);
		} catch (IOException e) {
			System.out.println("File not found or not supported.");
			e.printStackTrace();
		}
	}

	/**
	 * Parses .txt files
	 * @param re Buffered reader
	 */
	public void parseTxt(BufferedReader re) {
		input = new Scanner(re);
		while (input.hasNext()){
			token = input.next();
			dataArray.add(token);
		}
	}
	

	/**
	 * Parses the input and stores it into the node array
	 */
	public void parseInput() {
		while (input.hasNext()){
			token = input.next();
			dataArray.add(token);
		}
	}

	/**
	 * Prints the contents of the node array
	 * @return The contents of the node array owned by the Spritz class
	 */
	public String print(){
		return dataArray.toString();
	}

	/**
	 * Returns the current word
	 * @return The current word in the data stream
	 */
	public String getCurrentWord() {
		return dataArray.getCurrent();
	}

	/**
	 * Tells Spritz to move to the next word in the data array
	 * and return the appropriate string
	 * @return The string next in the data array.
	 */
	public String next() {
		dataArray.previous();
		return dataArray.getCurrent();
	}

	/**
	 * Tells Spritz to move to the previous word in the data array
	 * @return the string previous in the data array
	 */
	public String previous() {
		dataArray.next();
		return dataArray.getCurrent();
	}

	// ----------------------------------------------------------
	/**
	 * Resets the linked list to its original state
	 */
	public void reset() {
	    dataArray.reset();
	}

	// ----------------------------------------------------------
	/**
	 * Checks if the linked list has reached the end
	 * @return If linked list has returned to its original state
	 */
	public boolean end() {
	    return dataArray.end();
	}
	
	/**
	 * Clears the list
	 */
	public void clear()
	{
		dataArray.clear();
	}
}
