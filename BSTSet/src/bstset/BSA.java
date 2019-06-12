package bstset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Random;
import java.util.Collections;

public class BSA {
	static private int [] arrA;
	private int number;
        static int average = 0;
        final static private Random rand = new Random();
	public BSA(int [] arrA){
		this.arrA = arrA;
	}
	public Boolean Search(int low,int high, int number){
		if(low>high){
                    
			return false;
                        
		}
		int mid = low + ((high - low) / 2);
                
		if(arrA[mid]==number){
                    
                    
                    return true;
                }
                
		else if (arrA[mid]>number)
                {
                    
                     average++;
                     
                            return Search(low,mid-1,number);
                }
                
		else
                    
                    average++;
                    return Search(mid+1,high,number);
	}
        
        static int power (int b, int n) {
// Return bn (where n is non-negative).
            int p = 1;
            for (int i = 1; i <= n; i++)
            p *= b;
            return p;
}

	public static void main(String args[])
        {
            int [] a ={} ;
            BSA b = new BSA(a);
		          
            int amount = 0;
            int treeSize = 0;
       
            while (amount < 1000)
            {
                
                int x = 0;
                int bstNode = rand.nextInt(9900) + 100;
                int bstValue = rand.nextInt(9900) + 100;
                treeSize = treeSize + bstValue;
                arrA = generateSorted(bstValue, 100, 10000);
                boolean c = b.Search(0,arrA.length-1,bstNode);
                amount++;

            }
      
            int e = average/1000;
            System.out.println(average);
            System.out.println(treeSize);
            System.out.println(e);
	}
	
        
        public static int[] generateSorted(final int length, final int minVal, final int maxVal)
        {
            ArrayList<Integer> data = new ArrayList<>(length);
            data.add(getRandomVal(minVal, maxVal));

            boolean added;
            for(int i = 0; i < length; i++)
            {
                added = false;
                ListIterator<Integer> itr = data.listIterator();
                int rndNum = getRandomVal(minVal, maxVal);
                while(itr.hasNext() && !added)
                {
                    Integer currentNum = itr.next();
                    if(currentNum >= rndNum)
                    {
                        itr.previous();
                        itr.add(rndNum);
                        added = true;
                    }
                }

                if(!added)//add to end of arrayList
                {
                    data.add(rndNum);
                }
                //printArrList(data);
            }

            return data.stream().mapToInt(i -> {
                return i;
            }).toArray();
        }

       
        /*returns random int between [min, max]*/
        private static int getRandomVal(int min, int max)
        {
            int n = max - min + 1;
            int i = rand.nextInt(n);//nextInt(n) returns random int in [0, n)
            return min + i;
        }

}