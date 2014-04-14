package cs2114.spritz;

import sofia.app.Screen;
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
public class SpritzScreen {
    
    Spritz spritz;
    
    /**
     * Creates a new blank screen
     */
    public void initialize(){
        spritz = new Spritz();
        textView1.setText("");
    }
}
