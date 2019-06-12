
package assign2;

 


public class Assign2 {
    public int suit;
    public int rank;
    private static String[] suits = { "♥", "♠", "♦", "♣" };
    private static String[] ranks  = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    
   
    
    public Assign2(int suit, int rank) //Creation of the methof person and creation of new variables
    {
        rank = this.rank;
        suit = this.suit;
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

   
