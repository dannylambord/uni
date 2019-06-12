/*
Program Title: StockItemTester
Author: D.Lambord
Created: 30/04/2016
Version: 1.0
*/

package assignment;

public class StockItemTester {
 
    public static void main(String[] args){
        
        StockItem product1 = new StockItem("12345", "Test" , (float) 1.14, 3, 4);//Creation of a new product
        
        System.out.println("Testing toString, expecting to see "
                + "'[Item ID = 12345 Description = Test  Price = £1.14 Quantity = 3 Re-Order level = 4]'");
        System.out.println(product1.toString());
        
        System.out.println("Testing getItemID, expecting to see 12345");
        System.out.println(product1.getItemID()); 
        
        System.out.println("Testing getItemDesc, expecting to see 'Test'");
        System.out.println(product1.getItemDesc()); 
        
        System.out.println("Testing getPrice, expecting to see 1.14");
        System.out.println(product1.getPrice()); 
        
        System.out.println("Testing getQuantity, expecting to see 3");
        System.out.println(product1.getQuantity()); 
        
        System.out.println("Testing getReOrderLevel, expecting to see 4");
        System.out.println(product1.getReOrderLevel());
        
        System.out.println("Testing setPrice, expecting price to be set to 3.23");
        product1.setPrice((float) 3.23);
        System.out.println(product1.toString());
        
        System.out.println("Testing SetQuantity, expecting quantity to be set to 4");
        product1.setQuantity(4);
        System.out.println(product1.toString()); 
        
        System.out.println("Testing setReOrderLevel, expecting re order level to be set to 8");
        product1.setReOrderLevel(8);
        System.out.println(product1.toString());
        
        System.out.printf("", product1.format());
               
    }
}
