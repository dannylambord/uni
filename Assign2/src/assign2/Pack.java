/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign2;

import java.util.Random;

/**
 *
 * @author danny
 */
public class Pack {
    
       int i = 51;
        
        Assign2[] cards = new Assign2[52];        
     /*
     * @param args
     */
    
    
         
        public Pack()    {     
            
            i=51;
            int x=0;
            cards = new Assign2[52];
            for (int a=0; a<=3; a++)
        {
                for (int b=0; b<=12; b++)

             {
                cards[x] = new Assign2(a,b);
                x++;
                
             }       
                
        }
        }
        
           
        public Assign2 shuffle(){
            
         Random generator = new Random();

        int index=0;


        do {
            
            index = generator.nextInt( 52 ); /*Genertes a random number between 0 and 52*/

        } while (cards[index] == null);       
        i--; /*Takes 1 from I so that only 52 are printed*/
       

        Assign2 temp = cards[index];

        cards[index]= null;

        return temp; 
        }
    /**
     * Shuffles cards in pack.
     * @param args
     */public int getTotalcards()

    {

        return i;

    }
        
        
}
        /**    * @return string representation of 52 card pack.    */    
   
    
    

       



