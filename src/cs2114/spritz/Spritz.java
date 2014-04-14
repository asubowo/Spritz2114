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
	public Spritz() throws IOException {
		testFile = new File("\resources\testFile.txt");
		input = new Scanner(testFile);
	}
	
}
