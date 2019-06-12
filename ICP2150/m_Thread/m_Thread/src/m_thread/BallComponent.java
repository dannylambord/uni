/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeu6d1
 */

package m_thread;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.JComponent;

public class BallComponent extends JComponent 
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Ball[] balls = new Ball[1000]; // creates threads ball 
        for (int i = 0; i < balls.length; i++) // counter
        {
            balls[i] = new Ball(g2, (int)(Math.random() * 800), (int)(Math.random() * 800)); // places in frame within points 800 x 800
        }
    }
   
   private Thread t;
   private String threadName;
   
   public void RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
    
    public void run() {
        while (true){
            new Ball(g2, (int)(Math.random() * 800), (int)(Math.random() * 800));
            for(int i = 0; i <10; i++)
            {
                
            }
        }
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
    public class TestThread 
    {

    public void main(String args[]) {
      RunnableDemo R1 = new RunnableDemo( "Thread-1");
      R1.start();
      
      RunnableDemo R2 = new RunnableDemo( "Thread-2");
      R2.start();
   }   
}
}
    

