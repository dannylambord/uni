/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m_thread;

/**
 *
 * @author eeu6d1
 */
public class thread implements Runnable {
   private Thread t;
   private String threadName;
   int x = 0;
   
   thread( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
     
            for(int i = 1; i > 0; i--) 
            {
               System.out.println("Thread: " + threadName + ", " + i);
               // Let the thread sleep for a while.
                x++;              
            }
       
         System.out.println("Thread " +  threadName + " exiting.");
         System.out.println(x);  
      }
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}


