/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;
    
    public class Main {

    public static void main(String[]args)

    {

        Deck deck = new Deck();

        Cards C;

 

        System.out.println( deck.getTotalcards() );

 

       while (deck.getTotalcards()!= 0 )

       {

           C = deck.drawFromDeck();

           System.out.println( C.toString() );

       }

    }

    
}
