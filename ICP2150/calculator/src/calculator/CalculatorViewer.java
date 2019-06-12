/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JFrame;

/**
 *
 * @author eeu689
 */
public class CalculatorViewer
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Creation of a new JFrame
        JFrame frame = new CalculatorFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 300;
        
        // Set frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create and add component to frame
       
        frame.setVisible(true);
    }
    
}
