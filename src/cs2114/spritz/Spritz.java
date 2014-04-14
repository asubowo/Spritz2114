package cs2114.spritz;

import sofia.app.Screen;
import sofia.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

/**
 * This is the logic base for the Spritz application.
 * 
 * @author Andrew Subowo (asubowo)
 * @author Cory Howard (arch518)
 * @author 
 * @version 4.13.2014
 *
 */
public class Spritz {

	private File testFile;
	private Scanner input;
	private String token;
	private CircularLinkedList<String> dataArray;


	/**
	 * Constructor for this class
	 * The default class displays the embedded text file, Lorem Ipsum
	 * @throws FileNotFoundException 
	 */
	public Spritz() throws FileNotFoundException {
		testFile = new File("\resources\testFile.txt");
		
			input = new Scanner(testFile);

		

		dataArray = new CircularLinkedList<String>();
		parseInput();
	}

	/**
	 * Overloaded constructor - able to take in arguments
	 */
	//public Spritz(website URL, etc.)

	/**
	 * Parses the input
	 */
	public void parseInput() {
		while (input.hasNext()){
			token = input.next();
			dataArray.add(token);
		}
	}
	
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
	 */
	public void next() {
		dataArray.next();
	}

	/**
	 * Tells Spritz to move to the previous word in the data array
	 */
	public void previous() {
		dataArray.previous();
	}



}
