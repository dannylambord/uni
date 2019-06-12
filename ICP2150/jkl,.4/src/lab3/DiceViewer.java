/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DiceViewer {
    
        public static void main(String[] args)
    {

        
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 700;
        
        // Set frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("High Low");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dice face = new Dice(6);
        frame.add(face);
        DiceFace DFace = new DiceFace(6, 10,10,6);
        frame.add(DFace);        
        frame.setVisible(true);  
}
}
    

