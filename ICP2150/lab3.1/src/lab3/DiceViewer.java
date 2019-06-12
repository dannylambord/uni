/*
Program Title: Dice Viewer
Author: D.Lambord
Created: 30/10/16
Version: 1.0
*/
package lab3;

import javax.swing.JFrame;


public class DiceViewer {
    
        public static void main(String[] args)
    {

        
        JFrame frame = new DiceFrame();//Creation of DiceFrame
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;
        // Set frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("High Low");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DiceComponent dFace = new DiceComponent();
        frame.add(dFace);
        frame.setVisible(true);  
}
}
    

