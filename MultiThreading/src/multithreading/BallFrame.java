/*
    Program Title:  Ball Frame
    Author:         D. Lambord
    Created:        05/12/16
    Version:        1.0
*/
package multithreading;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author danny
 */
public class BallFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new BallPanel();

                final int FRAME_WIDTH = 500;
                final int FRAME_HEIGHT = 500;

                // Set frame attributes
                frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                frame.setTitle("Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                BallComponent component = new BallComponent();
                frame.add(component);
                frame.setVisible(true);
            }
        });
    }

}
