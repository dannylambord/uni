/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign2;

/**
 *
 * @author danny
 */
public class Main {
    
    public static void main(String[] args){

        Pack pack = new Pack();

        Assign2 C;
        
        int i = 51;
 

        

 

       while (i != 0 )

       {
           i--;
           
           C = pack.shuffle();

           System.out.println( C.toString() );

       }

    }

    
}
    }
