package cs2114.spritz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.net.URL;

import com.spritz2114.R;

import sofia.app.Screen;

import android.content.res.AssetManager;

/**
 * This is the logic base for the Spritz application.
 * 
 * @author Andrew Subowo (asubowo)
 * @author Cory Howard (arch518)
 * @author 
 * @version 4.13.2014
 *
 */
public class Spritz extends Screen {

	private File testFile;
	private URL urlTarget;
	private Scanner input;
	private String token;
	private CircularLinkedList<String> dataArray;
	
	/**
	 * Constructor for this class
	 * The default class displays the embedded text file, Lorem Ipsum
	 */
	public Spritz() {

		//TODO
		/*
		 * THIS IS WHAT WE NEED TO DO:
		 * Figure out a way to parse in text files. We can sideload .txt files and read
		 * them.
		 * See this: http://stackoverflow.com/questions/12421814/how-to-read-text-file-in-android
		 * 
		 * OR - we can change our test case up a bit and read a text file found on the
		 * internet instead. Maybe wikipedia for example.
		 */
		
		//The code below DOES NOT WORK for android
		urlTarget = getClass().getResource("testFile.txt");
		testFile = new File(urlTarget.getPath());
		
		
		try {
			input = new Scanner(testFile);
		} catch (FileNotFoundException e) {
			System.out.println("The test file was not found.");
		}
		
		dataArray = new CircularLinkedList<String>();
		parseInput();
	}

	/**
	 * Overloaded constructor - able to take in arguments
	 */
	//public Spritz(website URL, etc.)

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
		dataArray.next();
		return dataArray.getCurrent();
	}

	/**
	 * Tells Spritz to move to the previous word in the data array
	 * @return the string previous in the data array
	 */
	public String previous() {
		dataArray.previous();
		return dataArray.getCurrent();
	}



}
