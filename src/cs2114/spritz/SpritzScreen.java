package cs2114.spritz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.spritz2114.R;

import sofia.app.Screen;
import android.widget.Button;
import android.widget.TextView;

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
    
    /**
     * Creates a new blank screen
     */
    public void initialize() {
    	
        spritz = new Spritz();
        spritzDisplay.setText("");
        
        //TESTING - DOESN'T WORK.
        //is = getResources().openRawResource(R.raw.testfile);
        //InputStreamReader inputStreamReader = new InputStreamReader(is);
        //BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
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
    	next.setEnabled(false);
    	previous.setEnabled(false);
    }
    
    /**
     * The pause button
     */
    public void pauseClicked() {
    	next.setEnabled(true);
    	previous.setEnabled(true);
    }
}
