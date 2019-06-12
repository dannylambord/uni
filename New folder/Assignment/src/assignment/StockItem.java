/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author eeu689
 */
public class StockItem {

    public String itemID; // Five alpha-numeric characters
    public String itemDesc; // Item description
    public double price; // Item price in pounds sterling
    public int quantity; // Quantity in stock
    public int reOrderLevel; // Level at which to re-order

public StockItem(String aID, String aDesc, double aPrice, int aQuantity, int aReOrd) 
    {
        itemID = aID;
        itemDesc = aDesc;
        price = aPrice;
        quantity = aQuantity;
        reOrderLevel = aReOrd;
    }
    
public String toString() {

 return " [Item ID = " + getItemID() + " Description = " + getItemDesc() + " Price = £" +
         getPrice() + " Quantity = " + getQuantity() + " Re-Order level = " + getReOrderLevel() + "]";
}

public String getItemID(){
    return itemID;
}

public String getItemDesc(){
    return itemDesc;
}

public double getPrice(){
    return price;
}

public int getQuantity(){
    return quantity;
}

public int getReOrderLevel(){
    return reOrderLevel;
}

public double setPrice(double p){
    
    price = p;
    return price;
}

public int setQuantity(int q){
    

    quantity = q;
    return quantity;
}

public int setReOrderLevel(int r){
    

    reOrderLevel = r;
    return reOrderLevel;
}


}