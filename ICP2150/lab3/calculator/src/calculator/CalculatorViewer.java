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
public class CalculatorViewer extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Creation of a new JFrame
        CalculatorFrame frame = new CalculatorFrame();
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;
        
        // Set frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create and add component to frame
        CalculatorComponent component = new CalculatorComponent();
        frame.add(component);
        frame.setVisible(true);
    }
    
}
