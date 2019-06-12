/*
Program Title: Dice Component
Author: D.Lambord
Created: 30/10/16
Version: 1.0
*/

package lab3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author eeu689
 */
public class DiceComponent extends JComponent {
    

       public void paintComponent(Graphics g)
 {
 // recover Graphics2d
   Graphics2D g2 = (Graphics2D) g;
   
        Dice one = new Dice(6);
        Dice two = new Dice(6);
        int first = 0;
        int second = 0;
        //int total;
        first = one.throwDice();//Throwing of first die
        second = two.throwDice();//Throwing of second die
        first = one.getValue();//Getting value of die
        second = two.getValue();
        //total = first + second;

        DiceFace component = new DiceFace(100,50,50,first);//Creation of new die with value generated
        DiceFace component2 = new DiceFace(100,200,50,second);
        component.draw(g2);
        component2.drawred(g2);
        
        g2.setColor(Color.BLACK);
        g2.drawString("Balance £50", 30, 300);
        
        //DiceFrame a = new DiceFrame();
        
        
        //a.playGame(total);
        //System.out.println(total);
        //System.out.println(a);
   
        
    
 }
    
}
