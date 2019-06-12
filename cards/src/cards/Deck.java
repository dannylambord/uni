/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.util.Random;

/**
 *
 * @author danny
 */
public class Deck {

    private Cards[] cards;

    int i;

 

    Deck()

    {

        i=51;

        cards = new Cards[52];

        int x=0;
        for (int a=0; a<=3; a++)
        {
            for (int b=0; b<=12; b++)

             {

               cards[x] = new Cards(a,b);
               
               x++;

             }

        }

    }

    public Cards drawFromDeck()

    {

        Random generator = new Random();

        int index=0;


        do {
            
            index = generator.nextInt( 52 ); /*Genertes a random number between 0 and 52*/

        } while (cards[index] == null);       
        i--; /*Takes 1 from I so that only 52 are printed*/
       

        Cards temp = cards[index];

        cards[index]= null;

        return temp;

    }
    
     public int getTotalcards()

    {

        return i;

    }
}
