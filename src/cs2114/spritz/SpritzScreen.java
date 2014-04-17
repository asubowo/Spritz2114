package cs2114.spritz;

import android.widget.Button;
import android.widget.RadioButton;
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
 * @author
 * @version 4.13.2014
 *
 */
public class SpritzScreen extends Screen {


	private Spritz spritz;
	private TextView spritzDisplay;
	private Button next;
	private Button previous;
	private InputStream is;
	private Timer timer;
	private long delay;
	
	/**
	 * Creates a new blank screen
	 */
	public void initialize() {

		spritzDisplay.setText("");
		is = getResources().openRawResource(R.raw.testfile);
		spritz = new Spritz(is);
	}

	/**
	 * The next button
	 */
	public void nextClicked() {
		spritzDisplay.setText(spritz.next());
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
		timer = Timer.callRepeatedly(this, "nextClicked", 200);
	}

	/**
	 * The pause button
	 */
	public void pauseClicked() {
		if (timer.isRunning()) {
			timer.stop();
		}
	}

    // ----------------------------------------------------------
    /**
     * Changes speed to 200 wpm
     */
    public void radio200Clicked() {
        delay = 300;
        this.pauseClicked();
        this.playClicked();
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 300 wpm
     */
    public void radio300Clicked() {
        delay = 200;
        this.pauseClicked();
        this.playClicked();
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 400 wpm
     */
    public void radio400Clicked() {
        delay = 150;
        this.pauseClicked();
        this.playClicked();
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 500 wpm
     */
    public void radio500Clicked() {
        delay = 120;
        this.pauseClicked();
        this.playClicked();
    }

    // ----------------------------------------------------------
    /**
     * Changes speed to 600 wpm
     */
    public void radio600Clicked() {
        delay = 100;
        this.pauseClicked();
        this.playClicked();
    }
}
