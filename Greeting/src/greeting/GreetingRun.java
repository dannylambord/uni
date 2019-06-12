/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greeting;


public class GreetingRun {
   
    
    public static void main(String args[]){
        
    Greeting r = new Greeting();
    Greeting r1 = new Greeting();
    
    r.Greeting("Hello");
    r1.Greeting("Goodbye");
 //Greeting r2 = new Greeting("Goodbye");
 Thread t1 = new Thread(r);
 Thread t2 = new Thread(r1);
 t1.start();
 t2.start();
    }
}
