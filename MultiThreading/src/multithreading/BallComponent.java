/*
    Program Title:  Ball Component
    Author:         D. Lambord
    Created:        05/12/16
    Version:        1.0
*/

package multithreading;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author danny
 */
public class BallComponent extends JComponent 
{
  
    int x  = 10;
    int y = 10;
    Timer tm;
    

    public void animBall(Graphics g)
    {
     x = (int )(Math.random() *450  + 1);//Generating random x and y co-ords
     y = (int )(Math.random() * 350 + 1);

     Graphics2D g2 = (Graphics2D) g;
     System.out.println(x);
     System.out.println(y);
     
     ActionListener timer = new ActionListener() 
     {
            public void actionPerformed(ActionEvent evt) 
            {
                
                if(x != 400 | y != 400)//Makes sure that the ball is moving within the frame boundaries
                {
                    x++;
                    y++;
                    repaint();
                }   
            }
        };
        tm = new Timer(80, timer);//New instance of timer with delay an action listener supplied
        g.fillOval(x, y, 30,30);
        tm.start();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
     //animBall(g);
    }
 }

