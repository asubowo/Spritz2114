package cs2114.spritz;

import sofia.app.Screen;
import sofia.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import student.TestCase;

/**
 * This is the test class for the Spritz application logic base.
 * 
 * @author Andrew Subowo (asubowo)
 * @author Cory Howard (arch518)
 * @author 
 * @version 4.13.2014
 *
 */

public class SpritzTest extends TestCase{

	private Spritz app;
	
	/**
	 * Set up method - called before every test method
	 */
	public void setUp() {
		//Nothing to do here
	}
	
	/**
	 * Tests file parsing and input
	 */
	public void testParse() {
		try {
			app = new Spritz();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		app.parseInput();
		System.out.println(app.print());
	}
}
