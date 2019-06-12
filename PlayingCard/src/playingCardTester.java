 /* 
 Program Title:  Playing Card
 Author:  D. Lambord
 Created:  22/02/2016
 Version:  1.0 
*/
public class playingCardTester {
    
    public static void main(String[] args){
        
        System.out.println("Testing toString expecting to see '[ Rank = 6 , Suit = ♥]'" );
        PlayingCard card1 = new PlayingCard(5,1);
        System.out.println(card1.toString()); 

        System.out.println("Testing format expecting to see '6♥'" );
        PlayingCard card2 = new PlayingCard(1,5);
        System.out.println(card2.format()); 
        
        System.out.println("Testing getSuit expecting to see ♥ " );
        System.out.println(card1.getSuit()); 
        
        System.out.println("Testing getRank expecting to see '6' " );
        System.out.println(card1.getRank()); 
        
        System.out.println("Testing for a shuffled pack of cards");
        Pack pack = new Pack();
        PlayingCard C;
        int i = 51;
       while (i != 0 )
       {
           i--;
           C = pack.shuffle();
           System.out.println( C.toString() );
    }

    
    }
}
    

