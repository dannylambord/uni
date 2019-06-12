/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author danny
 */
public class customer {
    
    
    
    public static int[] cashier1 = new int [10]; //Cashier array
    public static int[] cashier2 = new int [10]; //Cashier array
    public static int[] cashier3 = new int [10]; //Cashier array
    public static String[] cashiers = {"l1", "l2", "l3"};
    
    public static int l1 ;
    public static int l2 ;
    public static int l3 ;
    
    public static String shortest;

    public static int ind1 = 0;
    public static int ind2 = 0;
    public static int ind3 = 0;
    
    public static Scanner sc = new Scanner(System.in);
    public static int i = 0;
    public static int x  = 0;
    public static int z = 0;
    
    
    public static void main(String[] args)
    {
        
        
        System.out.println("Place customer");
        System.out.println("Delete from queue 1");
        System.out.println("Delete from queue 2");
        System.out.println("Delete from queue 3");
        System.out.println("Press 5 to exit");
        System.out.println("Please press 1,2,3,4,5");
        
        
            
         while( x != 1 ){
        i = sc.nextInt();
        
        switch(i){
            case 1:
                
                z = 0;
                insert();
                break;
                
            case 2:
                delete("l1");
                break;
                
            case 3:
                delete("l2");
                break;
                
            case 4:
                delete("l3");
                break;
                
            case 5:
                x = 1;
                
            case 6: 
                System.out.println("l1 = " + Arrays.toString(cashier1) );
                System.out.println("l2 = " + Arrays.toString(cashier2));
                System.out.println("l3 = " + Arrays.toString(cashier3));
        }
        
        }
        

    }
    
    public static void insert(){
        
     
         while(z != 10)
         {
            int n = (int) Math.floor(Math.random() * 101);
            getShortest();
            
            if(shortest == "l1")
            {   
                if(cashier1[ind1] == 0)
                {
                

                cashier1[ind1] = n;
                ind1++;
                z++;
                System.out.println(Arrays.toString(cashier1));
                }else{
                    break;
                }
                
            }
            
            else if(shortest == "l2")
            {
                if(cashier2[ind2] == 0)
                {
               
                cashier2[ind2] = n;
                ind2++;
                z++;
                System.out.println(Arrays.toString(cashier2));
                }else{
                     break;
                }
                
            }
            
            else if(shortest == "l3")
            {
                if(cashier3[ind3] == 0)
                {
                
                cashier3[ind3] = n;
                ind3++;
                z++;
                System.out.println(Arrays.toString(cashier3));
                }else{
                    break;
                }
                
            }
         }
            
            
            
            
            
        
    }
    
    public static String getShortest()
    {
        int x1= 0;
        int x2= 0;
        int x3= 0;
        shortest = null;
        
        for(int l=0; l<cashier1.length;l++)   
     {
         
         
         if(cashier1[l] == 0)
         {
             x1++;
             
         }
     }
        
          for(int l=0; l<cashier2.length;l++)   
     {
         
         
         if(cashier2[l] == 0)
         {
             x2++;
             
         }
     }
            for(int l=0; l<cashier3.length;l++)   
     {
         
         
         if(cashier3[l] == 0)
         {
             x3++;
             
         }
     }
            
          if(x1>x2 && x1>x3 )
              
          {
              shortest = "l1";
          }
          
          else if(x2>x1 && x2>x3)
              
          {
              shortest = "l2";
          }
            
          else if(x3>x1 && x3>x2)
              
          {
              shortest = "l3";
          }
          else
            {
                int e = (int) Math.floor(Math.random() * 3);
                shortest = cashiers[e];
                System.out.println(shortest);
            }
              
         
          
         
          
        return shortest;
        
    }
    
    public static void delete(String a)
    {
        if(a == "l1")
        {
            cashier1[0] = 0;
            for(int i=0;i<cashier1.length-1;i++)
            { 
                cashier1[i] = cashier1[i+1];
            }
            ind1--;
            
            
        }
        else if(a == "l2")
        {
            cashier2[0] = 0;
            for(int i=0;i<cashier2.length-1;i++)
            { 
                cashier2[i] = cashier2[i+1];
            }
            ind2--;
            
            
        }
        else if(a == "l3")
        {
            cashier3[0] = 0;
            for(int i=0;i<cashier3.length-1;i++)
            { 
                cashier3[i] = cashier3[i+1];
            }
            ind3--;
            
            
        }
    }
}

    
   


