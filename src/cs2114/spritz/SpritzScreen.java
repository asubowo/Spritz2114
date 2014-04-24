package cs2114.spritz;

import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;
import com.spritz2114.R;

import sofia.app.Screen;
import android.widget.TextView;
import sofia.util.Timer;

/**
 * This is the screen for the Spritz application.
 *
 * @author Andrew Subowo (asubowo)
 * @author Cory Howard (arch518)
 * @author Meghan Hamannwright (meghankh)
 * @version 4.13.2014
 *
 */
public class SpritzScreen extends Screen {


	private Spritz spritz;
	private TextView spritzDisplay;
	private Button next;
	private Button previous;
	private Button play;
	private Button pause;
	private InputStream is;
	private int delay;
	private boolean playing;
	private EditText inputText;

	/**
	 * Creates a new blank screen
	 */
	public void initialize() {

		spritzDisplay.setText("");
		is = getResources().openRawResource(R.raw.testfile);
		spritz = new Spritz(is);				
        pause.setEnabled(false);
        delay = 200;
        playing = false;
	}

	/**
	 * The next button
	 */
	public void nextClicked() {
        spritzDisplay.setText(spritz.next());
	    if (spritz.end()) {
            this.pauseClicked();
        }
        else if (playing)
        {
            Timer.callOnce(this, "nextClicked", delay);
        }
	}

	/**
	 * The previous button
	 */
	public void previousClicked(){
		spritzDisplay.setText(spritz.previous());
	}

	/**
	 * The play button
	 */
	public void playClicked() {
		playing = true;
		play.setEnabled(false);
		next.setEnabled(false);
		previous.setEnabled(false);
		pause.setEnabled(true);
		Timer.callOnce(this, "nextClicked", delay);

	}

	/**
	 * The pause button
	 */
	public void pauseClicked() {
	    playing = false;
		play.setEnabled(true);
		pause.setEnabled(false);
		next.setEnabled(true);
		previous.setEnabled(true);
	}

    // ----------------------------------------------------------
    /**
     * Changes speed to 200 wpm
     */
    public void radio200Clicked() {
        delay = 300;
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 300 wpm
     */
    public void radio300Clicked() {
        delay = 200;
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 400 wpm
     */
    public void radio400Clicked() {
        delay = 150;
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 500 wpm
     */
    public void radio500Clicked() {
        delay = 120;
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 600 wpm
     */
    public void radio600Clicked() {
        delay = 100;
    }

    // ----------------------------------------------------------
    /**
     * Resets the spritz text back to the beginning
     */
    public void resetClicked() {
        this.pauseClicked();
        spritz.reset();
        spritzDisplay.setText("");
    }
    
    /**
     * Check that text has been inputed
     */
    public void inputTextEditingDone()
    {
    	spritz.clear();
    	spritz.parseStringTxt(inputText.getText().toString());
    	
    }
}
