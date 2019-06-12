/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author eeu689
 */
/*
	Revised and tested 10/06/2010
*/

import java.util.Random;
import javax.swing.JComponent;

public class Dice  extends JComponent
{
     private Random generator;
     private int sides;
     private int value;

     public Dice(int noSides)
     {
         generator = new Random();
	 sides = noSides;
         value = 1 + generator.nextInt(sides);
         
     }

     public int throwDice()
     {        
         value = 1 + generator.nextInt(sides);
			return value;
     }
     
     public int getValue()
     {
          return value;
     }
     
	  // Use for program testing
    public void setValue(int v)
    {
        value = v;
    }
}
