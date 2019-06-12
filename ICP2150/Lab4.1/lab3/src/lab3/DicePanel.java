/*
Program Title: Dice Panel
Author: D.Lambord
Created: 30/10/16
Version: 1.0
*/
package lab3;

import javax.swing.JPanel;

/**
 *
 * @author danny
 */
class DicePanel extends JPanel {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 30;
    private Dice dice;
        public  DicePanel( )
{
    
    dice = new Dice(6);//Creation of new panel
} 
    
}
