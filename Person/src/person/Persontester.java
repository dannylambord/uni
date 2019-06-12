/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

/**
 *
 * @author danny
 */
public class Persontester {
    
    public static void main(String[] args)
    {
        Person person1 = new Person("joe","smith",25,1.57,'m'); //Creation of a new person using explicit perameters
        System.out.println(person1.toString()); //Placing of data into the todtring method and printing to screen
        Person person2  = new Person("Sian","dion",39,1.69,'f');
        System.out.println(person2.toString());
        
        System.out.println("Testing getName, expecting to see 'Sian'");
        System.out.println("Result : " + person2.getFname());
        
        System.out.println("Number of objects created : " + Person.getNumberOfPeople());
    }
    
}

