/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author eeu689
 */
public class CalculatorComponent extends JComponent {
    
          public void paintComponent(Graphics g)
 {
 // recover Graphics2d
   Graphics2D g2 = (Graphics2D) g;
   CalculatorFrame keys = new CalculatorFrame();
   add(keys);
   
   
   
        
   
   
        
    
 }
    
}
