/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author danny
 */
public class Timer {

  
        class TimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                // Insert code to be executed on each timer
                // event (e.g. move a shape 1 pixel to right)
            }
        } 
        
    // Create listener and attach it to the timer
    TimerListener listener = new TimerListener();
    Timer t = new Timer(DELAY, listener);
    // Start timer running
    t.start();

}
