/*
Program Title: Dice Frame
Author: D.Lambord
Created: 30/10/16
Version: 1.0
*/
package lab3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 *
 * @author eeu689
 */
public class DiceFrame extends JFrame {
    
    int x;
    int w;
    String y;
    
    private DicePanel dicePanel;
    JButton roll;//Creation of global Jbutton
    JRadioButton sevens;
    JRadioButton high;
    JRadioButton low;
    
    public DiceFrame()
    {
        
        dicePanel = new DicePanel();//Creating panel
        add(dicePanel, BorderLayout.CENTER);
        createControlPanel();
        
    }
    

    
    public void createControlPanel( )
    {
        String[] bets = {"£10", "£5", "£1"};//Array of combo box values
        JComboBox betBox = new JComboBox(bets);
        
        high = new JRadioButton("High");//Assigning strings to radio button
        low = new JRadioButton("Low");
        sevens = new JRadioButton("Sevens");   

        ButtonGroup radio = new ButtonGroup();// Grouping of radio buttons
        radio.add(high);
        radio.add(low);
        radio.add(sevens);

        roll = new JButton("Roll Dice");//Assigning string to button
        ActionListener listener = new ButtonListener();//Creation of new action listener 
        roll.addActionListener(listener);//Assigning listener to button
        roll.setEnabled(false);//Greying out of button


        high.addActionListener(listener);
        low.addActionListener(listener);
        sevens.addActionListener(listener);

        // Lower panel holding UI components
        JPanel controlPanel = new JPanel();//Creation of new panel

        controlPanel.add(roll);//Adding object to panel
        controlPanel.add(high);
        controlPanel.add(low);
        controlPanel.add(sevens);
        controlPanel.add(betBox);
        add(controlPanel, BorderLayout.SOUTH);//Positioning of panel
        
    }


    
    public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource( ) == roll)
                repaint();//repainting dice if roll button is pressed
            roll.setEnabled(false);
            if(event.getSource() != roll)
                    {
                   roll.setEnabled(true);//If button pressed isn't roll activate button
                    }
            if(event.getSource() == low)
                    {
                        x = 6;
                    }
            if(event.getSource() == sevens)
                    {
                         x = 7;
                    }
            if(event.getSource() == high)
                    {
                        x = 8;
                    }
        }
        
    
    
    }
    
   /* public void playGame(int total)
    {
        w = total;
        System.out.println(x);
        
            if( x == 6 && x <= w){
                y = "Win";
                System.out.println(y);
            }
            else if(x == 6 && x >= 7){
                 y = "lose";
                 System.out.println(y);
            }
            else if(x == 7 && w == 7)
            {
                
                y = "Win";
                System.out.println(y);
            }
            else if(x == 7 && w != 7)
            {
                
                y = "lose";
                System.out.println(y);
            }
             else if(x == 8 && w >= x)
            {
                
                y = "Win";
                System.out.println(y);
            }
            
             else if(x == 8 && w <= 7)
            {
                
                y = "Lose";
                System.out.println(y);
            }
            
            
    }*/

} 

      
    


                                                        