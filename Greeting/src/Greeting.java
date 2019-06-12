/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greeting;

import java.util.Date;

/**
 *
 * @author danny
 */
public class Greeting implements Runnable {

 private static final int REPETITIONS = 10;
private static final int DELAY = 1000; 
 private String greeting;
 public void Greeting(String aGreeting)
 {
    greeting = aGreeting;
 }
 
 public void run()
 {
    try
 {
 for (int i = 1; i <= REPETITIONS; i++)
 {
    Date now = new Date();
    System.out.println(now + " " + greeting);
    Thread.sleep(DELAY);
 }
 }
 catch (InterruptedException exception)
 {
 }
 }
}
    
