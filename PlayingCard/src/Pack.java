 /* 
 Program Title:  Playing Card
 Author:  D. Lambord
 Created:  22/02/2016
 Version:  1.0 
*/
import java.util.Random;
public class Pack {
    public int i = 51;
    int x=0;
    PlayingCard[] cards = new PlayingCard[52];       
    
        public Pack(){     
            i=51; /*Creation of the variable i to ensure that 52 cards are printed */
             /*Creation of x to place a new card at each position in the pack array*/
            for (int asuit=0; asuit<=3; asuit++) /*Selection of a integer between 0 and 3 for the rank */
        {
                for (int arank=0; arank<=12; arank++)/*Selection of a integer between 0 and 12 for the rank */

             {
                cards[x] = new PlayingCard(arank,asuit); /*Adding the integers into the array at the next possible position*/
                x++;
                System.out.println("Testing Pack class");
                System.out.println(x);
                
             }       
                
        }
        }
        
           
        public PlayingCard shuffle(){
            
         Random number = new Random(); /*Generates a random number whenever number is called */

        int x=0;


        do {
            
            x = number.nextInt( 52 ); /*Genertes a random number between 0 and 52*/

        } while (cards[x] == null);      
        i--; /*Takes 1 from I so that only 52 are printed*/
       

        PlayingCard y = cards[x]; /*Assigning y the rank and suit that is in the array cards*/

        cards[x]= null;/*Assigning the array null so the loop will run again*/

        return y; 
        }
    
}
