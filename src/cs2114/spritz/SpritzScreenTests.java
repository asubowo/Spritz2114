package cs2114.spritz;

import sofia.app.Screen;
import sofia.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.IOException;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This is the test class for the Spritz application logic base.
 * 
 * @author Andrew Subowo (asubowo)
 * @author Cory Howard (arch518)
 * @author Meghan Hamannwright (meghankh)
 * @version 4.13.2014
 *
 */

public class SpritzScreenTests extends student.AndroidTestCase<SpritzScreen>{

	private TextView spritzDisplay;
	private Button next;
	private Button previous;
	private Button play;
	private Button pause;
	private InputStream is;
	private int delay;
	private boolean playing;
	private EditText inputText;

	// ----------------------------------------------------------
	/**
	 * Test cases that extend AndroidTestCase must have a parameterless
	 * constructor that calls super() and passes it the screen/activity class
	 * being tested.
	 */
	public SpritzScreenTests() {
		super(SpritzScreen.class);
	}

	/**
	 * Set up method - called before every test method
	 */
	public void setUp() {
		//Nothing to do here
	}

	/**
	 * Tests the initialization
	 */
	public void testInitial() {
		assertFalse(previous.isEnabled());
		assertEquals("", spritzDisplay.getText());
		assertFalse(next.isEnabled());
		assertTrue(play.isEnabled());
		assertFalse(playing);
		assertEquals(200, delay);
	}
	
	/**
	 * Tests input text field
	 */
	public void testInputField() {
		enterText(inputText, "Hello world, welcome to Spritz2114!");
		click(play);
		click(pause);
		assertTrue(play.isEnabled());
		assertTrue(next.isEnabled());
		assertTrue(previous.isEnabled());
		assertEquals("Hello", spritzDisplay.getText());
		
		click(next);
		assertEquals("world,", spritzDisplay.getText());
		click(previous);
		assertEquals("Hello", spritzDisplay.getText());
	}
	
	/**
	 * Tests empty text input
	 */
	public void testEmptyInput() {
		enterText(inputText, "");
		assertFalse(play.isEnabled());
		assertFalse(previous.isEnabled());
		assertFalse(next.isEnabled());
	}
}
