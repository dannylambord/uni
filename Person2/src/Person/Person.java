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
public class Person {

    /**
     * @param args the command line arguments
     */
     private String Fname; //Declaration of the string Fname as private
     private String Lname;
     private double age;
     private double height;
     private char gender;
     
     private int id; //Creation of the ID variable as private
     public static int numberOfPeople = 0; //Declaration of the variable numberOfPeople as private static with a value of 0
    
  
    public Person(String aFname,  String aLname, double aage,double aheight,char agender) //Creation of the methof person and creation of new variables
    {
    
        Fname = aFname; //Assigning value to variable
        Lname = aLname;
        age = aage;
        height = aheight;
        gender = agender;
        
        id = ++numberOfPeople;//Incrementing the value of ID by the value of numberOfPeople
         
        
    }
   
    
    
    public String getFname() //Declaring a get method for Fname
    {
        return Fname; //Returning the value of Fname
    }
    
    public String getLname()
    {
        return Lname;
    }
    
    public double getage()
    {
        return age;
    }
    
    public double getheight()
    {
        return height;
    }
    
    public char getgender()
    {
        return gender;
    }
    
    public String toString() {  //Declaration of a tostring method
        return getFname() + " " +
            getLname() + " " +
            getage() + " " +
            getheight() + " " +
            getgender(); // Returns the concatenated string from the tostring
    }
    
    public int getID()
    {
        return id; //Returns the ID value
    }
    
    public static int getNumberOfPeople()  //Declaration of static int as a get method
    {
        return numberOfPeople;
    }
}
    

