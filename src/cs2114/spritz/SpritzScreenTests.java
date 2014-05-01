package cs2114.spritz;

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

<<<<<<< HEAD
public class SpritzScreenTests extends student.AndroidTestCase<SpritzScreen>{

	private TextView middleDisplay;
	private TextView headDisplay;
	private TextView tailDisplay;
=======
public class SpritzScreenTests
    extends student.AndroidTestCase<SpritzScreen>
{
    private TextView headDisplay;
    private TextView middleDisplay;
    private TextView tailDisplay;
>>>>>>> c1e325245690357997ac0d316e094e23b35fbaf7
	private Button next;
	private Button previous;
	private Button play;
	private Button pause;
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
        assertEquals(" ", headDisplay.getText());
        assertEquals(" ", middleDisplay.getText());
        assertEquals(" ", tailDisplay.getText());
		assertFalse(next.isEnabled());
		assertTrue(play.isEnabled());
		assertFalse(playing);
	}

	/**
	 * Tests default presentation
	 */
	public void testInitialWithPresentation() {
		click(play);
		click(pause);
<<<<<<< HEAD
		
		click(previous); 
		assertEquals("Quick", middleDisplay.getText().toString());
		
=======

		click(previous);
        assertEquals("Qu", headDisplay.getText().toString());
        assertEquals("i", middleDisplay.getText().toString());
        assertEquals("ck", tailDisplay.getText().toString());

>>>>>>> c1e325245690357997ac0d316e094e23b35fbaf7
		click(previous);
		click(previous);
		click(previous);
		click(previous); //This should make the program wrap to the end.
        assertEquals("En", headDisplay.getText().toString());
        assertEquals("j", middleDisplay.getText().toString());
        assertEquals("oy!", tailDisplay.getText().toString());

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
        assertEquals("Sprit", headDisplay.getText().toString());
        assertEquals("z", middleDisplay.getText().toString());
        assertEquals("2114!", tailDisplay.getText().toString());

		click(next);
        assertEquals("He", headDisplay.getText().toString());
        assertEquals("l", middleDisplay.getText().toString());
        assertEquals("lo", tailDisplay.getText().toString());
		click(previous);
        assertEquals("Sprit", headDisplay.getText().toString());
        assertEquals("z", middleDisplay.getText().toString());
        assertEquals("2114!", tailDisplay.getText().toString());
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
