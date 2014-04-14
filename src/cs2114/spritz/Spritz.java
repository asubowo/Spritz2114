package cs2114.spritz;

import sofia.app.Screen;
import sofia.widget.ImageView;
import java.io.File;
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
	
	
	/**
	 * Constructor for this class
	 */
	public Spritz(){
		testFile = new File("\resources\testFile.txt");
		input = new Scanner(testFile);
	}
	
	
	
	//TODO - We can parse .txt files, so let's place one into the working folder.
	//From there, we can read the .txt file. Or we can try to parse online files
	//instead.
	//Thoughts?
	//I think that will work. We should at least have some back-end stuff to
	//turn in by Wednesday.
}
