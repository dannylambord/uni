/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;
import java.util.Random;
public class Cards{
    
    private int rank, suit;
    private static String[] suits = { "♥", "♠", "♦", "♣" };
    private static String[] ranks  = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
  
    Cards(int suit, int rank)

    {

        this.rank=rank;

        this.suit=suit;

    }

    
    public String toString(){
     
     return " [ Rank = " + ranks[rank] + " , Suit = " + suits[suit] + "]";

    }
      
    public int getSuit() {
        return suit;
    }
    
    public int getRank() {
     return rank;
    }
}
    

   




