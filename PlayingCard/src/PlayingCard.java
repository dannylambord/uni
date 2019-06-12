 /* 
 Program Title:  Playing Card
 Author:  D. Lambord
 Created:  22/02/2016
 Version:  1.0 
*/
public class PlayingCard {
    
    public int suit;
    public int rank;
    private static String[] suits = { "♥", "♠", "♦", "♣" }; /*Creation of an array to store suits*/
    private static String[] ranks  = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };/*Creation of an array to store ranks*/
    
   
    
    public PlayingCard(int arank, int asuit) 
    {
        rank = arank;
        suit = asuit;
    }
    
    public String toString(){
        System.out.println(rank + " " + suit);
     return " [ Rank = " + ranks[rank] + " , Suit = " + suits[suit] + "]";

    }
      
    public int getSuit() {
        return suit;
    }
    
    public int getRank() {
     return rank;
    }
    
     public String format(){
     
     return  ranks[rank] +  suits[suit];

    }
    
}
